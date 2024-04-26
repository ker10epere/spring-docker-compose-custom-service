package com.with.integrity.servicedockercompose.services.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClient;

@Slf4j
public class ActuatorClientImpl implements ActuatorClient {
    private RestClient client;

    public ActuatorClientImpl(RestClient.Builder restClientBuilder, String baseUrl) {
        log.info("** INITIALIZING ActuatorClientImpl");
        log.info("** Base Url " + baseUrl);
        this.client = restClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public String health() {
        return this.client.get()
                .uri("/actuator/health")
                .retrieve()
                .body(String.class);
    }
}
