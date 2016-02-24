package com.khanhtq.appcore.item;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;

/**
 * Created by khanhtq on 2/17/16.
 */
public class Team {
    private String mName;
    private League mLeague;
    private LatLng mAddress;
    private String mDescription;
    private String mWebAddress;
    private String mWikiAddress;
    private int mIconDrawable;

    public Team(String name, League league, LatLng address, String description, String webAddress, String wikiAddress, int iconDrawable) {
        mName = name;
        mLeague = league;
        mAddress = address;
        mDescription = description;
        mWebAddress = webAddress;
        mWikiAddress = wikiAddress;
        mIconDrawable = iconDrawable;
    }

    public String getName() {
        return mName;
    }

    public League getLeague() {
        return mLeague;
    }

    public LatLng getAddress() {
        return mAddress;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getWebAddress() {
        return mWebAddress;
    }

    public String getWikiAddress() {
        return mWikiAddress;
    }

    public int getIconDrawable() {
        return mIconDrawable;
    }

    public boolean isPosition(LatLng latLng) {
        return (mAddress != null && mAddress.latitude == latLng.latitude && mAddress.longitude == latLng.longitude);
    }

    public double calculateByDistance(LatLng latLng) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = mAddress.latitude;
        double lat2 = latLng.latitude;
        double lon1 = mAddress.longitude;
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

        return Radius * c;
    }

}
