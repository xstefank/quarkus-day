package io.xstefank;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.concurrent.atomic.AtomicInteger;

@Path("/api")
@ApplicationScoped
public class GreetingResource {

    @ConfigProperty(name = "test.config")
    String testConfig;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Bonjour from " + testConfig;
    }


    private AtomicInteger counterInt = new AtomicInteger(0);

    @GET
    @Path("/counter")
    public int counter() {
        Log.infof("Counting %d counter", counterInt.get());
        return counterInt.getAndIncrement();
    }



}
