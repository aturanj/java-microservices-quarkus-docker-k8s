package io.aturanj;

import java.time.LocalDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/time")
public class TimeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return LocalDateTime.now() + "\n";
    }
}
