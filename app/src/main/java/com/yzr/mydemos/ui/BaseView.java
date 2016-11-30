package com.yzr.mydemos.ui;

/**
 * MVP架构中的View的接口
 * Created by Android-YZR on 2016/11/29.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
