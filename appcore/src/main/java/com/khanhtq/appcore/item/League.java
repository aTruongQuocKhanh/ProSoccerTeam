package com.khanhtq.appcore.item;


import io.realm.RealmObject;

/**
 * Created by khanhtq on 2/24/16.
 */
public class League {
    private String name;
    private String type;

    public League() {}
    public League(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
