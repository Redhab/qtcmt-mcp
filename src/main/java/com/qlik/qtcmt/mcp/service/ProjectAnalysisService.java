package com.qlik.qtcmt.mcp.service;


import com.qlik.qtcmt.mcp.dto.ProjectAnalysisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProjectAnalysisService {
    private final RestClient restClient;

    @Value("${qtcmt.api.analysis.url}")
    private String analysisProjectApiUrl;

    @Autowired
    public ProjectAnalysisService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Object analyseProject(ProjectAnalysisRequest request) {
        return restClient.post()
                .uri(analysisProjectApiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(Object.class);
    }
}
