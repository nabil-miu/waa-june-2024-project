package edu.miu.cs545.project.systemhealth;

import lombok.extern.java.Log;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Log
@Component
public class SystemHealth implements HealthIndicator {

    protected String url = "http://localhost:8080/api/v1";

    protected String getUrl() {
        // Default URL, can be overridden by subclasses
        return this.url;
    }

    @Override
    public Health health() {
        try (Socket socket =
                     new Socket(new java.net.URL(getUrl()).getHost(), 8080)) {
        } catch (Exception e) {
            log.warning(String.format("Failed to connect to: %s", getUrl()));
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
        return Health.up().build();
    }
}