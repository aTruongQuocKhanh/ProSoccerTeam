package com.khanhtq.prosoccerteam.util;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.util.SearchCountryRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by khanhtq on 2/19/16.
 */
public class ArenaSearchCountryRunnable extends SearchCountryRunnable{
    public static final String TAG = ArenaSearchCountryRunnable.class.getSimpleName();

    public ArenaSearchCountryRunnable(SearchCountryMethods searchCountryMethods) {
        super(searchCountryMethods);
    }

    @Override
    public void doSearch() {
        final SearchCountryMethods mSearchCountryTask = getSearchCountryTask();
        mSearchCountryTask.setSearchCountryThread(Thread.currentThread());
        mSearchCountryTask.handleSearchCountryState(SearchLocationManager.SEARCH_COUNTRY_STARTED);
        final LatLng location = mSearchCountryTask.getCurrentCountryLocation();
        List<Country> results = new ArrayList<Country>();
        for (Country country : Constants.COUNTRIES) {
            country.calculateByDistance(location);
        }
        Comparator<Country> comparator = new Comparator<Country>() {
            @Override
            public int compare(Country lhs, Country rhs) {
                return Double.compare(lhs.getDistance(), rhs.getDistance());
            }
        };
        Arrays.sort(Constants.COUNTRIES, comparator);
        if (Constants.COUNTRIES.length > 10) {
            results.addAll(Arrays.asList(Arrays.copyOf(Constants.COUNTRIES, 10)));
        } else {
            results.addAll(Arrays.asList(Constants.COUNTRIES));
        }
        mSearchCountryTask.setCountries(results);
        mSearchCountryTask.handleSearchCountryState(SearchLocationManager.SEARCH_COMPLETE);
    }
}
