package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "THANA", schema = "M2MDEV")
public class Thana {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "dist_id")
    private Districts districts;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String polyx;

    @Column(columnDefinition = "TEXT")
    private String polyy;

}
