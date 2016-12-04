package com.yzr.mydemos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yzr.mydemos.R;
import com.yzr.mydemos.contract.Demo0Contract;
import com.yzr.mydemos.presenter.Demo0Presenter;
import com.yzr.mydemos.ui.BaseFragment;

/**
 * Created by Android-YZR on 2016/11/30.
 */

public class Demo0Fragment extends BaseFragment implements Demo0Contract.View{

    private Demo0Contract.Presenter mPresenter;
    public static Demo0Fragment newInstance() {
        Bundle arguments = new Bundle();
        //arguments.putString("key", param); //如果有参数在这里写入 横竖屏切换不丢数据
        Demo0Fragment fragment = new Demo0Fragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_demo0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindPresenter() {
        new Demo0Presenter(this);
    }

    @Override
    public void setPresenter(Demo0Contract.Presenter presenter) {
        mPresenter = presenter;
    }
}
