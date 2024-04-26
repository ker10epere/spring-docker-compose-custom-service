package com.with.integrity.servicedockercompose.services.actuator.docker;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface ActuatorConnectionDetails extends ConnectionDetails {
    String getUrl();
}
