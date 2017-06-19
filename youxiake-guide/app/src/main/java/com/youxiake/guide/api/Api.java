package com.youxiake.guide.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.youxiake.guide.utils.MyLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/6/13 0013.
 * http://www.cnblogs.com/liushilin/p/6164901.html
 */

public class Api {

    private static ApiService SERVICE;
    /**
     * 请求超时时间
     */
    private static final int DEFAULT_TIMEOUT = 10000;


    public static ApiService getDefault() {
        if (SERVICE == null) {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            /**
             *  拦截器
             */
            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    HttpUrl.Builder authorizedUrlBuilder = request.url()
                            .newBuilder()
                            //添加统一参数 如手机唯一标识符,token等
                            .addQueryParameter("key1","value1")
                            .addQueryParameter("key2", "value2");

                    // re-write response header to force use of cache
                    // 正常访问同一请求接口（多次访问同一接口），给30秒缓存，超过时间重新发送请求，否则取缓存数据
//                    CacheControl cacheControl = new CacheControl.Builder()
//                            .maxAge(3, TimeUnit.SECONDS )
//                            .build();

                    Request newRequest = request.newBuilder()
                            //对所有请求添加请求头
                            .header("Accept", "application/vnd.yxk.v2+json")
                            .method(request.method(), request.body())
//                            .header("Cache-Control", cacheControl.toString() )
                            .url(authorizedUrlBuilder.build())
                            .build();


                    MyLog.d( "Request   url  : " + newRequest.method()  +" : " + newRequest.url() +"\n"
                            +"          body : " + newRequest.body()+"\n"
                            +"        headers: " + newRequest.headers());
//                    okhttp3.Response originalResponse = chain.proceed(request);
//                    return originalResponse.newBuilder().header("mobileFlag", "adfsaeefe").addHeader("type", "4").build();
                    return  chain.proceed(newRequest);
                }
            });


            SERVICE = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Consts.APP_HOST)
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }
}
