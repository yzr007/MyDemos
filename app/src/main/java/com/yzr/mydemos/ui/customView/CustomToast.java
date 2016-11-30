package com.yzr.mydemos.ui.customView;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yzr.mydemos.R;

/**
 * 吐司提示工具类 自定义Toast样式
 * author：Android-YZR
 * time：2016/4/22 18:38
 */
public class CustomToast {

    private static Toast toast = null;
    public static int LENGTH_LONG = Toast.LENGTH_LONG;
    private static int LENGTH_SHORT = Toast.LENGTH_SHORT;

    /**
     * 普通文本消息提示
     * @param context
     * @param text
     * @param duration
     */
    public static void TextToast(Context context, CharSequence text, int duration){
        LayoutInflater inflater =  (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast_txt_custom,null);
        TextView txtToast = (TextView) layout.findViewById(R.id.txt_toast);
        txtToast.setText(text);
        toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
    }

    /**
     * 带图片消息提示
     * @param context
     * @param ImageResourceId
     * @param text
     * @param duration
     */
    public static void ImageToast(Context context,int ImageResourceId,CharSequence text,int duration){
//        //创建一个Toast提示消息
//        toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
//        //设置Toast提示消息在屏幕上的位置
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        //获取Toast提示消息里原有的View
//        View toastView = toast.getView();
//        //创建一个ImageView
//        ImageView img = new ImageView(context);
//        img.setImageResource(ImageResourceId);
//        //创建一个LineLayout容器
//        LinearLayout ll = new LinearLayout(context);
//        //向LinearLayout中添加ImageView和Toast原有的View
//        ll.addView(img);
//        ll.addView(toastView);
//        //将LineLayout容器设置为toast的View
//        toast.setView(ll);
//        //显示消息
//        toast.show();
    }
}
