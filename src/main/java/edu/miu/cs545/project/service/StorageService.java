package edu.miu.cs545.project.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageService {

    void init();

    void store(MultipartFile file, Long userId);

    Path load(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename) throws IOException;
}
