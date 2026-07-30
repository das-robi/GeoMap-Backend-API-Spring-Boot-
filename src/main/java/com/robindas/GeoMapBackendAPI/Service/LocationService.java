package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.DTO.NearestPlaceResponse;
import com.robindas.GeoMapBackendAPI.DTO.RoadResponse;
import com.robindas.GeoMapBackendAPI.Models.GeoPoints;
import com.robindas.GeoMapBackendAPI.Models.POIS;
import com.robindas.GeoMapBackendAPI.Models.Road;
import com.robindas.GeoMapBackendAPI.Repository.LocationRepository;
import com.robindas.GeoMapBackendAPI.Repository.RoadRepository;
import com.robindas.GeoMapBackendAPI.Util.DistanceCalculation;
import com.robindas.GeoMapBackendAPI.Util.GeometryParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RoadRepository roadRepository;

    public List<NearestPlaceResponse> findNearestPois(double latitude, double longitude){

        List<POIS> pois = locationRepository.findAll();

        GeoPoints userDistance = new GeoPoints(latitude, longitude);

        List<NearestPlaceResponse> nearestPoi = new ArrayList<>();

//        double shortestDistance = Double.MAX_VALUE;


        for (POIS poi : pois){

            GeoPoints geoPoints = new GeoPoints(Double.parseDouble(poi.getX()),
                    Double.parseDouble(poi.getY()));

            double distance = DistanceCalculation.calculateDistance(userDistance, geoPoints);

            NearestPlaceResponse response = new NearestPlaceResponse();

            response.setId(poi.getId());
            response.setName(poi.getDescription());
            response.setLatitude(Double.parseDouble(poi.getX()));
            response.setLongitude(Double.parseDouble(poi.getY()));
            response.setDistance(distance);

            nearestPoi.add(response);
        }

        nearestPoi.sort(Comparator.comparing(NearestPlaceResponse::getDistance));

        return nearestPoi.subList(0, Math.min(5, nearestPoi.size()));
    }

    public List<RoadResponse> findNearestRoad(double latitude, double longitude) {

        List<Road> roadList = roadRepository.findAll();

        List<RoadResponse> nearestRoad = new ArrayList<>();
        GeoPoints userDistance = new GeoPoints(latitude, longitude);



        for (Road road : roadList){

            List<GeoPoints> roadPoints = GeometryParser.parser(road.getPolyx(), road.getPolyy());

            for (GeoPoints points : roadPoints){

                double distance = DistanceCalculation.calculateDistance(userDistance, points);

                RoadResponse response = new RoadResponse();

                response.setId(road.getId());
                response.setRoad(road.getDescription());
                response.setLat(points.getLatitude());
                response.setLon(points.getLongitude());
                response.setDistance(distance);

//                System.out.println("Road Id " + road.getId());
//                System.out.println("Road Name " + road.getDescription());
//                System.out.println("Lat " + road.getPolyx());
//                System.out.println("Lon " + road.getPolyy());
//                System.out.println("District " + road.getDistricts());

                nearestRoad.add(response);
            }
        }

        nearestRoad.sort(Comparator.comparing(RoadResponse::getDistance));

        return nearestRoad.subList(0, Math.min(5, nearestRoad.size()));
    }


}
