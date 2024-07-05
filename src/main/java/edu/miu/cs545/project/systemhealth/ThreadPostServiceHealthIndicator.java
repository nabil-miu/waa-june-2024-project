package edu.miu.cs545.project.systemhealth;

import org.springframework.stereotype.Component;

@Component
public class ThreadPostServiceHealthIndicator extends SystemHealth {
    @Override
    protected String getUrl() {
        return String.format("%s/%s", this.url, "thread-posts/all");
    }
}
