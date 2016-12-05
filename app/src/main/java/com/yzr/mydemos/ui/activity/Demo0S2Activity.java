package com.yzr.mydemos.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.yzr.mydemos.R;
import com.yzr.mydemos.contract.Demo0S2Contract;
import com.yzr.mydemos.ui.BaseActivity;
import com.yzr.mydemos.utils.ResourcesUtil;
import com.yzr.mydemos.utils.ScreenUtils;

/**
 * Created by Android-YZR on 2016/12/2.
 */

public class Demo0S2Activity extends BaseActivity implements Demo0S2Contract.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo0s2;
    }

    @Override
    protected void initView() {
        initStatusAndNavigationBar();
    }

    @Override
    protected void bindPresenter() {

    }


    @Override
    public void setPresenter(Demo0S2Contract.Presenter presenter) {

    }

    /**
     * 5.0及以上版本适配，也可以只使用addView()的方式，只不过不优雅
     */
    @Override
    public void initStatusAndNavigationBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.rgb(0, 255, 255));
            getWindow().setNavigationBarColor(Color.rgb(0, 255, 255));
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//不考虑NavigationBar,没有办法判断是否有NavigationBar
            View statusBarView = new View(this);
            int statusBarHeight = ScreenUtils.getStatusHeight(this);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
            params.gravity = Gravity.TOP;
            statusBarView.setLayoutParams(params);
            statusBarView.setBackgroundColor(Color.rgb(0, 255, 255));
            ScreenUtils.getRootView(this).addView(statusBarView);
        }
    }


}
