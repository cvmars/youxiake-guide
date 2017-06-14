package com.youxiake_guide.api;

import com.youxiake_guide.model.HomeModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.subjects.Subject;

/**
 * Created by Cvmars on 2017/6/13.
 */

public interface ApiService {

    @GET("api/home")
    Observable<HttpResult<HomeModel>> getHomeInfo();

}
