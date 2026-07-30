package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.Models.Thana;
import com.robindas.GeoMapBackendAPI.Repository.ThanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanaService {

    @Autowired
    private ThanaRepository thanaRepository;


    public List<Thana> getAllThana() {
        return thanaRepository.findAll();
    }

    public Thana getThanaById(int id) {
        return thanaRepository.findById(id).orElseThrow(()-> new RuntimeException("Thana is not found: " + id));
    }

    public List<Thana> getThanaByDistrictId(int id) {
        return thanaRepository.findByDistricts_Id(id);
    }
}
