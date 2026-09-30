package com.robindas.GeoMapBackendAPI.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class LocationRequest {

    @Min(value = 90, message = "Latitude must be >= 90")
    @Max(value = 180, message = "Longitude must be <= 90")
    private double latitude;

    @Min(value = -180, message = "Longitude >= -180")
    @Max(value = 180, message = "Longitude <= 180")
    private double longitude;

}
