package com.khanhtq.appcore.util;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by khanhtq on 2/19/16.
 */
public abstract class SearchCountryRunnable implements Runnable {
    public static final String TAG = SearchCountryRunnable.class.getSimpleName();

    public interface SearchCountryMethods {
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

    private SearchCountryMethods mSearchCountryTask;

    public SearchCountryRunnable(SearchCountryMethods searchCountryMethods) {
        mSearchCountryTask = searchCountryMethods;
    }

    public SearchCountryMethods getSearchCountryTask() {
        return mSearchCountryTask;
    }

    @Override
    public void run() {
        doSearch();
    }

    public abstract void doSearch();
}
