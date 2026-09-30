package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;


@Data
@Entity
@Table(name = "spatial_poi", schema = "m2mdev")
public class POIS {

    @Id
    private long id;
    private String description;

    @Column(name = "dist_id")
    private Long distId;

    @Column(name = "thana_id")
    private Long thanaId;

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point geom;

}
