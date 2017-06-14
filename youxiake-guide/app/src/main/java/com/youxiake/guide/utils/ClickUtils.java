package com.youxiake.guide.utils;

/**
 * 防止点击多次
 * Created by Cvmars on 2016/12/30.
 */

public class ClickUtils {
    public static final int DELAY = 600;
    private static long lastClickTime = 0;
    public static boolean isNotFastClick(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > DELAY) {
            lastClickTime = currentTime;
            return true;
        }else{return false;}
    }
}
