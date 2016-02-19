package com.khanhtq.prosoccerteam.util;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.prosoccerteam.R;
import com.khanhtq.prosoccerteam.items.Country;
import com.khanhtq.prosoccerteam.items.Team;

/**
 * Created by khanhtq on 2/18/16.
 */
public class Constants {
    public static final int TEAM_MAX_DISTANCE = 50;

    public static final Team[] TEAM_LIST = {
            new Team("FC Barcelona", new LatLng(10.7847983, 106.7028832), "The world club champion", "http://www.fcbarcelona.com/", "https://en.wikipedia.org/wiki/FC_Barcelona", R.drawable.ic_barcelona_fc),
            new Team("FC Real Madrid", new LatLng(10.7829915, 106.7061147), "The world biggest club", "http://www.realmadrid.com/", "https://en.wikipedia.org/wiki/Real_Madrid_C.F.", R.drawable.ic_real_madrid),
            new Team("Manchester United", new LatLng(10.777161, 106.515388), "The Premier League Champion", "http://www.manutd.com/", "https://en.wikipedia.org/wiki/Manchester_United_F.C.", R.drawable.ic_manchester_united)
    };


    public static final Country[] COUNTRIES = {
            new Country("Vietnam", new LatLng(14.058324, 108.277199)),
            new Country("Cambodia", new LatLng(12.565679, 104.990963)),
            new Country("Japan", new LatLng(36.204824, 138.252924)),
            new Country("China", new LatLng(35.86166, 104.195397)),
            new Country("Singapore", new LatLng(1.352083, 103.819836)),
            new Country("Myanmar", new LatLng(21.913965, 95.956223)),
            new Country("Malaysia", new LatLng(4.210484, 101.975766)),
            new Country("Brunei Darussalam", new LatLng(4.535277, 114.727669)),
            new Country("United States", new LatLng(37.09024, -95.712891)),
            new Country("United Kingdom", new LatLng(55.378051, -3.435973)),
            new Country("Uruguay", new LatLng(-32.522779, -55.765835)),
            new Country("Togo", new LatLng(8.619543, 0.824782)),
            new Country("Switzerland", new LatLng(46.818188, 8.227511999999999)),
            new Country("Turkey", new LatLng(38.963745, 35.243322))
    };
}
