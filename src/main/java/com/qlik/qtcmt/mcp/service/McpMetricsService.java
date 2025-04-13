package com.qlik.qtcmt.mcp.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class McpMetricsService {
    private final Counter projectLoadCounter;
    private final Counter projectAnalysisCounter;
    private final Counter projectLoadErrorCounter;
    private final Counter projectAnalysisErrorCounter;

    public McpMetricsService(MeterRegistry registry) {
        // Project Load Metrics
        projectLoadCounter = Counter.builder("mcp_project_load_total")
                .description("Total number of project load attempts")
                .register(registry);

        projectLoadErrorCounter = Counter.builder("mcp_project_load_errors_total")
                .description("Total number of project load errors")
                .register(registry);

        // Project Analysis Metrics
        projectAnalysisCounter = Counter.builder("mcp_project_analysis_total")
                .description("Total number of project analysis attempts")
                .register(registry);

        projectAnalysisErrorCounter = Counter.builder("mcp_project_analysis_errors_total")
                .description("Total number of project analysis errors")
                .register(registry);
    }

    public void incrementProjectLoad(boolean success) {
        projectLoadCounter.increment();
        if (!success) {
            projectLoadErrorCounter.increment();
        }
    }

    public void incrementProjectAnalysis(boolean success) {
        projectAnalysisCounter.increment();
        if (!success) {
            projectAnalysisErrorCounter.increment();
        }
    }
}