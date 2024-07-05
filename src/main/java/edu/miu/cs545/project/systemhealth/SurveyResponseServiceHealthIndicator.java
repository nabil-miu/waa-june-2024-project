package edu.miu.cs545.project.systemhealth;

import org.springframework.stereotype.Component;

@Component
public class SurveyResponseServiceHealthIndicator extends SystemHealth {
    @Override
    protected String getUrl() {
        return String.format("%s/%s", this.url, "survey-responses/all");
    }
}
