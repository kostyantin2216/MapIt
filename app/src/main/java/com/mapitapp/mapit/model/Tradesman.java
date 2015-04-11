package com.mapitapp.mapit.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Kostyantin on 3/21/2015.
 */

@ParseClassName("Tradesman")
public class Tradesman extends ParseObject {

    public final static String KEY_COMPANY_NAME = "company_name";
    public final static String KEY_FIRST_NAME = "first_name";
    public final static String KEY_LAST_NAME = "last_name";
    public final static String KEY_EMAIL = "email";
    public final static String KEY_TELEPHONE = "telephone";
    public final static String KEY_REVIEW_IDS = "review_ids";
    public final static String KEY_ADDRESS = "address";

    public String getCompanyName() {
        return getString(KEY_COMPANY_NAME);
    }

    public String getFirstName() {
        return getString(KEY_FIRST_NAME);
    }

    public String getLastName() {
        return getString(KEY_LAST_NAME);
    }

    public String getEmail() {
        return getString(KEY_EMAIL);
    }

    public String getKeyTelephone() {
        return getString(KEY_TELEPHONE);
    }

    public List<String> getKeyReviewIds() {
        return getList(KEY_REVIEW_IDS);
    }

    public String getAddress() {
        return getString(KEY_ADDRESS);
    }
}
