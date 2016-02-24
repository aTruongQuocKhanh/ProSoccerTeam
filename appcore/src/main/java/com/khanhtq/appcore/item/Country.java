package com.khanhtq.appcore.item;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.text.DecimalFormat;

/**
 * Created by khanhtq on 2/19/16.
 */
public class Country {
    private String mName;
    private LatLng mLocation;
    private double mDistance;
    private LatLngBounds mBound;

    public Country (String name, LatLng location, LatLngBounds bound) {
        mName = name;
        mLocation = location;
        mBound = bound;
    }

    public String getName() {
        return mName;
    }

    public LatLng getLocation() {
        return mLocation;
    }

    public double getDistance() {
        return mDistance;
    }

    public LatLngBounds getBound() {
        return mBound;
    }

    public void calculateByDistance(LatLng latLng) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = mLocation.latitude;
        double lat2 = latLng.latitude;
        double lon1 = mLocation.longitude;
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

        mDistance = Radius * c;
    }
}
