package edu.miu.cs545.project.systemhealth;

import org.springframework.stereotype.Component;

@Component
public class ExtracurricularActivityServiceHealthIndicator extends SystemHealth {
    @Override
    protected String getUrl() {
        return String.format("%s/%s", this.url, "extracurricular-activity/all");
    }
}
