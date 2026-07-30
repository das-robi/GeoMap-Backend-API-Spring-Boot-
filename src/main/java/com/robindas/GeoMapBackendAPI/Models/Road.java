package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ROAD", schema = "M2MDEV")
public class Road {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "dist_id")
    private Districts districts;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String polyx;

    @Column(columnDefinition = "TEXT")
    private String polyy;

}
