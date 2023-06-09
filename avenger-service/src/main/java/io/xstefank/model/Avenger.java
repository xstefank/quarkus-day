package io.xstefank.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Avenger extends PanacheEntity {

    public String name;
    public String civilName;
    public boolean snapped;

    @Override
    public String toString() {
        return "Avenger{" +
            "name='" + name + '\'' +
            ", civilName='" + civilName + '\'' +
            ", snapped=" + snapped +
            ", id=" + id +
            '}';
    }
}
