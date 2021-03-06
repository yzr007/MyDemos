package com.yzr.mydemos.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yzr.mydemos.R;
import com.yzr.mydemos.contract.Demo0Contract;
import com.yzr.mydemos.presenter.Demo0Presenter;
import com.yzr.mydemos.ui.BaseFragment;
import com.yzr.mydemos.ui.activity.Demo0S1Activity;
import com.yzr.mydemos.ui.activity.Demo0S2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android-YZR on 2016/11/30.
 */

public class Demo0Fragment extends BaseFragment implements Demo0Contract.View {

    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.btn_s1)
    Button btnS1;
    @BindView(R.id.btn_s2)
    Button btnS2;
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
    protected void initView(View rootView) {
        ButterKnife.bind(this,rootView);
        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDemo0S1Activity();
            }
        });
        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDemo0S2Activity();
            }
        });
    }

    @Override
    protected void bindPresenter() {
        new Demo0Presenter(this);
    }

    @Override
    public void setPresenter(Demo0Contract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void toDemo0S1Activity() {
        startActivity(new Intent(getActivity(), Demo0S1Activity.class));
    }
    @Override
    public void toDemo0S2Activity() {
        startActivity(new Intent(getActivity(), Demo0S2Activity.class));
    }
}
