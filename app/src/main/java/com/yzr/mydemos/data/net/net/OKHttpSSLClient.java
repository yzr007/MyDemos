package com.yzr.mydemos.data.net.net;

import android.util.Log;

import com.yzr.mydemos.MyApplication;
import com.yzr.mydemos.utils.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Android-YZR on 2016/12/7.
 */

public class OKHttpSSLClient {
    private static OkHttpClient.Builder okHttpClientBuilder = null;

    public static OkHttpClient getInstance() {
        if (okHttpClientBuilder == null) {
            synchronized (OKHttpSSLClient.class) {
                if (okHttpClientBuilder == null) {
                    initOKHttpSSLClient();
                }
            }
        }
        return okHttpClientBuilder.build();
    }

    public static void initOKHttpSSLClient() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            okHttpClientBuilder = new OkHttpClient.Builder();
            okHttpClientBuilder.addInterceptor(getLogInterceptor());
            okHttpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            throw new AssertionError(); // The system has no TLS. Just give up.
        }
    }

    /**
     *
     * @return HttpLoggingInterceptor http日志拦截器
     */
    private static HttpLoggingInterceptor getLogInterceptor() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("HttpLog", message);
            }
        });
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logInterceptor;
    }

    public static Interceptor provideOfflineCacheInterceptor ()
    {
        return new Interceptor()
        {
            @Override
            public Response intercept (Chain chain) throws IOException
            {
                Request request = chain.request();

                /**
                 * 未联网获取缓存数据
                 */
                if (!NetworkUtils.isConnected(MyApplication.getInstance()) )
                {
                    //在20秒缓存有效，此处测试用，实际根据需求设置具体缓存有效时间
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxStale(20, TimeUnit.SECONDS )
                            .build();

                    request = request.newBuilder()
                            .cacheControl( cacheControl )
                            .build();
                }

                return chain.proceed( request );
            }
        };
    }

    //设置缓存目录和缓存空间大小
    private static Cache provideCache ()
    {
        Cache cache = null;
        try
        {
            cache = new Cache( new File( MyApplication.getInstance().getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
        }
        catch (Exception e)
        {
            Log.e("cache","Could not create Cache!");
        }
        return cache;
    }
}