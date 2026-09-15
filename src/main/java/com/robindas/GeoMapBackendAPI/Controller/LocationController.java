package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.DTO.LocationRequest;
import com.robindas.GeoMapBackendAPI.DTO.NearestRoadResponse;
import com.robindas.GeoMapBackendAPI.Models.Thana;
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

    @PostMapping("/nearest-road")
    public ResponseEntity<List<NearestRoadResponse>> getNearestRoad(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.findNearestRoad(request.getLatitude(), request.getLongitude()), HttpStatus.OK);
    }

    @PostMapping("/nearest-thana")
    public ResponseEntity<List<NearestRoadResponse>> getNearestThana(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.findNearestThana(request.getLatitude(), request.getLongitude()), HttpStatus.OK);
    }

    @PostMapping("/nearest-district")
    public ResponseEntity<List<NearestRoadResponse>> getNearestDistrict(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.findNearestDistricts(request.getLatitude(), request.getLongitude()), HttpStatus.OK);
    }
}
