package com.example.actions_test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class HealthCheckController {

  @Value("${server.env}")
  private String env;
  @Value("${server.port}")
  private String serverPort;
  @Value("${server.serverAddress}")
  private String serverAddress;
  @Value("${serverName}")
  private String serverName;

  @GetMapping("health")
  public ResponseEntity<?> healthCheck() {
    Map<String, String> responseData = new TreeMap<>();
    responseData.put("env", env);
    responseData.put("serverPort", serverPort);
    responseData.put("serverAddress", serverAddress);
    responseData.put("serverName", serverName);

    return ResponseEntity.ok(responseData);
  }

  @GetMapping("env")
  public ResponseEntity<?> envCheck() {
    return ResponseEntity.ok(env);
  }
}
