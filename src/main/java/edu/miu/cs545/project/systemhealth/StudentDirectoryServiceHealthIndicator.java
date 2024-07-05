package edu.miu.cs545.project.systemhealth;

import org.springframework.stereotype.Component;

@Component
public class StudentDirectoryServiceHealthIndicator extends SystemHealth {
    @Override
    protected String getUrl() {
        return String.format("%s/%s", this.url, "students-directory/all");
    }
}
