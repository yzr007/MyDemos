package com.yzr.mydemos.presenter;

import android.support.v4.app.Fragment;

import com.alibaba.fastjson.JSONArray;
import com.yzr.mydemos.R;
import com.yzr.mydemos.contract.MainContract;
import com.yzr.mydemos.model.HomeMenu;
import com.yzr.mydemos.ui.fragment.Demo0Fragment;
import com.yzr.mydemos.utils.ResourcesUtil;

import java.util.List;

/**
 * Created by Android-YZR on 2016/12/2.
 */

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View mView;
    public MainPresenter(MainContract.View view){
        mView = view;
        mView.setPresenter(this);
    }
    @Override
    public void initMenu(List<HomeMenu> homeMenuList) {
        String jsonString = ResourcesUtil.getRawString(mView.getContext(), R.raw.homemenu).toString();
        homeMenuList.clear();
        homeMenuList.addAll(JSONArray.parseArray(jsonString,HomeMenu.class));
        mView.updateMenu();
    }

    @Override
    public void menuSelect(int item,Fragment fragment) {
        switch (item){
            case 0:
                if (fragment == null || !(fragment instanceof Demo0Fragment)) {
                    fragment = Demo0Fragment.newInstance();
                }
                mView.switchFragment(fragment);
                break;
        }
    }
}
