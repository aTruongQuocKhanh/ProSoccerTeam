package com.khanhtq.prosoccerteam.util;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.prosoccerteam.items.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by khanhtq on 2/19/16.
 */
public class SearchCountryRunnable implements Runnable {
    public static final String TAG = SearchCountryRunnable.class.getSimpleName();

    interface SearchCountryMethods {
        /**
         * Sets current thread back to search Task.
         *
         * @param thread the current thread.
         */
        void setSearchCountryThread(Thread thread);

        /**
         * Sets search countries result back to search task;
         *
         * @param coutries the searching results.
         */
        void setCountries(List<Country> coutries);

        /**
         * Returns the current location for searching
         *
         * @return
         */
        LatLng getCurrentCountryLocation();

        /**
         * Notify searching progress back to the search manager
         *
         * @param state the search state.
         */
        void handleSearchCountryState(int state);
    }

    SearchCountryMethods mSearchCountryTask;

    SearchCountryRunnable(SearchCountryMethods searchCountryMethods) {
        mSearchCountryTask = searchCountryMethods;
    }

    @Override
    public void run() {
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
