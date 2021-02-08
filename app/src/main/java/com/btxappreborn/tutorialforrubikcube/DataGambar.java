package com.btxappreborn.tutorialforrubikcube;

import java.util.ArrayList;

public class DataGambar {
    private static int[] listgambarf2l = {
            R.drawable.i_1,R.drawable.i_2,R.drawable.i_3,R.drawable.i_4,R.drawable.i_5,R.drawable.i_6,R.drawable.i_7,R.drawable.i_8,R.drawable.i_9,R.drawable.i_10,
            R.drawable.i_11,R.drawable.i_12,R.drawable.i_13,R.drawable.i_14,R.drawable.i_15,R.drawable.i_16,R.drawable.i_17,R.drawable.i_18,R.drawable.i_19,R.drawable.i_20,
            R.drawable.i_21,R.drawable.i_22,R.drawable.i_23,R.drawable.i_24,R.drawable.i_25,R.drawable.i_26,R.drawable.i_27,R.drawable.i_28,R.drawable.i_29,R.drawable.i_30,
            R.drawable.i_31,R.drawable.i_32,R.drawable.i_33,R.drawable.i_34,R.drawable.i_35,R.drawable.i_36,R.drawable.i_37,R.drawable.i_38,R.drawable.i_39,R.drawable.i_40,
            R.drawable.i_41
    };
    static ArrayList<RWData> DaftarDataF2L() {
        ArrayList<RWData> listDataF2L = new ArrayList<>();
        for (int position = 0; position < listgambarf2l.length; position++) {
            RWData rWF2L = new RWData();
            rWF2L.setGambar(listgambarf2l[position]);
            listDataF2L.add(rWF2L);
        }
        return listDataF2L;
    }
    private static int[] listgambarOll = {
            R.drawable.j_1,R.drawable.j_2,R.drawable.j_3,R.drawable.j_4,R.drawable.j_5,R.drawable.j_6,R.drawable.j_7,R.drawable.j_8,R.drawable.j_9,R.drawable.j_10,
            R.drawable.j_11,R.drawable.j_12,R.drawable.j_13,R.drawable.j_14,R.drawable.j_15,R.drawable.j_16,R.drawable.j_17,R.drawable.j_18,R.drawable.j_19,R.drawable.j_20,
            R.drawable.j_21,R.drawable.j_22,R.drawable.j_23,R.drawable.j_24,R.drawable.j_25,R.drawable.j_26,R.drawable.j_27,R.drawable.j_28,R.drawable.j_29,R.drawable.j_30,
            R.drawable.j_31,R.drawable.j_32,R.drawable.j_33,R.drawable.j_34,R.drawable.j_35,R.drawable.j_36,R.drawable.j_37,R.drawable.j_38,R.drawable.j_39,R.drawable.j_40,
            R.drawable.j_41,R.drawable.j_42,R.drawable.j_43,R.drawable.j_44,R.drawable.j_45,R.drawable.j_46,R.drawable.j_47,R.drawable.j_48,R.drawable.j_49,R.drawable.j_50,
            R.drawable.j_51,R.drawable.j_52,R.drawable.j_53,R.drawable.j_54,R.drawable.j_55,R.drawable.j_56,R.drawable.j_57
    };
    static ArrayList<RWData> DaftarDataOll() {
        ArrayList<RWData> listDataOll = new ArrayList<>();
        for (int position = 0; position < listgambarOll.length; position++) {
            RWData rWF2L = new RWData();
            rWF2L.setGambar(listgambarOll[position]);
            listDataOll.add(rWF2L);
        }
        return listDataOll;
    }


    private static int[] listgambarPll = {
            R.drawable.k_1,R.drawable.k_2,R.drawable.k_3,R.drawable.k_4,R.drawable.k_5,R.drawable.k_6,R.drawable.k_7,R.drawable.k_8,R.drawable.k_9,R.drawable.k_10,
            R.drawable.k_11,R.drawable.k_12,R.drawable.k_13,R.drawable.k_14,R.drawable.k_15,R.drawable.k_16,R.drawable.k_17,R.drawable.k_18,R.drawable.k_19,R.drawable.k_20,
            R.drawable.k_21
    };


    static ArrayList<RWData> DaftarDataPll() {
        ArrayList<RWData> listDataPll = new ArrayList<>();
        for (int position = 0; position < listgambarPll.length; position++) {
            RWData rWF2L = new RWData();
            rWF2L.setGambar(listgambarPll[position]);
            listDataPll.add(rWF2L);
        }
        return listDataPll;
    }
}
