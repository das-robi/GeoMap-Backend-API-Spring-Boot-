package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.DTO.LocationRequest;
import com.robindas.GeoMapBackendAPI.DTO.LocationResponse;
import com.robindas.GeoMapBackendAPI.Service.LocationService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@Validated
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/nearesplace")
    public ResponseEntity<LocationResponse> getlocation(@RequestParam("lat") @Min(-90) @Max(90) double latitude,
                                                        @RequestParam("lng") @Min(-180) @Max(180) double longitude) {

        LocationResponse locationResponse = locationService.resolveLocation(latitude, longitude);

        return ResponseEntity.ok(locationResponse);
    }

}
