package com.with.integrity.servicedockercompose.services.actuator.docker;

import org.springframework.boot.docker.compose.core.RunningService;
import org.springframework.boot.docker.compose.service.connection.DockerComposeConnectionDetailsFactory;
import org.springframework.boot.docker.compose.service.connection.DockerComposeConnectionSource;

public class ActuatorDockerComposeConnectionDetailsFactory extends DockerComposeConnectionDetailsFactory<ActuatorConnectionDetails> {
    protected ActuatorDockerComposeConnectionDetailsFactory() {
        super("service-docker-compose-actuator_webapp");
    }

    @Override
    protected ActuatorConnectionDetails getDockerComposeConnectionDetails(DockerComposeConnectionSource source) {
        return new ActuatorDockerComposeConnectionDetails(source.getRunningService());
    }

    static class ActuatorDockerComposeConnectionDetails extends DockerComposeConnectionDetails
            implements ActuatorConnectionDetails {

        private String url;

        ActuatorDockerComposeConnectionDetails(RunningService service) {
            super(service);
            String host = service.host();
            int port = service.ports().get(8080);
            this.url = "http://" + host + ":" + port;
        }


        @Override
        public String getUrl() {
            return url;
        }
    }
}
