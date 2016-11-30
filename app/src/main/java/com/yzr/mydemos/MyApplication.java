package com.yzr.mydemos;

import android.app.Application;

/**
 * Created by Android-YZR on 2016/11/30.
 */

public class MyApplication extends Application{
    private static MyApplication mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MyApplication getInstance(){
        return mInstance;
    }
}
