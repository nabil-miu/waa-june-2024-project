package edu.miu.cs545.project;

import edu.miu.cs545.project.service.StorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Tag(name = "Project", description = "Project API")
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return args -> {
            storageService.init();
        };
    }
}
