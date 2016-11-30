package com.yzr.mydemos.presenter;

import com.yzr.mydemos.contract.Demo0Contract;

/**
 * Created by Android-YZR on 2016/11/29.
 */

public class Demo0Presenter implements Demo0Contract.Presenter{
    private final Demo0Contract.View mDemo0View;

    public Demo0Presenter(Demo0Contract.View view){
        this.mDemo0View = view;
        mDemo0View.setPresenter(this);
    }
}
