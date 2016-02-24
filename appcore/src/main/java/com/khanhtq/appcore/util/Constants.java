package com.khanhtq.appcore.util;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.item.Team;

/**
 * Created by khanhtq on 2/18/16.
 */
public class Constants {
    public static final String WHITE_SPACE = " ";

    public static final float EQUATOR_LENGTH = 40075;

    public static final int DEFAULT_DISTANCE_IN_DP = 400;

    public static final float DEFAULT_ZOOM_LEVEL = 10;

    public static final int UPDATE_LOCATION_TIME = 60000;

    public static final League ALL_LEAGUE = new League("All", "all");

    public static final League[] AMERICA_LEAGUE = {
            new League("MLS", "Soccer"),
            new League("NBA", "Basketball"),
            new League("MLB", "Baseball"),
            new League("NHL", "Hockey"),
            new League("PGA", "Golf"),
            new League("LPGA", "Golf"),
            new League("NFL", "Football")
    };

    public static final Team[] ARENA_TEAM_LIST = {
            new Team("Hà Nội FC", new League("V-league", "Soccer"), new LatLng(21.0293043, 105.8300364), "Một câu lạc bộ bóng đá chuyên nghiệp, hiện đang thi đấu ở V-league 2", "http://hanoifc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_H%C3%A0_N%E1%BB%99i_(b%C3%B3ng_%C4%91%C3%A1)", R.drawable.ha_noi_fc),
            new Team("FLC Thanh Hoá FC", new League("V-league", "Soccer"), new LatLng(19.7993415, 105.7705244), "Câu lạc bộ bóng đá FLC Thanh Hóa có trụ sở tại thành phố Thanh Hóa, hiện đang thi đấu tại V.League-1", "http://bongdathanhhoa.com/", "https://en.wikipedia.org/wiki/FLC_Thanh_H%C3%B3a_F.C.", R.drawable.flc_thanh_hoa_fc),
            new Team("Becamex Bình Dương FC", new League("V-league", "Soccer"), new LatLng(10.9709618, 106.6701027), "The V-League 1 Champion", "http://www.bongdabinhduong.com/", "https://en.wikipedia.org/wiki/Becamex_B%C3%ACnh_D%C6%B0%C6%A1ng_F.C.", R.drawable.binh_duong_fc),
            new Team("Đồng Nai FC", new League("V-league", "Soccer"), new LatLng(10.961926, 106.860638), "A football club play in V-league 1", "", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_%C4%90%E1%BB%93ng_Nai", R.drawable.dong_nai_fc),
            new Team("Đồng Tháp FC", new League("V-league", "Soccer"), new LatLng(10.4647408, 105.6397005), "A football club play in V-league 1", "http://dongthapfc.org/", "https://en.wikipedia.org/wiki/%C4%90%E1%BB%93ng_Th%C3%A1p_FC", R.drawable.dong_thap_fc),
            new Team("Long An FC", new League("V-league", "Soccer"), new LatLng(10.536092, 106.4058256), "A football club play in V-league 1", "http://www.dongtamlongan.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Long_An", R.drawable.long_an_fc),
            new Team("Hoàng Anh Gia Lai FC", new League("V-league", "Soccer"), new LatLng(13.978976, 108.0026644), "A football club play in V-league 1", "http://haglfc.com.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Ho%C3%A0ng_Anh_Gi_Lai", R.drawable.hagl_fc),
            new Team("Hà Nội T&T FC", new League("V-league", "Soccer"), new LatLng(21.0293043, 105.8234704), "A football club play in V-league 1", "http://hanoittfc.com.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_H%C3%A0_N%E1%BB%99i_T%26T", R.drawable.ha_noi_t_and_t_fc),
            new Team("Hải Phòng FC", new League("V-league", "Soccer"), new LatLng(20.8513546, 106.6862894), "A football club play in V-league 1", "http://haiphongfc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_H%E1%BA%A3i_Ph%B2ng", R.drawable.hai_phong_fc),
            new Team("SHB Đà Nẵng FC", new League("V-league", "Soccer"), new LatLng(16.0695535, 108.2142115), "A football club play in V-league 1", "", "https://en.wikipedia.org/wiki/SHB_%C4%90%C3%A0_N%E1%BA%B5ng_F.C.", R.drawable.shb_da_nang_fc),
            new Team("Song Lam Nghe An FC", new League("V-league", "Soccer"), new LatLng(18.6688515, 105.6673489), "A football club play in V-league 1", "http://www.slna-fc.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_S%C3%B4ng_Lam_Ngh%E1%BB%87_An", R.drawable.slna_fc),
            new Team("Sanna Khanh Hoa FC", new League("V-league", "Soccer"), new LatLng(12.2501953, 109.1906473), "A football club play in V-league 1", "http://www.khanhhoafc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Sanna_Kh%C3%A1nh_H%C3%B2a", R.drawable.sanna_khanh_hoa),
            new Team("Than Quang Ninh FC", new League("V-league", "Soccer"), new LatLng(21.0374099, 107.1231561), "A football club play in V-league 1", "http://thanquangninhfc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Than_Qu%E1%BA%A3ng_Ninh", R.drawable.quang_ninh_fc),
            new Team("QNK Quang Nam FC", new League("V-league", "Soccer"), new LatLng(15.5599398, 108.5045869), "A football club play in V-league 1", "", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Qu%E1%BA%A3ng_Nam", R.drawable.qnk_quang_nam_fc),
            new Team("XSKT Can Tho FC", new League("V-league", "Soccer"), new LatLng(10.0488396, 105.7858791), "A football club play in V-league 1", "http://www.bongdacantho.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_C%E1%BA%A7n_Th%C6%A1", R.drawable.xskt_can_tho),

            // MLS
            new Team("Chicago Fire", AMERICA_LEAGUE[0], new LatLng(41.7660957, -87.8079472), "An American professional soccer club based in the Chicago", "http://www.chicago-fire.com/", "https://en.wikipedia.org/wiki/Chicago_Fire_Soccer_Club", R.drawable.chicago_fire_sc),
            new Team("Columbus Crew SC", AMERICA_LEAGUE[0], new LatLng(40.0090861,-82.9934167), "A professional soccer club based in Columbus, Ohio, United States", "http://www.columbuscrewsc.com/", "https://en.wikipedia.org/wiki/Columbus_Crew_SC", R.drawable.columbus_crew_sc),
            new Team("D.C United", AMERICA_LEAGUE[0], new LatLng(38.8897941,-76.9741951), "An American professional soccer club based in Washington, D.C", "http://www.dcunited.com/", "https://en.wikipedia.org/wiki/D.C._United", R.drawable.dc_united),
            new Team("Montreal Impact", AMERICA_LEAGUE[0], new LatLng(45.5622984,-73.555221), "A Canadian professional soccer team based in Montreal, Quebec", "http://www.impactmontreal.com/", "https://en.wikipedia.org/wiki/Montreal_Impact", R.drawable.montreal_impact),
            new Team("New England Revolution", AMERICA_LEAGUE[0], new LatLng(42.0909605,-71.2665542), "An American professional soccer club based in the Greater Boston", "http://www.revolutionsoccer.net/", "https://en.wikipedia.org/wiki/New_England_Revolution", R.drawable.new_england_revolution),
            new Team("New York City FC", AMERICA_LEAGUE[0], new LatLng(40.8296466,-73.9283632), "An American professional soccer team based in New York City", "http://www.nycfc.com/", "https://en.wikipedia.org/wiki/New_York_City_FC", R.drawable.new_york_city_fc),
            new Team("New York Red Bulls", AMERICA_LEAGUE[0], new LatLng(40.7369928,-74.1518843), "An American professional soccer team based in Harrison, New Jersey", "http://www.newyorkredbulls.com/", "https://en.wikipedia.org/wiki/New_York_Red_Bulls", R.drawable.new_york_red_bull_fc),
            new Team("Orlando City SC", AMERICA_LEAGUE[0], new LatLng(28.5390835,-81.4049944), "An American professional soccer club based in Orlando, Florida", "http://orlandocitysc.com/", "https://en.wikipedia.org/wiki/Orlando_City_SC", R.drawable.orlando_city_sc),
            new Team("Philadelphia Union", AMERICA_LEAGUE[0], new LatLng(39.8327712,-75.3806233), "An American professional soccer team based in Chester, Pennsylvania", "http://www.philadelphiaunion.com/", "https://en.wikipedia.org/wiki/Philadelphia_Union", R.drawable.philadelphia_union),
            new Team("Toronto FC", AMERICA_LEAGUE[0], new LatLng(43.6330306,-79.420665), "A Canadian professional soccer club based in Toronto, Ontario", "http://www.torontofc.ca/", "https://en.wikipedia.org/wiki/Toronto_FC", R.drawable.toronto_fc),
            new Team("Colorado Rapids", AMERICA_LEAGUE[0], new LatLng(39.8056838,-104.8939723), "An American professional soccer team, based in the Denver suburb of Commerce City, Colorado", "http://www.coloradorapids.com/", "https://en.wikipedia.org/wiki/Colorado_Rapids", R.drawable.colorado_rapids),
            new Team("FC Dallas", AMERICA_LEAGUE[0], new LatLng(33.1543384,-96.8373606), "An American professional soccer club based in the Dallas suburb of Frisco, Texas", "http://www.fcdallas.com/", "https://en.wikipedia.org/wiki/FC_Dallas", R.drawable.fc_dallas),
            new Team("Houston Dynamo", AMERICA_LEAGUE[0], new LatLng(29.7522034,-95.3546033), "An American professional soccer club based in Houston, Texas, United States", "http://www.houstondynamo.com/", "https://en.wikipedia.org/wiki/Houston_Dynamo", R.drawable.houston_dynamo),
            new Team("LA Galaxy", AMERICA_LEAGUE[0], new LatLng(33.8643422,-118.2633111), "An American professional soccer franchise based in the Los Angeles suburb of Carson, California", "http://www.lagalaxy.com/", "https://en.wikipedia.org/wiki/LA_Galaxy", R.drawable.la_galaxy),
            new Team("Portland Timbers", AMERICA_LEAGUE[0], new LatLng(45.5216015,-122.6938698), "An American professional soccer club based in Portland, Oregon", "http://timbers.com/", "https://en.wikipedia.org/wiki/Portland_Timbers", R.drawable.portland_timbers),
            new Team("Real Salt Lake", AMERICA_LEAGUE[0], new LatLng(40.5829355,-111.8955495), "An American professional soccer club that competes in the Western Conference", "http://www.rsl.com/", "https://en.wikipedia.org/wiki/Real_Salt_Lake", R.drawable.real_salt_lake),
            new Team("San Jose Earthquakes", AMERICA_LEAGUE[0], new LatLng(37.3512609,-121.9275176), "An American professional soccer team based in San Jose, California, United States", "http://www.sjearthquakes.com/", "https://en.wikipedia.org/wiki/San_Jose_Earthquakes", R.drawable.san_jose_earthquakes),
            new Team("Seattle Sounders FC", AMERICA_LEAGUE[0], new LatLng(47.5951554,-122.333828), "An American professional soccer club based in Seattle, Washington", "http://www.soundersfc.com/", "https://en.wikipedia.org/wiki/Seattle_Sounders_FC", R.drawable.seattle_sounders_fc),
            new Team("Sporting Kansas City", AMERICA_LEAGUE[0], new LatLng(39.1214084,-94.8255301), "An American professional soccer club based in Kansas City, Missouri", "http://www.sportingkc.com/", "https://en.wikipedia.org/wiki/Sporting_Kansas_City", R.drawable.sporting_kansas_city),
            new Team("Vancouver Whitecaps FC", AMERICA_LEAGUE[0], new LatLng(49.2767535,-123.1141877), "A Canadian professional soccer team based in Vancouver, British Columbia", "http://www.whitecapsfc.com/", "https://en.wikipedia.org/wiki/Vancouver_Whitecaps_FC", R.drawable.vancouver_whitecaps_fc),
    };

    public static final Team[] AMERICA_TEAM_LIST = {
            // MLS
            new Team("Chicago Fire", AMERICA_LEAGUE[0], new LatLng(41.7660957, -87.8079472), "An American professional soccer club based in the Chicago", "http://www.chicago-fire.com/", "https://en.wikipedia.org/wiki/Chicago_Fire_Soccer_Club", R.drawable.chicago_fire_sc),
            new Team("Columbus Crew SC", AMERICA_LEAGUE[0], new LatLng(40.0090861,-82.9934167), "A professional soccer club based in Columbus, Ohio, United States", "http://www.columbuscrewsc.com/", "https://en.wikipedia.org/wiki/Columbus_Crew_SC", R.drawable.columbus_crew_sc),
            new Team("D.C United", AMERICA_LEAGUE[0], new LatLng(38.8897941,-76.9741951), "An American professional soccer club based in Washington, D.C", "http://www.dcunited.com/", "https://en.wikipedia.org/wiki/D.C._United", R.drawable.dc_united),
            new Team("Montreal Impact", AMERICA_LEAGUE[0], new LatLng(45.5622984,-73.555221), "A Canadian professional soccer team based in Montreal, Quebec", "http://www.impactmontreal.com/", "https://en.wikipedia.org/wiki/Montreal_Impact", R.drawable.montreal_impact),
            new Team("New England Revolution", AMERICA_LEAGUE[0], new LatLng(42.0909605,-71.2665542), "An American professional soccer club based in the Greater Boston", "http://www.revolutionsoccer.net/", "https://en.wikipedia.org/wiki/New_England_Revolution", R.drawable.new_england_revolution),
            new Team("New York City FC", AMERICA_LEAGUE[0], new LatLng(40.8296466,-73.9283632), "An American professional soccer team based in New York City", "http://www.nycfc.com/", "https://en.wikipedia.org/wiki/New_York_City_FC", R.drawable.new_york_city_fc),
            new Team("New York Red Bulls", AMERICA_LEAGUE[0], new LatLng(40.7369928,-74.1518843), "An American professional soccer team based in Harrison, New Jersey", "http://www.newyorkredbulls.com/", "https://en.wikipedia.org/wiki/New_York_Red_Bulls", R.drawable.new_york_red_bull_fc),
            new Team("Orlando City SC", AMERICA_LEAGUE[0], new LatLng(28.5390835,-81.4049944), "An American professional soccer club based in Orlando, Florida", "http://orlandocitysc.com/", "https://en.wikipedia.org/wiki/Orlando_City_SC", R.drawable.orlando_city_sc),
            new Team("Philadelphia Union", AMERICA_LEAGUE[0], new LatLng(39.8327712,-75.3806233), "An American professional soccer team based in Chester, Pennsylvania", "http://www.philadelphiaunion.com/", "https://en.wikipedia.org/wiki/Philadelphia_Union", R.drawable.philadelphia_union),
            new Team("Toronto FC", AMERICA_LEAGUE[0], new LatLng(43.6330306,-79.420665), "A Canadian professional soccer club based in Toronto, Ontario", "http://www.torontofc.ca/", "https://en.wikipedia.org/wiki/Toronto_FC", R.drawable.toronto_fc),
            new Team("Colorado Rapids", AMERICA_LEAGUE[0], new LatLng(39.8056838,-104.8939723), "An American professional soccer team, based in the Denver suburb of Commerce City, Colorado", "http://www.coloradorapids.com/", "https://en.wikipedia.org/wiki/Colorado_Rapids", R.drawable.colorado_rapids),
            new Team("FC Dallas", AMERICA_LEAGUE[0], new LatLng(33.1543384,-96.8373606), "An American professional soccer club based in the Dallas suburb of Frisco, Texas", "http://www.fcdallas.com/", "https://en.wikipedia.org/wiki/FC_Dallas", R.drawable.fc_dallas),
            new Team("Houston Dynamo", AMERICA_LEAGUE[0], new LatLng(29.7522034,-95.3546033), "An American professional soccer club based in Houston, Texas, United States", "http://www.houstondynamo.com/", "https://en.wikipedia.org/wiki/Houston_Dynamo", R.drawable.houston_dynamo),
            new Team("LA Galaxy", AMERICA_LEAGUE[0], new LatLng(33.8643422,-118.2633111), "An American professional soccer franchise based in the Los Angeles suburb of Carson, California", "http://www.lagalaxy.com/", "https://en.wikipedia.org/wiki/LA_Galaxy", R.drawable.la_galaxy),
            new Team("Portland Timbers", AMERICA_LEAGUE[0], new LatLng(45.5216015,-122.6938698), "An American professional soccer club based in Portland, Oregon", "http://timbers.com/", "https://en.wikipedia.org/wiki/Portland_Timbers", R.drawable.portland_timbers),
            new Team("Real Salt Lake", AMERICA_LEAGUE[0], new LatLng(40.5829355,-111.8955495), "An American professional soccer club that competes in the Western Conference", "http://www.rsl.com/", "https://en.wikipedia.org/wiki/Real_Salt_Lake", R.drawable.real_salt_lake),
            new Team("San Jose Earthquakes", AMERICA_LEAGUE[0], new LatLng(37.3512609,-121.9275176), "An American professional soccer team based in San Jose, California, United States", "http://www.sjearthquakes.com/", "https://en.wikipedia.org/wiki/San_Jose_Earthquakes", R.drawable.san_jose_earthquakes),
            new Team("Seattle Sounders FC", AMERICA_LEAGUE[0], new LatLng(47.5951554,-122.333828), "An American professional soccer club based in Seattle, Washington", "http://www.soundersfc.com/", "https://en.wikipedia.org/wiki/Seattle_Sounders_FC", R.drawable.seattle_sounders_fc),
            new Team("Sporting Kansas City", AMERICA_LEAGUE[0], new LatLng(39.1214084,-94.8255301), "An American professional soccer club based in Kansas City, Missouri", "http://www.sportingkc.com/", "https://en.wikipedia.org/wiki/Sporting_Kansas_City", R.drawable.sporting_kansas_city),
            new Team("Vancouver Whitecaps FC", AMERICA_LEAGUE[0], new LatLng(49.2767535,-123.1141877), "A Canadian professional soccer team based in Vancouver, British Columbia", "http://www.whitecapsfc.com/", "https://en.wikipedia.org/wiki/Vancouver_Whitecaps_FC", R.drawable.vancouver_whitecaps_fc),

            // NBA
            new Team("Boston Celtics", AMERICA_LEAGUE[1], new LatLng(42.3662019,-71.0643347), "An American professional basketball team based in Boston, Massachusetts", "http://www.celtics.com/", "https://en.wikipedia.org/wiki/Boston_Celtics", R.drawable.boston_celtics),
            new Team("Brooklyn Nets", AMERICA_LEAGUE[1], new LatLng(40.6825297,-73.977245), "An American professional basketball team based in New York City", "http://www.brooklynnets.com/", "https://en.wikipedia.org/wiki/Brooklyn_Nets", R.drawable.brooklyn_nets),
            new Team("New York Knicks", AMERICA_LEAGUE[1], new LatLng(40.7505085,-73.9956274), "An American professional basketball team based in New York City", "http://www.knicks.com/", "https://en.wikipedia.org/wiki/New_York_Knicks", R.drawable.new_york_knicks),
            new Team("Philadelphia 76ers", AMERICA_LEAGUE[1], new LatLng(39.9012056,-75.1741682), "An American professional basketball team based in Philadelphia, Pennsylvaniac", "http://www.nba.com/sixers", "https://en.wikipedia.org/wiki/Philadelphia_76ers", R.drawable.philadelphia_76ers),
            new Team("Toronto Raptors", AMERICA_LEAGUE[1], new LatLng(43.64347,-79.3812876), "A Canadian professional basketball team based in Toronto, Ontario", "http://www.raptors.com/", "https://en.wikipedia.org/wiki/Toronto_Raptors", R.drawable.toronto_raptors),
            new Team("Chicago Bulls", AMERICA_LEAGUE[1], new LatLng(41.8806948,-87.6763646), "An American professional basketball team based in Chicago, Illinois", "http://www.bulls.com/", "https://en.wikipedia.org/wiki/Chicago_Bulls", R.drawable.chicago_bulls),
            new Team("Cleveland Cavaliers", AMERICA_LEAGUE[1], new LatLng(41.496645,-81.6903976), "An American professional basketball team based in Cleveland, Ohio", "http://www.cavs.com/", "https://en.wikipedia.org/wiki/Cleveland_Cavaliers", R.drawable.cleveland_cavaliers),
            new Team("Detroit Pistons", AMERICA_LEAGUE[1], new LatLng(42.6968889,-83.2479816), "An American professional basketball team based in Auburn Hills, Michigan", "http://www.pistons.com/", "https://en.wikipedia.org/wiki/Detroit_Pistons", R.drawable.detroit_pistons),
            new Team("Indiana Pacers", AMERICA_LEAGUE[1], new LatLng(39.7639345,-86.1577324), "A professional basketball team based in Indianapolis, Indiana", "http://www.pacers.com/", "https://en.wikipedia.org/wiki/Indiana_Pacers", R.drawable.indiana_pacers),
            new Team("Milwaukee Bucks", AMERICA_LEAGUE[1], new LatLng(43.0436908,-87.9193975), "An American professional basketball franchise based in Milwaukee, Wisconsin", "http://www.bucks.com/", "https://en.wikipedia.org/wiki/Milwaukee_Bucks", R.drawable.milwaukee_bucks),
            new Team("Atlanta Hawks", AMERICA_LEAGUE[1], new LatLng(33.7572935,-84.3985131), "A professional basketball team based in Atlanta, Georgia", "http://www.hawks.com/", "https://en.wikipedia.org/wiki/Atlanta_Hawks", R.drawable.atlanta_hawks),
            new Team("Charlotte Hornets", AMERICA_LEAGUE[1], new LatLng(35.2250519,-80.8415276), "An American professional basketball team based in Charlotte, North Carolina", "http://www.hornets.com/", "https://en.wikipedia.org/wiki/Charlotte_Hornets", R.drawable.charlotte_hornets),
            new Team("Miami Heat", AMERICA_LEAGUE[1], new LatLng(25.7814062,-80.1891577), "An American professional basketball team based in Miami, Florida", "http://www.heat.com/", "https://en.wikipedia.org/wiki/Miami_Heat", R.drawable.miami_heat),
            new Team("Orlando Magic", AMERICA_LEAGUE[1], new LatLng(28.5396735,-81.386123), "An American professional basketball team based in Orlando, Florida", "http://www.orlandomagic.com/", "https://en.wikipedia.org/wiki/Orlando_Magic", R.drawable.orlando_magic),
            new Team("Washington Wizards", AMERICA_LEAGUE[1], new LatLng(38.8981362,-77.0231347), "An American professional basketball team based in Washington, D.C", "http://www.washingtonwizards.com/", "https://en.wikipedia.org/wiki/Washington_Wizards", R.drawable.washington_wizards),
            new Team("Denver Nuggets", AMERICA_LEAGUE[1], new LatLng(39.7486638,-105.009899), "An American professional basketball team based in Denver, Colorado", "http://www.nuggets.com/", "https://en.wikipedia.org/wiki/Denver_Nuggets", R.drawable.denver_nuggets),
            new Team("Minnesota Timberwolves", AMERICA_LEAGUE[1], new LatLng(44.9794583,-93.2783786), "An American professional basketball team based in Minneapolis, Minnesota", "http://www.timberwolves.com/", "https://en.wikipedia.org/wiki/Minnesota_Timberwolves", R.drawable.minnesota_timberwolves),
            new Team("Oklahoma City Thunder", AMERICA_LEAGUE[1], new LatLng(35.4634428,-97.5172809), "An American professional basketball team based in Oklahoma City, Oklahoma", "http://www.okcthunder.com/", "https://en.wikipedia.org/wiki/Oklahoma_City_Thunder", R.drawable.oklahoma_city_thunder),
            new Team("Portland Trail Blazers", AMERICA_LEAGUE[1], new LatLng(45.5315688,-122.669031), "An American professional basketball team based in Portland, Oregon", "http://www.trailblazers.com/", "https://en.wikipedia.org/wiki/Portland_Trail_Blazers", R.drawable.portland_trail_blazers),
            new Team("Utah Jazz", AMERICA_LEAGUE[1], new LatLng(40.7682721,-111.9032761), "An American professional basketball team based in Salt Lake City, Utah", "http://www.utahjazz.com/", "https://en.wikipedia.org/wiki/Utah_Jazz", R.drawable.utah_jazz),
            new Team("Golden State Warriors", AMERICA_LEAGUE[1], new LatLng(37.7503445,-122.2052593), "An American professional basketball team based in Oakland, California", "http://www.warriors.com/", "https://en.wikipedia.org/wiki/Golden_State_Warriors", R.drawable.golden_state_warriors),
            new Team("Los Angeles Clippers", AMERICA_LEAGUE[1], new LatLng(34.0430219,-118.2694428), "An American professional basketball team based in Los Angeles, California", "http://www.clippers.com/", "https://en.wikipedia.org/wiki/Los_Angeles_Clippers", R.drawable.los_angeles_clippers),
            new Team("Los Angeles Lakers", AMERICA_LEAGUE[1], new LatLng(34.0430219,-118.2694428), "An American professional basketball team based in Los Angeles, California", "http://www.lakers.com/", "https://en.wikipedia.org/wiki/Los_Angeles_Lakers", R.drawable.los_angeles_lakers),
            new Team("Phoenix Suns", AMERICA_LEAGUE[1], new LatLng(33.4458061,-112.0733782), "An American professional basketball team based in Phoenix, Arizona", "http://www.suns.com/", "https://en.wikipedia.org/wiki/Phoenix_Suns", R.drawable.phoenix_suns),
            new Team("Sacramento Kings", AMERICA_LEAGUE[1], new LatLng(38.6491123,-121.5204405), "An American professional basketball team based in Sacramento, California", "http://www.nba.com/kings", "https://en.wikipedia.org/wiki/Sacramento_Kings", R.drawable.sacramento_kings),
            new Team("Dallas Mavericks", AMERICA_LEAGUE[1], new LatLng(32.7904901,-96.8125532), "An American professional basketball team based in Dallas, Texas", "http://www.mavs.com/", "https://en.wikipedia.org/wiki/Dallas_Mavericks", R.drawable.dallas_mavericks),
            new Team("Houston Rockets", AMERICA_LEAGUE[1], new LatLng(29.750765,-95.3642892), "An American professional basketball team based in Houston, Texas", "http://www.rockets.com/", "https://en.wikipedia.org/wiki/Houston_Rockets", R.drawable.houston_rockets),
            new Team("Memphis Grizzlies", AMERICA_LEAGUE[1], new LatLng(35.1382059,-90.0526377), "An American professional basketball team based in Memphis, Tennessee", "http://www.grizzlies.com/", "https://en.wikipedia.org/wiki/Memphis_Grizzlies", R.drawable.memphis_grizzlies),
            new Team("New Orleans Pelicans", AMERICA_LEAGUE[1], new LatLng(29.9490397,-90.0842455), "An American professional basketball team based in New Orleans, Louisiana", "http://www.pelicans.com/", "https://en.wikipedia.org/wiki/New_Orleans_Pelicans", R.drawable.new_orleans_pelicans),
            new Team("San Antonio Spurs", AMERICA_LEAGUE[1], new LatLng(29.4270033,-98.4396523), "An American professional basketball team based in San Antonio, Texas", "http://www.spurs.com/", "https://en.wikipedia.org/wiki/San_Antonio_Spurs", R.drawable.san_antonio_spurs),
    };


    public static final Country[] COUNTRIES = {
            new Country("Vietnam", new LatLng(14.058324, 108.277199), new LatLngBounds(new LatLng(8.4127295, 102.14441), new LatLng(23.393395, 109.4689777))),
            new Country("Cambodia", new LatLng(12.565679, 104.990963), new LatLngBounds(new LatLng(9.2857541, 102.333542), new LatLng(14.6901791, 107.627687))),
            new Country("Japan", new LatLng(36.204824, 138.252924), new LatLngBounds(new LatLng(20.421981, 122.9338302), new LatLng(45.5227719, 153.9874306))),
            new Country("China", new LatLng(35.86166, 104.195397), new LatLngBounds(new LatLng(18.1576156, 73.4994136), new LatLng(53.560974, 134.7728099))),
            new Country("Singapore", new LatLng(1.352083, 103.819836), new LatLngBounds(new LatLng(1.1587023, 103.6055575), new LatLng(1.4707592, 104.0884808))),
            new Country("Myanmar", new LatLng(21.913965, 95.956223), new LatLngBounds(new LatLng(9.5990942, 92.171808), new LatLng(28.5478351, 101.1702717))),
            new Country("Malaysia", new LatLng(4.210484, 101.975766), new LatLngBounds(new LatLng(0.8538209, 98.9362527), new LatLng(7.3796311, 119.2693619))),
            new Country("Brunei Darussalam", new LatLng(4.535277, 114.727669), new LatLngBounds(new LatLng(4.002461, 114.075298), new LatLng(5.0460363, 115.3639552))),
            new Country("United States", new LatLng(37.09024, -95.712891), new LatLngBounds(new LatLng(18.9106768, 172.4458955), new LatLng(71.3867745, -66.9502861))),
            new Country("United Kingdom", new LatLng(55.378051, -3.435973), new LatLngBounds(new LatLng(34.5626609, -8.6493572), new LatLng(60.8608663, 33.9165549))),
            new Country("Uruguay", new LatLng(-32.522779, -55.765835), new LatLngBounds(new LatLng(-35.0314638, -58.4392226), new LatLng(-30.0852149, -53.1841651))),
            new Country("Togo", new LatLng(8.619543, 0.824782), new LatLngBounds(new LatLng(6.112395, -0.144042), new LatLng(11.1404963, 1.8088218))),
            new Country("Switzerland", new LatLng(46.818188, 8.227511999999999), new LatLngBounds(new LatLng(45.81792, 5.95608), new LatLng(47.8084546, 10.4923401))),
            new Country("Turkey", new LatLng(38.963745, 35.243322), new LatLngBounds(new LatLng(25.6655487, 35.808592), new LatLng(42.1062391, 44.8178449))),
            new Country("Afghanistan", new LatLng(33.93911, 67.709953), new LatLngBounds(new LatLng(29.3772, 60.5170005), new LatLng(38.4908767, 74.8898619))),
            new Country("Albania", new LatLng(41.153332, 20.168331), new LatLngBounds(new LatLng(39.6447296, 19.2639364), new LatLng(42.6610819, 21.0572394))),
            new Country("Algeria", new LatLng(28.033886, 1.659626), new LatLngBounds(new LatLng(18.968147, -8.6676113), new LatLng(37.0898205, 37.0898205))),
            new Country("American Samoa", new LatLng(-14.3060204, -170.6961815), new LatLngBounds(new LatLng(-14.3824778, -170.846781), new LatLng(-14.1551045, -169.4186268))),
            new Country("Andorra", new LatLng(42.506285, 1.521801), new LatLngBounds(new LatLng(42.4287488, 1.4087052), new LatLng(42.655791, 1.786639))),
            new Country("Angola", new LatLng(-11.202692, 17.873887), new LatLngBounds(new LatLng(-18.0391039, 11.669562), new LatLng(-4.3879439, 24.0878855))),
            new Country("Anguilla", new LatLng(18.220554, -63.06861499999999), new LatLngBounds(new LatLng(18.1499463, -63.4289821), new LatLng(18.595088, -62.92243479999999))),
            new Country("Antigua and Barbuda", new LatLng(17.060816, -61.796428), new LatLngBounds(new LatLng(16.9325319, -62.347657), new LatLng(17.7291866, -61.6571617))),
            new Country("Argentina", new LatLng(-38.416097, -63.61667199999999), new LatLngBounds(new LatLng(-55.05727899, -73.5603601), new LatLng(-21.7810459, -53.637481))),
            new Country("Armenia", new LatLng(40.069099, 45.038189), new LatLngBounds(new LatLng(38.840244, 43.4472601), new LatLng(41.300993, 46.634222))),
            new Country("Aruba", new LatLng(12.52111, -69.968338), new LatLngBounds(new LatLng(12.4117656, -70.0660256), new LatLng(12.6233629, -69.8656548))),
            new Country("Australia", new LatLng(-25.274398, 133.775136), new LatLngBounds(new LatLng(-54.7772185, 112.9214336), new LatLng(-9.2198215, 159.255497))),
            new Country("Austria", new LatLng(47.516231, 14.550072), new LatLngBounds(new LatLng(46.37233579999999, 9.530783399999999), new LatLng(49.0206081, 17.1606861))),
            new Country("Azerbaijan", new LatLng(40.143105, 47.576927), new LatLngBounds(new LatLng(38.3922171, 44.7632599), new LatLng(41.9123402, 50.6211509))),
            new Country("The Bahamas", new LatLng(25.03428, -77.39628), new LatLngBounds(new LatLng(20.9101345, -80.4749465), new LatLng(27.263362, -72.7120686))),
            new Country("United Arab Emirates", new LatLng(23.424076, 53.847818), new LatLngBounds(new LatLng(22.6315138, 22.6315138), new LatLng(26.0696541, 56.3815785))),
            new Country("Bosnia and Herzegovina", new LatLng(43.915886, 17.679076), new LatLngBounds(new LatLng(42.5564516, 15.7223665), new LatLng(45.2766262, 19.621935))),
            new Country("Barbados", new LatLng(13.193887, -59.543198), new LatLngBounds(new LatLng(13.0449995, -59.6510303), new LatLng(13.3352656, -59.4200975))),
            new Country("Bangladesh", new LatLng(23.684994, 90.356331), new LatLngBounds(new LatLng(20.7464107, 88.00858869999999), new LatLng(26.6342434, 92.6801153))),
            new Country("Belgium", new LatLng(50.503887, 4.469936), new LatLngBounds(new LatLng(49.497013, 2.5447948), new LatLng(51.5051449, 6.408124099999999))),
            new Country("Burkina Faso", new LatLng(12.238333, -1.561593), new LatLngBounds(new LatLng(9.4104719, -5.5157196), new LatLng(15.0840032, 2.4043598))),
            new Country("Bulgaria", new LatLng(42.733883, 25.48583), new LatLngBounds(new LatLng(41.2354469, 22.3573446), new LatLng(44.2145381, 28.6092632))),
            new Country("Bahrain", new LatLng(25.930414, 50.637772), new LatLngBounds(new LatLng(25.5564577, 50.37815089), new LatLng(26.3303935, 50.82484609999999))),
            new Country("Burundi", new LatLng(-3.373056, 29.918886), new LatLngBounds(new LatLng(-4.4693288, 29.000993), new LatLng(-2.3097302, 30.8495447))),
            new Country("Benin", new LatLng(9.30769, 2.315834), new LatLngBounds(new LatLng(6.2345966, 0.7765055), new LatLng(12.4086111, 3.8433429))),
            new Country("Bermuda", new LatLng(32.321384, -64.75737), new LatLngBounds(new LatLng(32.24705, -64.886788), new LatLng(32.3909894, -64.6473774))),
            new Country("Bolivia", new LatLng(-16.290154, -63.588653), new LatLngBounds(new LatLng(-22.8980899, -69.64498999999999), new LatLng(-9.669323, -57.453803))),
            new Country("Brazil", new LatLng(-14.235004, -51.92528), new LatLngBounds(new LatLng(-33.7509909, -73.982817), new LatLng(5.2717863, -29.3448224))),
            new Country("Bhutan", new LatLng(27.514162, 90.433601), new LatLngBounds(new LatLng(26.702016, 88.7464735), new LatLng(28.360825, 92.1252321))),
            new Country("Bouvet Island", new LatLng(-54.423199, 3.413194), new LatLngBounds(new LatLng(-54.4541004, 3.2858826), new LatLng(-54.3873565, 3.4382056))),
            new Country("Botswana", new LatLng(-22.328474, 24.684866), new LatLngBounds(new LatLng(-26.907545, 19.998903), new LatLng(-17.778137, 29.375304))),
            new Country("Belarus", new LatLng(53.709807, 27.953389), new LatLngBounds(new LatLng(51.262011, 23.1783377), new LatLng(56.1718719, 32.7768202))),
            new Country("Belize", new LatLng(17.189877, -88.49765), new LatLngBounds(new LatLng(15.8856189, -89.2275879), new LatLng(18.4959419, -87.49172689))),
            new Country("Canada", new LatLng(56.130366, -106.346771), new LatLngBounds(new LatLng(41.6765559, -141.00187), new LatLng(83.0956562, -52.6206965))),
            new Country("Cocos Islands", new LatLng(-12.164165, 96.870956), new LatLngBounds(new LatLng(-12.2088942, 96.8166785), new LatLng(-11.8221887, 96.929585))),
            new Country("Congo", new LatLng(-4.038333, 21.758664), new LatLngBounds(new LatLng(-5.0289718, 11.1530037), new LatLng(3.707791, 18.643611))),
            new Country("Central African Republic", new LatLng(6.611111, 20.939444), new LatLngBounds(new LatLng(2.2208493, 14.4150981), new LatLng(11.0179569, 27.4583049))),
            new Country("Switzerland", new LatLng(46.818188, 8.227512), new LatLngBounds(new LatLng(45.81792, 5.95608), new LatLng(47.8084546, 10.4923401))),
            new Country("Côte d'Ivoire", new LatLng(7.539989, -5.54708), new LatLngBounds(new LatLng(4.3510552, -8.6020589), new LatLng(10.7400151, -2.493031))),
            new Country("Cook Islands", new LatLng(-21.236736, -159.777671), new LatLngBounds(new LatLng(-21.9591364, -165.8783468), new LatLng(-8.916606, -157.3216064))),
            new Country("Chile", new LatLng(-35.675147, -71.542969), new LatLngBounds(new LatLng(-55.9805353, -109.4548805), new LatLng(-17.4983293, -66.4169643))),
            new Country("Cameroon", new LatLng(7.369722, 12.354722), new LatLngBounds(new LatLng(1.6559, 8.4947635), new LatLng(13.083335, 16.1944081))),
            new Country("Colombia", new LatLng(4.570868, -74.297333), new LatLngBounds(new LatLng(-4.22711, -81.7357489), new LatLng(13.3944833, -66.851923))),
            new Country("Costa Rica", new LatLng(9.748917, -83.753428), new LatLngBounds(new LatLng(5.4991622, -87.0944591), new LatLng(11.2196808, -82.5526571))),
            new Country("Cuba", new LatLng(21.521757, -77.781167), new LatLngBounds(new LatLng(19.8258994, -84.9518887), new LatLng(23.2767521, -74.1322231))),
            new Country("Cape Verde", new LatLng(16.002082, -24.013197), new LatLngBounds(new LatLng(14.8026842, -25.3610776), new LatLng(17.2047752, -22.6576979))),
            new Country("Christmas Island", new LatLng(-10.447525, 105.690449), new LatLngBounds(new LatLng(-10.5703619, 105.5333161), new LatLng(-10.4123742, 105.7127383))),
            new Country("Cyprus", new LatLng(33.429859, 35.126413), new LatLngBounds(new LatLng(34.632303, 32.2694816), new LatLng(35.7071963, 34.6044825))),
            new Country("Czech Republic", new LatLng(49.817492, 15.472962), new LatLngBounds(new LatLng(48.5518081, 12.090589), new LatLng(51.0557185, 18.8592361))),
            new Country("Germany", new LatLng(51.165691, 10.451526), new LatLngBounds(new LatLng(47.2701115, 5.8663425), new LatLng(55.0581236, 15.0418962))),
            new Country("Djibouti", new LatLng(11.825138, 42.590275), new LatLngBounds(new LatLng(10.9319439, 41.759722), new LatLng(12.7136162, 43.4173588))),
            new Country("Denmark", new LatLng(56.26392, 9.501785), new LatLngBounds(new LatLng(54.559169, 8.0722409), new LatLng(57.7518131, 15.1972813))),
            new Country("Indonesia", new LatLng(-0.789275, 113.921327), new LatLngBounds(new LatLng(-11.0074361, 95.009707), new LatLng(6.076912, 141.0195621))),
            new Country("Philippines", new LatLng(12.879721, 121.774017), new LatLngBounds(new LatLng(4.5870339, 116.7029193), new LatLng(19.5740241, 126.6043837))),
            new Country("Laos", new LatLng(19.85627, 102.495496), new LatLngBounds(new LatLng(13.90972, 100.0832139), new LatLng(22.502872, 107.69483))),
            new Country("North Korea", new LatLng(40.339852, 127.510093), new LatLngBounds(new LatLng(37.6733322, 124.2164294), new LatLng(43.01159, 130.6988006))),
            new Country("South Korea", new LatLng(35.907757, 127.766922), new LatLngBounds(new LatLng(33.1061095, 124.6081391), new LatLng(38.6169152, 130.9232178))),
            new Country("Russia", new LatLng(61.52401, 105.318756), new LatLngBounds(new LatLng(41.185353, 19.6398056), new LatLng(81.8581221, -169.045632))),
            new Country("Macau", new LatLng(22.198745, 113.543873), new LatLngBounds(new LatLng(22.1097694, 113.5287412), new LatLng(22.2170639, 113.5981886))),
            new Country("Timor-Leste", new LatLng(-8.874217, 125.727539), new LatLngBounds(new LatLng(-9.504195, 124.041738), new LatLng(-8.1268457, 127.3430437))),
            new Country("Hong Kong", new LatLng(22.396428, 114.109497), new LatLngBounds(new LatLng(22.1533884, 113.835078), new LatLng(22.561968, 114.4069573))),
            new Country("India", new LatLng(20.593684, 78.96288), new LatLngBounds(new LatLng(6.7535159, 68.1623859), new LatLng(35.5087008, 97.395561))),
            new Country("Thailand", new LatLng(15.870032, 100.992541), new LatLngBounds(new LatLng(5.612597, 97.343396), new LatLng(20.465143, 105.636812))),
            new Country("Qatar", new LatLng(25.354826, 51.183884), new LatLngBounds(new LatLng(24.471118, 50.7500553), new LatLng(26.1830927, 51.6432601))),
            new Country("Romania", new LatLng(45.943161, 24.96676), new LatLngBounds(new LatLng(43.6232977, 20.2617593), new LatLng(48.265274, 29.7571014))),
            new Country("Sweden", new LatLng(60.128161, 18.643501), new LatLngBounds(new LatLng(55.3367024, 10.9631866), new LatLng(69.0599709, 24.1668092))),
    };
}
