package com.with.integrity.servicedockercompose.services.actuator.docker;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "actuator")
public class ActuatorProperties {
    private String url;
}
