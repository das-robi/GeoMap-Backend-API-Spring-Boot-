package com.robindas.GeoMapBackendAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Polygon;


@Data
@Entity
@Table(name = "spatial_district", schema = "m2mdev")
public class Districts {

    @Id
    private long Id;
    private String description;

    @JsonIgnore
    @Column(columnDefinition = "geometry(Polygon, 4326)")
    private Polygon geom;
}
