package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.Models.Districts;
import com.robindas.GeoMapBackendAPI.Models.GeoPoints;
import com.robindas.GeoMapBackendAPI.Models.Road;
import com.robindas.GeoMapBackendAPI.Models.Thana;
import com.robindas.GeoMapBackendAPI.Repository.DistrictRepository;
import com.robindas.GeoMapBackendAPI.Util.GeometryParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<Districts> getAllDistricts() {
        return districtRepository.findAll();

    }

    public Districts getDistrictById(int id) {
        return districtRepository.findById(id).orElseThrow(() -> new RuntimeException("District not found with id: " + id));


    }
}
