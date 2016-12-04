package com.yzr.mydemos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Android-YZR on 2016/11/30.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindPresenter();//必须在initView前，可能会在initView中调用
        setContentView(getLayoutId());
        initView();
    }

    protected abstract int getLayoutId() ;
    protected abstract void initView() ;
    protected abstract void bindPresenter() ;
}
