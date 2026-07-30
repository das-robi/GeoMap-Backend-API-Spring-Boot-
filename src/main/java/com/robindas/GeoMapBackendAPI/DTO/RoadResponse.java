package com.robindas.GeoMapBackendAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoadResponse {

    private int id;
    private String road;
    private double lat;
    private double lon;
    private double distance;

}
