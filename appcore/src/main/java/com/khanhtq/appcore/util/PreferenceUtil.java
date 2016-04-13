package com.khanhtq.appcore.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khanhtq.appcore.item.Team;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by khanhtq on 4/12/16.
 */
public class PreferenceUtil {
    private static final String PREFERENCE_NAME = "SPORT_PREFERENCE";

    private Context mContext;
    private static PreferenceUtil mInstance;

    private SharedPreferences mPreference;
    private SharedPreferences.Editor mEditor;
    private Gson gson;

    private PreferenceUtil(Context context) {
        mContext = context;
    }

    public static PreferenceUtil getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PreferenceUtil(context);
        }
        return mInstance;
    }

    public PreferenceUtil initialize() {
        mPreference = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mPreference.edit();
        gson = new Gson();
        return mInstance;
    }

    public <T> void setListObject(String key, List<T> listData) {
        String listAsString = gson.toJson(listData);
        mEditor.putString(key, listAsString);
        mEditor.commit();
    }

    public List<Team> getListObject(String key) {
        String stringValue = mPreference.getString(key, Constants.EMPTY);
        if (stringValue != Constants.EMPTY) {
            Type type = new TypeToken<List<Team>>(){}.getType();
            return gson.fromJson(stringValue, type);
        }
        return null;
    }
}
