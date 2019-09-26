package com.fishinwater.notesofmvp.sample5.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * 负责：抽象出，解绑和绑定操作
 * 注意：为了能够兼容多个 Activity，所以我们采用的是泛型设计
 */
public abstract class BaseActivity<V extends BaseView_5, P extends  BasePresenter_5<V>> extends Activity{

    private P presenter;

    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    protected void onDestroy() {
        super.onDestroy();
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
