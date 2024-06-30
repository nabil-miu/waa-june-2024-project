package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.storage.StorageFileNotFoundException;
import edu.miu.cs545.project.storage.StorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/resource")
@Tag(name = "Resources", description = "Resource API")
@RequiredArgsConstructor
public class FileUploadController {

    private final StorageService storageService;

    // Looks up the current list of uploaded files
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    // Loads the resource (if it exists) and sends it to the browser to download
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<Map<String, String>> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        Map<String, String> response = new HashMap<>();
//
//        response.put("fileName", file.getOriginalFilename());
//        response.put("fileSize", String.valueOf(file.getSize()));
//        response.put("contentType", file.getContentType());
//
//        response.put("message", "File upload done");
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

//    @PostMapping("/single/upload")
//    public ResponseEntity<String> fileUploading(@RequestParam("file") MultipartFile file) {
//        // Code to save the file to a database or disk
//        return ResponseEntity.ok("Successfully uploaded the file");
//    }
}
