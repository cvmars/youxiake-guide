package com.youxiake.guide.api;


import com.youxiake.guide.model.HomeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Cvmars on 2017/6/13.
 */

public interface ApiService {

    @GET("api/home")
    Observable<HttpResult<HomeModel>> getHomeInfo();

}
