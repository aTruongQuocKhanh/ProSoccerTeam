package com.khanhtq.appcore.item;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.text.DecimalFormat;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by khanhtq on 2/17/16.
 */
public class Team implements ClusterItem {
    private String name;
    private League league;
    private LatLng address;
    private String description;
    private String link;
    private String wiki;
    private int mIconDrawable;

    public Team(String name, League league, LatLng address, String description, String webAddress, String wikiAddress, int iconDrawable) {
        this.name = name;
        this.league = league;
        this.address = address;
        this.description = description;
        link = webAddress;
        wiki = wikiAddress;
        mIconDrawable = iconDrawable;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public String getDescription() {
        return description;
    }

    public String getWebAddress() {
        return link;
    }

    public String getWikiAddress() {
        return wiki;
    }

    public int getIconDrawable() {
        return mIconDrawable;
    }

    public boolean isPosition(LatLng latLng) {
        return (address != null && calculateByDistance(latLng) <= 2);
    }

    public double calculateByDistance(LatLng latLng) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = address.latitude;
        double lat2 = latLng.latitude;
        double lon1 = address.longitude;
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

    @Override
    public LatLng getPosition() {
        return address;
    }
}
