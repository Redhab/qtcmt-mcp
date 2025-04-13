package com.qlik.qtcmt.mcp.controller;


import com.qlik.qtcmt.mcp.provider.McpToolProvider;
import com.qlik.qtcmt.mcp.dto.ProjectAnalysisRequest;
import com.qlik.qtcmt.mcp.dto.ProjectLoadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcp")
public class McpAiToolController {

    private final McpToolProvider mcpToolProvider;

    @Autowired
    public McpAiToolController(McpToolProvider mcpToolProvider) {
        this.mcpToolProvider = mcpToolProvider;
    }

    @PostMapping("/loadProject")
    public ResponseEntity<ProjectLoadResponse> loadProject(
            @RequestBody ProjectLoadRequest request
    ) {
        ProjectLoadResponse response = mcpToolProvider.loadProject(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/analyseProject")
    public ResponseEntity<ProjectAnalysisResponse> analyseProject(
            @RequestBody ProjectAnalysisRequest request
    ) {
        ProjectAnalysisResponse response = mcpToolProvider.analyseProject(request);
        return ResponseEntity.ok(response);
    }
}