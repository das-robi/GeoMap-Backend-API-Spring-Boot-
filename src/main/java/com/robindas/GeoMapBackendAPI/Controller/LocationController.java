package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.DTO.LocationRequest;
import com.robindas.GeoMapBackendAPI.DTO.RoadResponse;
import com.robindas.GeoMapBackendAPI.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/nearesplace")
    public ResponseEntity<?> getNearestPois(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.findNearestPois(request.getLatitude(), request.getLongitude()), HttpStatus.OK);
    }

    @PostMapping("/neares-road")
    public ResponseEntity<List<RoadResponse>> getNearestRoad(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.findNearestRoad(request.getLatitude(), request.getLongitude()), HttpStatus.OK);
    }

}
