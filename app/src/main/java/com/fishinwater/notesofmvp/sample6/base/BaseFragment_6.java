package com.fishinwater.notesofmvp.sample6.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fishinwater.notesofmvp.sample5.base.BasePresenter_5;
import com.fishinwater.notesofmvp.sample5.base.BaseView_5;

/**
 * 负责：抽象出，解绑和绑定操作
 * 注意：为了能够兼容多个 Activity，所以我们采用的是泛型设计
 */
public abstract class BaseFragment_6<V extends BaseView_5, P extends  BasePresenter_5<V>> extends Fragment {

    private P presenter;

    private V view;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (this.presenter == null) {
            this.presenter = createPresenter();
        }

        if (this.view == null) {
            this.view = createView();
        }

        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(view);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (this.presenter != null && this.view != null) {
            this.presenter.detachView(view);
        }
    }

    public abstract P createPresenter();

    public abstract V createView();

    public P getPresenter() {
        return presenter;
    }
}
