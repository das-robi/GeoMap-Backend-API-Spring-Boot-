package com.robindas.GeoMapBackendAPI.Util;

import com.robindas.GeoMapBackendAPI.Models.GeoPoints;

import java.util.ArrayList;
import java.util.List;

public class GeometryParser {

    public static List<GeoPoints> parser(String polyX, String polyY){

        List<GeoPoints> points = new ArrayList<>();

        //Check here if points are null then it return;
        if (polyX == null || polyY == null){

            System.out.println("return : "  + "This ploX: " + polyX + "This is polyY" + polyY);
            return points;
        }

        String[] xArray = polyX.split(",");
        String[] yArray = polyY.split(",");

        int size = Math.min(xArray.length, yArray.length);

        for (int i = 0; i < size; i++){

            double lat = Double.parseDouble(xArray[i].trim());
            double lon = Double.parseDouble(yArray[i].trim());

            points.add(new GeoPoints(lat, lon));
        }

        return points; 
    }

}
