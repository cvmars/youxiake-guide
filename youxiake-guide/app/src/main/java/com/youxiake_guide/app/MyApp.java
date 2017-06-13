package com.youxiake_guide.app;

import android.app.Application;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class MyApp extends Application {

    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static MyApp getApplication(){
        return instance;
    }
}
