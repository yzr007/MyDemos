package com.yzr.mydemos.data.net.net.apiservice;

import com.gtedai.gtedai.model.Test;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Android-YZR on 2016/12/8.
 */

public interface TestService {
    @GET("top250")
    Observable<Test> getTopMovie(@Query("start") int start, @Query("count") int count);
}
