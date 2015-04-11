package com.mapitapp.mapit.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Kostyantin on 3/21/2015.
 */
@ParseClassName("Address")
public class Address extends ParseObject {

    public final static String KEY_COUNTRY = "country";
    public final static String KEY_CITY = "city";
    public final static String KEY_STREET = "street";
    public final static String KEY_BUILDING_NUM = "building_num";
    public final static String KEY_FLAT_NUM = "flat_num";

    public String getCountry() {
        return getString(KEY_COUNTRY);
    }

    public String getCity() {
        return getString(KEY_CITY);
    }

    public String getStreet() {
        return getString(KEY_STREET);
    }

    public int getBuildingNum() {
        return getInt(KEY_BUILDING_NUM);
    }

    public int getFlatNum() {
        return getInt(KEY_FLAT_NUM);
    }
}
