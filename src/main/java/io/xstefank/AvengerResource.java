package io.xstefank;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.xstefank.model.Avenger;

public interface AvengerResource extends PanacheEntityResource<Avenger, Long> {
}
