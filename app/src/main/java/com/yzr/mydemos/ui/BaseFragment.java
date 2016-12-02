package com.yzr.mydemos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Android-YZR on 2016/11/30.
 */

public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(),container, false);
        setHasOptionsMenu(true);
        return root;
    }

    protected abstract int getLayoutId() ;
    protected abstract void initView() ;
}
