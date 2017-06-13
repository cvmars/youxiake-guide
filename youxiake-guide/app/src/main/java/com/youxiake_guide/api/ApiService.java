package com.youxiake_guide.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.subjects.Subject;

/**
 * Created by Cvmars on 2017/6/13.
 */

public abstract interface ApiService {

    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<Subject>> getUser(@Query("touken") String touken);

}
