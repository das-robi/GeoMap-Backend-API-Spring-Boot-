package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.DTO.LocationResponse;
import com.robindas.GeoMapBackendAPI.Models.*;
import com.robindas.GeoMapBackendAPI.Repository.DistrictRepository;
import com.robindas.GeoMapBackendAPI.Repository.POIRepository;
import com.robindas.GeoMapBackendAPI.Repository.RoadRepository;
import com.robindas.GeoMapBackendAPI.Repository.ThanaRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.locationtech.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private ThanaRepository thanaRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private POIRepository poiRepository;

    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    public LocationResponse resolveLocation(double latitude, double longitude){

        Point point = geometryFactory.createPoint(new Coordinate(latitude, longitude));

        Optional<Districts> district = districtRepository.findContainingDistrict(point);
        Optional<Thana> thana = thanaRepository.findNearestThana(point);
        Optional<Road> road = roadRepository.findNearestRoad(point, 500);
        Optional<POIS> pois = poiRepository.findNearestPoi(point, 1000);


        return new LocationResponse().builder()
                .latitude(latitude)
                .longitude(longitude)
                .district(district.map(Districts::getDescription).orElse("Outside Known District"))
                .thana(thana.map(Thana::getDescription).orElse("Outside known Thana"))
                .nearestRoad(road.map(Road::getDescription).orElse("Unregister Road"))
                .nearestPOI(pois.map(POIS::getDescription).orElse("No POI nearby"))
                .build();

    }
}
