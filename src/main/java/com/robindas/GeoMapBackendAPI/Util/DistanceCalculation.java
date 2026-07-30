package com.robindas.GeoMapBackendAPI.Util;

import com.robindas.GeoMapBackendAPI.Models.GeoPoints;

public class DistanceCalculation {

    private static final double earth_radius = 6371.0; //Kilometer


    public static double calculateDistance(GeoPoints points1, GeoPoints points2){


        double latDistance = Math.toRadians(points2.getLatitude() - points1.getLatitude());
        double lonDistance = Math.toRadians(points2.getLongitude() - points1.getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
           + Math.cos(Math.toRadians(points1.getLatitude()))
                * Math.cos(Math.toRadians(points2.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return earth_radius * c;
    }

}
