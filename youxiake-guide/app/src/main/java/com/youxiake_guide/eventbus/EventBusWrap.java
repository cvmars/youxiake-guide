package com.youxiake_guide.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class EventBusWrap {

    public static void register(Object subscriber){
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber){
        EventBus.getDefault().unregister(subscriber);
    }

    public static void post(Object event){
        EventBus.getDefault().post(event);
    }
}
