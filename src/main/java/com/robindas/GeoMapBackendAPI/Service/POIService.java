package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.Models.POIS;
import com.robindas.GeoMapBackendAPI.Repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POIService {

    @Autowired
    private POIRepository poiRepository;

    public List<POIS> getAllPOI() {
        return poiRepository.findAll();
    }

    public POIS getPOIById(int id) {
        return poiRepository.findById(id).orElseThrow(()-> new RuntimeException("Point of interest not found with id: " + id));
    }

    public List<POIS> searchPOI(String keyword) {

        return poiRepository.findByDescriptionContainingIgnoreCase(keyword);
    }

    public List<POIS> findByThana_Id(int thanaId) {
        return poiRepository.findByThana_Id(thanaId);
    }

    public List<POIS> findByDistrict_Id(int distId) {
        return poiRepository.findByDistricts_Id(distId);
    }
}
