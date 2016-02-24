package com.khanhtq.appcore.item;

/**
 * Created by khanhtq on 2/24/16.
 */
public class League {
    private String mName;
    private String mType;

    public League(String name, String type) {
        mName = name;
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }
}
