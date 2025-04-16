package com.qlik.qtcmt.mcp.service;

// Updated Project Load Service
import com.qlik.qtcmt.mcp.dto.ProjectLoadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProjectLoadService {
    private final RestClient restClient;

    @Value("${qtcmt.api.load.url}")
    private String loadProjectApiUrl;

    @Autowired
    public ProjectLoadService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Object loadProject(ProjectLoadRequest request) {
        return restClient.post()
                .uri(loadProjectApiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(Object.class);
    }
}
