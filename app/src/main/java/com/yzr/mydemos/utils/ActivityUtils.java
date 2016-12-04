package com.yzr.mydemos.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Yangzr on 2016/12/4.
 */

public class ActivityUtils {
    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, int frameId){
        if(fragmentManager != null && fragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
    }

    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int frameId){
        if(fragmentManager != null && fragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(frameId, fragment);
            transaction.commit();
        }
    }
}
