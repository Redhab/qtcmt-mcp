package com.qlik.qtcmt.mcp.config;
// Update McpServerConfig

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class McpServerConfig {
    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }
}
