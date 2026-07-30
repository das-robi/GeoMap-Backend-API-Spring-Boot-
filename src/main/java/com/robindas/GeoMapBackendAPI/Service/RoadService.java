package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.Models.Road;
import com.robindas.GeoMapBackendAPI.Repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadService {

    @Autowired
    private RoadRepository roadRepository;

    public List<Road> getAllRoads() {
        return roadRepository.findAll();
    }

    public Road getRoadById(int id) {
        return roadRepository.findById(id).orElseThrow(()-> new RuntimeException("Road not found with id: " + id));
    }

    public List<Road> searchRoad(String keyword) {
        return roadRepository.findByDescriptionContainingIgnoreCase(keyword);
    }
}
