package com.yzr.mydemos.utils;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.io.InputStream;

/**
 * Created by Yangzr on 2016/12/4.
 */

public class ResourcesUtil {

    public static int getColor(Context ctx,int colorId){
            return ContextCompat.getColor(ctx,colorId);
    }

    public static Object getRawString(Context ctx,int rawId){
        InputStream in = ctx.getResources().openRawResource(rawId);
        return StreamUtil.inputStream2String(in);
    }
}
