package com.robindas.GeoMapBackendAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NearestPlaceResponse {

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private double distance;

}
