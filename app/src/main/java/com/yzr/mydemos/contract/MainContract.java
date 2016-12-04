package com.yzr.mydemos.contract;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yzr.mydemos.model.HomeMenu;
import com.yzr.mydemos.presenter.base.BasePresenter;
import com.yzr.mydemos.ui.BaseView;

import java.util.List;

/**
 * 契约类
 * Created by Android-YZR on 2016/11/29.
 */

public interface MainContract {
    interface Presenter extends BasePresenter {
        void initMenu(List<HomeMenu> homeMenuList);
        void menuSelect(int item,Fragment fragment);
    }

    interface View extends BaseView<Presenter> {
        Context getContext();
        void updateMenu();
        void switchFragment(Fragment fragment);
    }
}
