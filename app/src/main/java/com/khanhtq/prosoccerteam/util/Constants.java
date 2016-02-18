package com.khanhtq.prosoccerteam.util;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.prosoccerteam.R;
import com.khanhtq.prosoccerteam.items.Team;

/**
 * Created by khanhtq on 2/18/16.
 */
public class Constants {
    public static final int TEAM_MAX_DISTANCE = 10;

    public static final Team[] TEAM_LIST = {
        new Team("FC Barcelona", new LatLng(10.7847983, 106.7028832), "The world club champion", "http://www.fcbarcelona.com/", "https://en.wikipedia.org/wiki/FC_Barcelona", R.drawable.ic_barcelona_fc),
        new Team("FC Real Madrid", new LatLng(10.7829915, 106.7061147), "The world biggest club", "http://www.realmadrid.com/", "https://en.wikipedia.org/wiki/Real_Madrid_C.F.", R.drawable.ic_real_madrid),
        new Team("Manchester United", new LatLng(10.777161, 106.515388), "The Premier League Champion", "http://www.manutd.com/", "https://en.wikipedia.org/wiki/Manchester_United_F.C.", R.drawable.ic_manchester_united )
    };
}
