package io.xstefank;

import io.quarkus.logging.Log;
import io.xstefank.model.Avenger;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/avenger")
public class AvengerResource {

    @GET
    public List<Avenger> all() {
        return Avenger.listAll();
    }

    @POST
    @Transactional
    public Avenger create(Avenger avenger) {
        Log.info("Avenger before persist " + avenger);
        avenger.persist();
        Log.infof("Avenger after persist %s", avenger);
        return avenger;
    }


}
