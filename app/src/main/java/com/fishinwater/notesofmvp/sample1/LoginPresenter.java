package com.fishinwater.notesofmvp.sample1;


import android.graphics.Bitmap;

import com.fishinwater.notesofmvpstudy.utils.HttpUtils;

/**
 * P 层
 * 特点
 * 特点一：持有 M 层的引用
 * 特点一：持有 V 层的引用
 * 对 M 层，V 层进行关联
 */
public class LoginPresenter {

    private LogInModel logInModel;

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.logInModel = new LogInModel();
        this.loginView  = loginView;
    }

    public void login(String counts, String pages) {
        this.logInModel.login(counts, pages, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String JSONString) {
                if (logInModel != null) {
                    loginView.onLoginResult(JSONString);
                }
            }

            @Override
            public void onBitmap(Bitmap bitmap) {
                if (logInModel != null) {
                    loginView.onLoginBitmap(bitmap);
                }
            }
        });
    }
}
