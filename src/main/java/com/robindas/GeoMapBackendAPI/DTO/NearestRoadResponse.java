package com.robindas.GeoMapBackendAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NearestRoadResponse {

    private int id;
    private String description;
    private double lat;
    private double lon;
    private double distance;

}
