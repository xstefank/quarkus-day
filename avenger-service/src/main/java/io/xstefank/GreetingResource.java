package io.xstefank;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.atomic.AtomicInteger;

@Path("/api")
public class GreetingResource {

    private AtomicInteger counter = new AtomicInteger(0);

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Brno Java Meetup";
    }

    @GET
    @Path("/hello2")
    public String hello2() {
        return "Hello 2";
    }



    @GET
    @Path("/counter")
    public void counter() {
        Log.info("Something ");
        Log.info("Counting change " + counter.getAndIncrement());
    }


}
