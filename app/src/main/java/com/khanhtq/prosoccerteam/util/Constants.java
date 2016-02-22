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

    public static final float DEFAULT_ZOOM_LEVEL = 10;

    public static final int UPDATE_LOCATION_TIME = 60000;

    public static final Team[] TEAM_LIST = {
            new Team("Hà Nội FC", new LatLng(21.0293043,105.8300364), "Một câu lạc bộ bóng đá chuyên nghiệp, hiện đang thi đấu ở V-league 2", "http://hanoifc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_H%C3%A0_N%E1%BB%99i_(b%C3%B3ng_%C4%91%C3%A1)", R.drawable.ha_noi_fc),
            new Team("FLC Thanh Hoá FC", new LatLng(19.7993415,105.7705244), "Câu lạc bộ bóng đá FLC Thanh Hóa có trụ sở tại thành phố Thanh Hóa, hiện đang thi đấu tại V.League-1", "http://bongdathanhhoa.com/", "https://en.wikipedia.org/wiki/FLC_Thanh_H%C3%B3a_F.C.", R.drawable.flc_thanh_hoa_fc),
            new Team("Becamex Bình Dương FC", new LatLng(10.9709618,106.6701027), "The V-League 1 Champion", "http://www.bongdabinhduong.com/", "https://en.wikipedia.org/wiki/Becamex_B%C3%ACnh_D%C6%B0%C6%A1ng_F.C.", R.drawable.binh_duong_fc),
            new Team("Đồng Nai FC", new LatLng(10.961926,106.860638), "A football club play in V-league 1", "", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_%C4%90%E1%BB%93ng_Nai", R.drawable.dong_nai_fc),
            new Team("Đồng Tháp FC", new LatLng(10.4647408,105.6397005), "A football club play in V-league 1", "http://dongthapfc.org/", "https://en.wikipedia.org/wiki/%C4%90%E1%BB%93ng_Th%C3%A1p_FC", R.drawable.dong_thap_fc),
            new Team("Long An FC", new LatLng(10.536092,106.4058256), "A football club play in V-league 1", "http://www.dongtamlongan.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Long_An", R.drawable.long_an_fc),
            new Team("Hoàng Anh Gia Lai FC", new LatLng(13.978976,108.0026644), "A football club play in V-league 1", "http://haglfc.com.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Ho%C3%A0ng_Anh_Gi_Lai", R.drawable.hagl_fc),
            new Team("Hà Nội T&T FC", new LatLng(21.0293043,105.8234704), "A football club play in V-league 1", "http://hanoittfc.com.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_H%C3%A0_N%E1%BB%99i_T%26T", R.drawable.ha_noi_t_and_t_fc),
            new Team("Hải Phòng FC", new LatLng(20.8513546,106.6862894), "A football club play in V-league 1", "http://haiphongfc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_H%E1%BA%A3i_Ph%B2ng", R.drawable.hai_phong_fc),
            new Team("SHB Đà Nẵng FC", new LatLng(16.0695535,108.2142115), "A football club play in V-league 1", "", "https://en.wikipedia.org/wiki/SHB_%C4%90%C3%A0_N%E1%BA%B5ng_F.C.", R.drawable.shb_da_nang_fc),
            new Team("Song Lam Nghe An FC", new LatLng(18.6688515,105.6673489), "A football club play in V-league 1", "http://www.slna-fc.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_S%C3%B4ng_Lam_Ngh%E1%BB%87_An", R.drawable.slna_fc),
            new Team("Sanna Khanh Hoa FC", new LatLng(12.2501953,109.1906473), "A football club play in V-league 1", "http://www.khanhhoafc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Sanna_Kh%C3%A1nh_H%C3%B2a", R.drawable.sanna_khanh_hoa),
            new Team("Than Quang Ninh FC", new LatLng(21.0374099,107.1231561), "A football club play in V-league 1", "http://thanquangninhfc.vn/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Than_Qu%E1%BA%A3ng_Ninh", R.drawable.quang_ninh_fc),
            new Team("QNK Quang Nam FC", new LatLng(15.5599398,108.5045869), "A football club play in V-league 1", "", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_Qu%E1%BA%A3ng_Nam", R.drawable.qnk_quang_nam_fc),
            new Team("XSKT Can Tho FC", new LatLng(10.0488396,105.7858791), "A football club play in V-league 1", "http://www.bongdacantho.com/", "https://vi.wikipedia.org/wiki/C%C3%A2u_l%E1%BA%A1c_b%E1%BB%99_b%C3%B3ng_%C4%91%C3%A1_C%E1%BA%A7n_Th%C6%A1", R.drawable.xskt_can_tho),
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
            new Country("Turkey", new LatLng(38.963745, 35.243322)),
            new Country("Afghanistan", new LatLng(33.93911, 67.709953)),
            new Country("Albania", new LatLng(41.153332, 20.168331)),
            new Country("Algeria", new LatLng(28.033886, 1.659626)),
            new Country("American Samoa", new LatLng(-14.3060204, -170.6961815)),
            new Country("Andorra", new LatLng(42.506285, 1.521801)),
            new Country("Angola", new LatLng(-11.202692, 17.873887)),
            new Country("Anguilla", new LatLng(18.220554, -63.06861499999999)),
            new Country("Antigua and Barbuda", new LatLng(17.060816, -61.796428)),
            new Country("Argentina", new LatLng(-38.416097, -63.61667199999999)),
            new Country("Armenia", new LatLng(40.069099, 45.038189)),
            new Country("Aruba", new LatLng(12.52111, -69.968338)),
            new Country("Australia", new LatLng(-25.274398, 133.775136)),
            new Country("Austria", new LatLng(47.516231, 14.550072)),
            new Country("Azerbaijan", new LatLng(40.143105, 47.576927)),
            new Country("The Bahamas", new LatLng(25.03428, -77.39628)),
            new Country("United Arab Emirates", new LatLng(23.424076, 53.847818)),
            new Country("Bosnia and Herzegovina", new LatLng(43.915886, 17.679076)),
            new Country("Barbados", new LatLng(13.193887, -59.543198)),
            new Country("Bangladesh", new LatLng(23.684994, 90.356331)),
            new Country("Belgium", new LatLng(50.503887, 4.469936)),
            new Country("Burkina Faso", new LatLng(12.238333, -1.561593)),
            new Country("Bulgaria", new LatLng(42.733883, 25.48583)),
            new Country("Bahrain", new LatLng(25.930414, 50.637772)),
            new Country("Burundi", new LatLng(-3.373056, 29.918886)),
            new Country("Benin", new LatLng(9.30769, 2.315834)),
            new Country("Bermuda", new LatLng(32.321384, -64.75737)),
            new Country("Bolivia", new LatLng(-16.290154, -63.588653)),
            new Country("Brazil", new LatLng(-14.235004, -51.92528)),
            new Country("Bhutan", new LatLng(27.514162, 90.433601)),
            new Country("Bouvet Island", new LatLng(-54.423199, 3.413194)),
            new Country("Botswana", new LatLng(-22.328474, 24.684866)),
            new Country("Belarus", new LatLng(53.709807, 27.953389)),
            new Country("Belize", new LatLng(17.189877, -88.49765)),
            new Country("Canada", new LatLng(56.130366, -106.346771)),
            new Country("Cocos Islands", new LatLng(-12.164165, 96.870956)),
            new Country("Congo", new LatLng(-4.038333, 21.758664)),
            new Country("Central African Republic", new LatLng(6.611111, 20.939444)),
            new Country("Switzerland", new LatLng(46.818188, 8.227512)),
            new Country("Côte d'Ivoire", new LatLng(7.539989, -5.54708)),
            new Country("Cook Islands", new LatLng(-21.236736, -159.777671)),
            new Country("Chile", new LatLng(-35.675147, -71.542969)),
            new Country("Cameroon", new LatLng(7.369722, 12.354722)),
            new Country("Colombia", new LatLng(4.570868, -74.297333)),
            new Country("Costa Rica", new LatLng(9.748917, -83.753428)),
            new Country("Cuba", new LatLng(21.521757, -77.781167)),
            new Country("Cape Verde", new LatLng(16.002082, -24.013197)),
            new Country("Christmas Island", new LatLng(-10.447525, 105.690449)),
            new Country("Cyprus", new LatLng(33.429859, 35.126413)),
            new Country("Czech Republic", new LatLng(49.817492, 15.472962)),
            new Country("Germany", new LatLng(51.165691, 10.451526)),
            new Country("Djibouti", new LatLng(11.825138, 42.590275)),
            new Country("Denmark", new LatLng(56.26392, 9.501785)),
            new Country("Indonesia", new LatLng(-0.789275, 113.921327)),
            new Country("Philippines", new LatLng(12.879721, 121.774017)),
            new Country("Laos", new LatLng(19.85627, 102.495496)),
            new Country("North Korea", new LatLng(40.339852, 127.510093)),
            new Country("South Korea", new LatLng(35.907757, 127.766922)),
            new Country("Russia", new LatLng(61.52401, 105.318756)),
            new Country("Macau", new LatLng(22.198745, 113.543873)),
            new Country("Timor-Leste", new LatLng(-8.874217, 125.727539)),
            new Country("Hong Kong", new LatLng(22.396428, 114.109497)),
            new Country("India", new LatLng(20.593684, 78.96288)),
            new Country("Thailand", new LatLng(15.870032, 100.992541)),
            new Country("Qatar", new LatLng(25.354826, 51.183884)),
            new Country("Romania", new LatLng(45.943161, 24.96676)),
            new Country("Sweden", new LatLng(60.128161, 18.643501)),
    };
}
