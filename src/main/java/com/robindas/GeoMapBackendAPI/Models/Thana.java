package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Polygon;

@Data
@Entity
@Table(name = "spatial_thana", schema = "m2mdev")
public class Thana {

    @Id
    private long id;
    private String description;

    @Column(name = "dist_id")
    private Long distId;

    @Column(columnDefinition = "geometry(Polygon, 4326)")
    private Polygon geom;
}
