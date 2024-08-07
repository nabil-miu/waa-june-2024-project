package edu.miu.cs545.project.systemhealth;

import org.springframework.stereotype.Component;

@Component
public class AttendanceServiceHealthIndicator extends SystemHealth {
    @Override
    protected String getUrl() {
        return String.format("%s/%s", this.url, "attendances/all");
    }
}
