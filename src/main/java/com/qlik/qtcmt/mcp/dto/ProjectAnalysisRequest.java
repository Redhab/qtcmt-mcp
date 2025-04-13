package com.qlik.qtcmt.mcp.dto;


import lombok.Data;


@Data
public class ProjectAnalysisRequest {
    private String projectId;
    private String analysisType;
    private boolean deepAnalysis;
}