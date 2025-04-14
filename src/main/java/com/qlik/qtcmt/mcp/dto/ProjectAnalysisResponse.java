package com.qlik.qtcmt.mcp.dto;

import lombok.Data;

@Data
public class ProjectAnalysisResponse {
    private String status;
    private String analysisReport;
    private int findingsCount;
}
