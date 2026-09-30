package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.LineString;

@Data
@Entity
@Table(name = "spatial_road", schema = "m2mdev")
public class Road {

    @Id
    private long id;
    private String description;;

    @Column(name = "dist_id")
    private Long districts;

    @Column(name = "thana_id")
    private Long thanaId;

    @Column(columnDefinition = "geometry(LineString, 4326)")
    private LineString geom;

}
