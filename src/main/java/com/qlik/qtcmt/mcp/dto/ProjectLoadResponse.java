package com.qlik.qtcmt.mcp.dto;

import lombok.Data;

@Data
public class ProjectLoadResponse {
    private String status;
    private String errorMessage;
    private String projectPath;
}
