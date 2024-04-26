package com.with.integrity.servicedockercompose.controllers;

import com.with.integrity.servicedockercompose.services.actuator.ActuatorClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/actuator")
public class ActuatorController {
    private final ActuatorClient actuatorClient;

    public ActuatorController(ActuatorClient actuatorClient) {
        this.actuatorClient = actuatorClient;
    }

    @GetMapping("/health")
    String health() {
        return actuatorClient.health();
    }
}
