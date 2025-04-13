package com.qlik.qtcmt.mcp.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/mcp")
public class McpManifestController {

    @GetMapping(value = "/manifest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getManifest() throws Exception {
        ClassPathResource resource = new ClassPathResource("mcp-manifest.json");
        String manifestContent = StreamUtils.copyToString(
                resource.getInputStream(),
                StandardCharsets.UTF_8
        );
        return ResponseEntity.ok(manifestContent);
    }
}
