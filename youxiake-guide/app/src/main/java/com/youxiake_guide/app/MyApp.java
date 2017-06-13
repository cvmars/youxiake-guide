package com.youxiake_guide.app;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class MyApp extends Application {

    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //Hawk 是一个非常便捷的数据库  . 操作数据库只需一行代码 , 能存任何数据类型
        Hawk.init(this).build();
    }


    public static MyApp getApplication(){
        return instance;
    }
}
