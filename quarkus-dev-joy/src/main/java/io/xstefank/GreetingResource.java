package io.xstefank;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.health.Liveness;

import java.time.Duration;

@Path("/hello")
public class GreetingResource {

    @Inject
    HelloGraphQLResource helloGraphQLResource;

    @Inject
    @GrpcService
    HelloGrpcService helloGrpcService;

    @Inject
    @Liveness
    MyLivenessCheck myLivenessCheck;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello from RESTEasy Reactive");
    }

    @GET
    @Path("/ticks")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> ticks() {
        return Multi.createFrom().ticks()
            .every(Duration.ofSeconds(1))z
            .map(aLong -> "Tick #" + aLong);
    }


}
