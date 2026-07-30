package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.Models.Districts;
import com.robindas.GeoMapBackendAPI.Models.Thana;
import com.robindas.GeoMapBackendAPI.Service.DistrictService;
import com.robindas.GeoMapBackendAPI.Service.ThanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ThanaService thanaService;

    @GetMapping("/all")
    public ResponseEntity<List<Districts>> getAllDistricts(){
        return new ResponseEntity<>(districtService.getAllDistricts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Districts> getDistrictById(@PathVariable int id){
        return ResponseEntity.ok(districtService.getDistrictById(id));
    }

    @GetMapping("/{id}/thana")
    public ResponseEntity<List<Thana>> getAllThana(@PathVariable int id){

        List<Thana> thanas = thanaService.getThanaByDistrictId(id);

        return new ResponseEntity<>(thanas, HttpStatus.OK);
    }

}
