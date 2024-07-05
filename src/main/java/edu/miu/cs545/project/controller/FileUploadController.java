package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.aop.LogExecutionTime;
import edu.miu.cs545.project.service.StorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/resource")
@Tag(name = "Resources", description = "Resource API")
@RequiredArgsConstructor
public class FileUploadController {

    private final StorageService storageService;

    // Loads the resource (if it exists) and sends it to the browser to download
    @GetMapping("/files/{filename:.+}")
    @LogExecutionTime
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @LogExecutionTime
    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @RequestParam Long userId) {

        storageService.store(file, userId);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @LogExecutionTime
    @DeleteMapping("/files/{filename:.+}")
    public ResponseEntity<Void> delete(@PathVariable String filename) throws IOException {
        storageService.delete(filename);
        return ResponseEntity.noContent().build();
    }

}
