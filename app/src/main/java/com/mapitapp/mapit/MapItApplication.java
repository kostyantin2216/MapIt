package com.mapitapp.mapit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Kostyantin on 3/21/2015.
 */
public class MapItApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, getString(R.string.app_id), getString(R.string.client_key));
    }
}
