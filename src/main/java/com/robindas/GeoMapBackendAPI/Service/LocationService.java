package com.robindas.GeoMapBackendAPI.Service;

import com.robindas.GeoMapBackendAPI.DTO.NearestPlaceResponse;
import com.robindas.GeoMapBackendAPI.DTO.NearestRoadResponse;
import com.robindas.GeoMapBackendAPI.Models.*;
import com.robindas.GeoMapBackendAPI.Repository.DistrictRepository;
import com.robindas.GeoMapBackendAPI.Repository.LocationRepository;
import com.robindas.GeoMapBackendAPI.Repository.RoadRepository;
import com.robindas.GeoMapBackendAPI.Repository.ThanaRepository;
import com.robindas.GeoMapBackendAPI.Util.DistanceCalculation;
import com.robindas.GeoMapBackendAPI.Util.GeometryParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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

    @Autowired
    private ThanaRepository thanaRepository;

    @Autowired
    private DistrictRepository districtRepository;

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

    public List<NearestRoadResponse> findNearestRoad(double latitude, double longitude) {

        List<Road> roadList = roadRepository.findAll();

        List<NearestRoadResponse> nearestRoad = new ArrayList<>();
        GeoPoints userDistance = new GeoPoints(latitude, longitude);


        for (Road road : roadList){

            List<GeoPoints> roadPoints = GeometryParser.parser(road.getPolyx(), road.getPolyy());

            for (GeoPoints points : roadPoints){

                double distance = DistanceCalculation.calculateDistance(userDistance, points);

                NearestRoadResponse response = new NearestRoadResponse();

                response.setId(road.getId());
                response.setDescription(road.getDescription());
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

        nearestRoad.sort(Comparator.comparing(NearestRoadResponse::getDistance));

        return nearestRoad.subList(0, Math.min(5, nearestRoad.size()));
    }


    public List<NearestRoadResponse> findNearestThana(double latitude, double longitude) {

        List<Thana> allThana = thanaRepository.findAll();

        List<NearestRoadResponse> nearestThana = new ArrayList<>();

        GeoPoints userDistance = new GeoPoints(latitude, longitude);


        for (Thana thana : allThana){

            List<GeoPoints> locationPoints = GeometryParser.parser(thana.getPolyx(), thana.getPolyy());

//            System.out.println("Locations Points: " + locationPoints);

            for (GeoPoints points : locationPoints){

                double distance = DistanceCalculation.calculateDistance(userDistance, points);

                NearestRoadResponse response = new NearestRoadResponse();

                                System.out.println("Road Id " + thana.getId());
                System.out.println("Thana Name " + thana.getDescription());
                System.out.println("Lat " + thana.getPolyx());
                System.out.println("Lon " + thana.getPolyy());
                System.out.println("District " + thana.getDistricts());

                response.setId(thana.getId());
                response.setDescription(thana.getDescription());
                response.setDistance(distance);
                response.setLat(points.getLatitude());
                response.setLon(points.getLongitude());

                nearestThana.add(response);
            }
        }


        nearestThana.sort(Comparator.comparing(NearestRoadResponse::getDistance));

        return nearestThana.subList(0, Math.min(5, nearestThana.size()));
    }

    public List<NearestRoadResponse> findNearestDistricts(double latitude, double longitude) {

        List<Districts> allDistricts = districtRepository.findAll();

        List<NearestRoadResponse> nearestDistricts = new ArrayList<>();

        GeoPoints userDistance = new GeoPoints(latitude, longitude);

        for (Districts districts : allDistricts){

            List<GeoPoints> locationPoints = GeometryParser.parser(districts.getPolyx(), districts.getPolyy());

            for (GeoPoints points : locationPoints){

                double distance = DistanceCalculation.calculateDistance(userDistance, points);

                NearestRoadResponse response = new NearestRoadResponse();

                response.setId(districts.getId());
                response.setDescription(districts.getDescription());
                response.setLat(points.getLatitude());
                response.setLon(points.getLongitude());
                response.setDistance(distance);

                nearestDistricts.add(response);
            }

        }

        nearestDistricts.sort(Comparator.comparing(NearestRoadResponse::getDistance));

        return nearestDistricts.subList(0, Math.min(5, nearestDistricts.size()));
    }

}
