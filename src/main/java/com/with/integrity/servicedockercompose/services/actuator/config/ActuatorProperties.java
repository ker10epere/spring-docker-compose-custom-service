package com.with.integrity.servicedockercompose.services.actuator.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "services.actuator")
public class ActuatorProperties {
    private String url;
}
