package com.yzr.mydemos.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ScreenUtils
{
	private ScreenUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 获取根布局
	 * @param context Activity的上下文
	 * @return Activity的根布局
	 */
	public static ViewGroup getRootView(Context context) {
		return ((ViewGroup) ((Activity)context).getWindow().getDecorView());
	}
	/**
	 * 获得屏幕高度
	 * 
	 * @param context
	 * @return px
	 */
	public static int getScreenWidth(Context context)
	{
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        return w_screen;
	}

	/**
	 * 获得屏幕宽度
	 * 
	 * @param context
	 * @return px
	 */
	public static int getScreenHeight(Context context)
	{
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        int h_screen = dm.heightPixels;
        return h_screen;
	}

	/**
	 * 获得状态栏的高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context)
	{

		int statusHeight = -1;
		try
		{
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height")
					.get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return statusHeight;
	}

	/**
	 * 获取当前屏幕截图，包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * 获取当前屏幕截图，不包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
				- statusBarHeight);
		view.destroyDrawingCache();
		return bp;

	}

    /**
     * 获取View截图
     *
     * @return
     */
    public static Bitmap snapView(View view)
    {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));

        return bitmap;

    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

}
