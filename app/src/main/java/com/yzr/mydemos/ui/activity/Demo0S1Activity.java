package com.yzr.mydemos.ui.activity;

import com.yzr.mydemos.R;
import com.yzr.mydemos.contract.Demo0Contract;
import com.yzr.mydemos.model.Alert;
import com.yzr.mydemos.ui.BaseActivity;

/**
 * Created by Android-YZR on 2016/12/2.
 */

public class Demo0S1Activity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo0s1;
    }

    @Override
    protected void initView() {
        setTheme(R.style.StatusAndNavigationTranslucentTheme);
    }

}
