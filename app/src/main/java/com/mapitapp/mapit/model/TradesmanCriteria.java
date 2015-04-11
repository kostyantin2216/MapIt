package com.mapitapp.mapit.model;

/**
 * Created by Kostyantin on 3/21/2015.
 */
public class TradesmanCriteria {

    private boolean showAllTradesman;
    private String profession;
    private String city;
    private String suburb;

    public TradesmanCriteria(boolean showAllTradesman) {
        setShowAllTradesman(showAllTradesman);
    }

    public TradesmanCriteria(String profession, String city, String suburb) {
        setProfession(profession);
        setCity(city);
        setSuburb(suburb);
        setShowAllTradesman(false);
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isShowAllTradesman() {
        return showAllTradesman;
    }

    public void setShowAllTradesman(boolean showAllTradesman) {
        this.showAllTradesman = showAllTradesman;
    }
}
