package com.leonardo.assignment.utils;

import java.math.BigDecimal;

public class Location {

    private static final double EARTH_RADIUS = 6371393;

    public static double getDistance(Double lat1, Double lng1, Double lat2, Double lng2) {
        double radiansAX = Math.toRadians(lng1);
        double radiansAY = Math.toRadians(lat1);
        double radiansBX = Math.toRadians(lng2);
        double radiansBY = Math.toRadians(lat2);

        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                     + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos);

        BigDecimal result = new BigDecimal(EARTH_RADIUS * acos /1000);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
