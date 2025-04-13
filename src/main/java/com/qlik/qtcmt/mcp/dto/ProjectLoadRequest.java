package com.qlik.qtcmt.mcp.dto;

import lombok.Data;

@Data
public class ProjectLoadRequest {
    private String projectId;
    private String sourceRepository;
    private String branch;
}
