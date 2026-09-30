package com.robindas.GeoMapBackendAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {

    private String district;
    private String thana;
    private String nearestRoad;
    private String nearestPOI;
    private double latitude;
    private double longitude;

}
