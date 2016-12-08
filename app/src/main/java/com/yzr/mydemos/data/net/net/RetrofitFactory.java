package com.yzr.mydemos.data.net.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by Android-YZR on 2016/12/7.
 */

public class RetrofitFactory {
    private static final String Host = "";
    private static final String TestHost = "https://api.douban.com/v2/movie/";//结尾必须带“/”

    private static Retrofit HostRetrofit = null;
    private static Retrofit TestRetrofit = null;

    public static Retrofit getHostRetrofit(){
        if(HostRetrofit == null){
            synchronized (RetrofitFactory.class){
                if(HostRetrofit == null){
                    HostRetrofit = creatRetrofit(Host);
                }
            }
        }
        return HostRetrofit;
    }

    public static Retrofit getTestRetrofit(){
        if(TestRetrofit == null){
            synchronized (RetrofitFactory.class){
                if(TestRetrofit == null){
                    TestRetrofit = creatRetrofit(TestHost);
                }
            }
        }
        return TestRetrofit;
    }

    private static Retrofit creatRetrofit(String baseUrl){
        return new Retrofit.Builder()
                .client(OKHttpSSLClient.getInstance())
                .baseUrl(baseUrl)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
