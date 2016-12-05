package com.yzr.mydemos.contract;

import com.yzr.mydemos.presenter.base.BasePresenter;
import com.yzr.mydemos.ui.BaseView;

/**
 * 契约类
 * Created by Android-YZR on 2016/11/29.
 */

public interface Demo0Contract {
    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {
        void toDemo0S1Activity();
        void toDemo0S2Activity();
    }
}
