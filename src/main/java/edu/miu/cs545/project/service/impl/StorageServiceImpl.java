package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.AcademicResource;
import edu.miu.cs545.project.model.entity.User;
import edu.miu.cs545.project.repository.ResourceRepo;
import edu.miu.cs545.project.service.StorageService;
import edu.miu.cs545.project.exception.StorageException;
import edu.miu.cs545.project.exception.StorageFileNotFoundException;
import edu.miu.cs545.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    private final Path rootLocation;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private UserService userService;

    @Autowired
    public StorageServiceImpl(@Value("${storage.location}") String location) {
        if (location.isEmpty()) {
            throw new StorageException("File upload location can not be Empty.");
        }
        this.rootLocation = Paths.get(location);
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file, Long userId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory."
                );
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            if (fileName.contains("..")) {
                throw new StorageException("Filename contains invalid path sequence " + fileName);
            }
            if (file.getBytes().length > (1024 * 1024)) {
                throw new StorageException("File size exceeds maximum limit");
            }
            AcademicResource resource = new AcademicResource();
            User user = userService.getById(userId).orElseThrow();
            resource.setName(fileName);
            resource.setUrl(destinationFile.toString());
            resource.setUser(user);
            resourceRepo.save(resource);
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void delete(String filename) throws IOException {
        try {
            logger.info("Attempting to delete resource: {}", filename);
            resourceRepo.deleteAcademicResourceByName(filename);
            Path filePath = rootLocation.resolve(filename);
            if (Files.exists(filePath)) {
                logger.info("Deleting file at path: {}", filePath);
                Files.delete(filePath);
            } else {
                logger.warn("File not found: {}", filePath);
            }
            logger.info("Resource deleted successfully: {}", filename);
        } catch (IOException e) {
            logger.error("Error deleting file: {}", filename, e);
            throw e;
        } catch (Exception e) {
            logger.error("Error deleting resource from repository: {}", filename, e);
            throw new IOException("Could not delete resource: " + filename, e);
        }
    }
}
