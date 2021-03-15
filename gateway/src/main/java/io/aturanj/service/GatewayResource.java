package io.aturanj.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/gateway")
public class GatewayResource {

    @Inject
    @RestClient
    TimeService timeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public String getTime() {
        return getTimeFromService();
    }

    @Counted
    public String getTimeFromService() {
        return "gateway -> " + timeService.getTime();
    }
}
