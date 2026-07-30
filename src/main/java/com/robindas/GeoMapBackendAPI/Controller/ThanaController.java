package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.Models.Thana;
import com.robindas.GeoMapBackendAPI.Service.ThanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thana")
public class ThanaController {

    @Autowired
    private ThanaService thanaService;

    @GetMapping("/all")
    public ResponseEntity<List<Thana>> getAllThana(){
        return new ResponseEntity<>(thanaService.getAllThana(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Thana> getThanaById(@PathVariable int id){
        return new ResponseEntity<>(thanaService.getThanaById(id), HttpStatus.OK);
    }

}
