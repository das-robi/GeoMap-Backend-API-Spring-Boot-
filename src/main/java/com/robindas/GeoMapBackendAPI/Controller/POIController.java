package com.robindas.GeoMapBackendAPI.Controller;

import com.robindas.GeoMapBackendAPI.Models.POIS;
import com.robindas.GeoMapBackendAPI.Service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poi")
public class POIController {

    @Autowired
    private POIService poiService;

    @GetMapping("/pois")
    public ResponseEntity<List<POIS>> getAllPOI(){
        return new ResponseEntity<>(poiService.getAllPOI(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<POIS> getPOIById(@PathVariable int id){
        return new ResponseEntity<>(poiService.getPOIById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<POIS>> getSearchPOI(@RequestParam String keyword){
        return new ResponseEntity<>(poiService.searchPOI(keyword), HttpStatus.OK);
    }

    @GetMapping("/thana/{thanaId}")
    public ResponseEntity<List<POIS>> findPOIByThanaID(@PathVariable int thanaId){

        List<POIS> poisListofThana = poiService.findByThana_Id(thanaId);

        return new ResponseEntity<>(poisListofThana, HttpStatus.OK);
    }

    @GetMapping("/district/{distId}")
    public ResponseEntity<List<POIS>> findByDistrictId(@PathVariable int distId){
        return new ResponseEntity<>(poiService.findByDistrict_Id(distId), HttpStatus.OK);
    }
}
