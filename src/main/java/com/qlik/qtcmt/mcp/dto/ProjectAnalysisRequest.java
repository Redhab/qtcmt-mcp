package com.qlik.qtcmt.mcp.dto;


import lombok.Data;


@Data
public class ProjectAnalysisRequest {
    private String projectId;
    private ANALYSIS_TYPE analysisType;
    private boolean deepAnalysis;
}
