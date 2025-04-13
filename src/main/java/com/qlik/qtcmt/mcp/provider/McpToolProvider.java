package com.qlik.qtcmt.mcp.provider;

import com.qlik.qtcmt.mcp.dto.ProjectAnalysisRequest;
import com.qlik.qtcmt.mcp.dto.ProjectLoadRequest;
import com.qlik.qtcmt.mcp.service.McpMetricsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class McpToolProvider {
    private final McpMetricsService metricsService;

    @Autowired
    public McpToolProvider(McpMetricsService metricsService) {
        this.metricsService = metricsService;
    }

    // ... (previous code remains the same)

    @Tool(name = "loadProject",
            description = "Load a project from a specified source repository")
    public ProjectLoadResponse loadProject(ProjectLoadRequest request) {
        log.info("Loading project: {}", request.getProjectId());

        ProjectLoadResponse response = new ProjectLoadResponse();

        try {
            // Validate input
            if (request.getProjectId() == null || request.getSourceRepository() == null) {
                response.setStatus("ERROR");
                response.setErrorMessage("Project ID and Source Repository are required");
                metricsService.incrementProjectLoad(false);
                return response;
            }

            // Simulate project loading
            String projectPath = "/projects/" + request.getProjectId();

            response.setStatus("SUCCESS");
            response.setProjectPath(projectPath);

            metricsService.incrementProjectLoad(true);
            return response;
        } catch (Exception e) {
            log.error("Project load error", e);
            response.setStatus("ERROR");
            response.setErrorMessage(e.getMessage());
            metricsService.incrementProjectLoad(false);
            return response;
        }
    }

    @Tool(name = "analyseProject",
            description = "Perform comprehensive analysis on a loaded project")
    public ProjectAnalysisResponse analyseProject(ProjectAnalysisRequest request) {
        log.info("Analyzing project: {} with type: {}",
                request.getProjectId(),
                request.getAnalysisType());

        ProjectAnalysisResponse response = new ProjectAnalysisResponse();

        try {
            // Validate input
            if (request.getProjectId() == null) {
                response.setStatus("ERROR");
                metricsService.incrementProjectAnalysis(false);
                return response;
            }

            // Simulate analysis based on type
            switch (request.getAnalysisType()) {
                case QUICK:
                    response.setAnalysisReport("Quick analysis completed");
                    response.setFindingsCount(5);
                    break;
                case FULL:
                    response.setAnalysisReport("Comprehensive analysis completed");
                    response.setFindingsCount(25);
                    break;
                case DEPENDENCY:
                    response.setAnalysisReport("Dependency analysis completed");
                    response.setFindingsCount(10);
                    break;
                case SECURITY:
                    response.setAnalysisReport("Security analysis completed");
                    response.setFindingsCount(15);
                    break;
                default:
                    response.setStatus("ERROR");
                    response.setAnalysisReport("Unknown analysis type");
                    metricsService.incrementProjectAnalysis(false);
                    return response;
            }

            response.setStatus("SUCCESS");
            metricsService.incrementProjectAnalysis(true);
            return response;
        } catch (Exception e) {
            log.error("Project analysis error", e);
            response.setStatus("ERROR");
            metricsService.incrementProjectAnalysis(false);
            return response;
        }
    }
}