package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "POI", schema = "M2MDEV")
public class POIS {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "dist_id")
    private Districts districts;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;
//
//    @Column(name = "dist_id")
//    private Integer distId;
//
//    @Column(name = "thana_id")
//    private Integer thanaId;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String x = "";

    @Column(columnDefinition = "TEXT")
    private String y;

}
