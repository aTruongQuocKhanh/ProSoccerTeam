package com.khanhtq.appcore.item;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.text.DecimalFormat;

import io.realm.RealmObject;

/**
 * Created by khanhtq on 2/19/16.
 */
public class Country {
    private String name;
    private LatLng location;
    private double distance;
    private LatLngBounds bound;

    public Country() {}

    public Country (String name, LatLng location, LatLngBounds bound) {
        this.name = name;
        this.location = location;
        this.bound = bound;
    }

    public String getName() {
        return name;
    }

    public LatLng getLocation() {
        return location;
    }

    public double getDistance() {
        return distance;
    }

    public LatLngBounds getBound() {
        return bound;
    }

    public void calculateByDistance(LatLng latLng) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = location.latitude;
        double lat2 = latLng.latitude;
        double lon1 = location.longitude;
        double lon2 = latLng.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        distance = Radius * c;
    }
}
