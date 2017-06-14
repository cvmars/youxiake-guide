package com.youxiake.guide.api;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Cvmars on 2017/6/14.
 */

public class HttpUtil {


    private HttpUtil(){}

    /**
     * 在访问HttpMethods时创建单例
     */
    private static class SingletonHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }

    /**
     * 获取单例
     */
    public static HttpUtil getInstance() {
        return HttpUtil.SingletonHolder.INSTANCE;
    }


//    public void toSubscribe(Observable ob, final Subscriber subscriber,String cacheKey,boolean isSave, boolean forceRefresh){
//
//        ob.subscribeOn(Schedulers.io())               //在IO线程进行网络请求
//                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
//                .subscribe(subscriber);
//
//        RetrofitCache.load(cacheKey,ob,isSave,forceRefresh).subscribe(subscriber);
//    }

    public void toSubscribe(Observable ob, final Subscriber subscriber){

        ob.subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(subscriber);
    }
}
