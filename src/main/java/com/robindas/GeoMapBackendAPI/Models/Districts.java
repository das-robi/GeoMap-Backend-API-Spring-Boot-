package com.robindas.GeoMapBackendAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DISTRICT", schema = "M2MDEV")
public class Districts {

    @Id
    private int Id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String polyx;

    @Column(columnDefinition = "TEXT")
    private String polyy;


}
