package com.youxiake.guide.api;

import com.youxiake.guide.model.HomeModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Cvmars on 2017/6/13.
 */

public interface ApiService {

    @GET("api/home")
    Observable<HttpResult<HomeModel>> getHomeInfo();

}
