package com.fishinwater.notesofmvp.sample3;


import android.graphics.Bitmap;

import com.fishinwater.notesofmvpstudy.sample3.base.BasePresenter;
import com.fishinwater.notesofmvpstudy.utils.HttpUtils;

/**
 * P 层
 * 特点
 * 特点一：持有 M 层的引用
 * 特点一：持有 V 层的引用
 * 对 M 层，V 层进行关联
 */
public class LoginPresenter_3 extends BasePresenter {

    private LogInModel_3 logInModel;

    public LoginPresenter_3() {
        this.logInModel = new LogInModel_3();
    }

    public void login(String counts, String pages) {
        this.logInModel.login(counts, pages, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String JSONString) {
                if (logInModel != null) {
                    getLoginView().onLoginResult(JSONString);
                }
            }

            @Override
            public void onBitmap(Bitmap bitmap) {
                if (logInModel != null) {
                    getLoginView().onLoginBitmap(bitmap);
                }
            }
        });
    }
}
