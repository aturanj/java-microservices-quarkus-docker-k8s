package io.aturanj.health;

import io.aturanj.service.TimeService;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessProbe implements HealthCheck {

    @Inject
    @RestClient
    TimeService timeService;

    @Override
    public HealthCheckResponse call() {

        if (timeService == null || timeService.getTime() == null || timeService.getTime().isEmpty()) {
            return HealthCheckResponse.down("Gateway is NOT ready!");
        } else {
            return HealthCheckResponse.up("Gateway is ready!");
        }
    }
}
