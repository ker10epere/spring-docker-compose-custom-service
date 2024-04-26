package com.with.integrity.servicedockercompose.services.actuator.config;

import com.with.integrity.servicedockercompose.services.actuator.ActuatorClient;
import com.with.integrity.servicedockercompose.services.actuator.ActuatorClientImpl;
import com.with.integrity.servicedockercompose.services.actuator.docker.ActuatorConnectionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@EnableConfigurationProperties(ActuatorProperties.class)
@AutoConfiguration(before = DataSourceAutoConfiguration.class)
public class ActuatorAutoConfiguration {
    @Slf4j
    @Configuration
    static class ActuatorPropertiesConfigured {
        @ConditionalOnBean(ActuatorConnectionDetails.class)
        @Bean
        ActuatorClient actuatorClientDocker(RestClient.Builder restClientBuilder, ActuatorConnectionDetails connectionDetails) {
            log.info(">> INITIALIZING ActuatorClient WITH [docker] " + connectionDetails.getUrl());
            return new ActuatorClientImpl(restClientBuilder, connectionDetails.getUrl());
        }

        @ConditionalOnMissingBean(ActuatorConnectionDetails.class)
        @Bean
        ActuatorClient actuatorClient(RestClient.Builder restClientBuilder, ActuatorProperties actuatorProperties) {
            log.info(">> INITIALIZING ActuatorClient WITH [properties] " + actuatorProperties.getUrl());
            return new ActuatorClientImpl(restClientBuilder, actuatorProperties.getUrl());
        }
    }
}
