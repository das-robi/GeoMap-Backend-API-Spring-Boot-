package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.Models.Road;
import com.robindas.GeoMapBackendAPI.Service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/road")
public class RoadController {

    @Autowired
    private RoadService roadService;

    @GetMapping("/all")
    public ResponseEntity<List<Road>> getAllRoads(){
        return new ResponseEntity<>(roadService.getAllRoads(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Road> getRoadById(@PathVariable int id){
        return new ResponseEntity<>(roadService.getRoadById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Road>> searchRoad(@RequestParam String keyword){
        return new ResponseEntity<>(roadService.searchRoad(keyword), HttpStatus.OK);
    }

}
