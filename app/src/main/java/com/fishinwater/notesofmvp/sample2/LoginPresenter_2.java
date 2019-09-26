package com.fishinwater.notesofmvp.sample2;


import android.graphics.Bitmap;

import com.fishinwater.notesofmvp.utils.HttpUtils;

/**
 * P 层
 * 特点
 * 特点一：持有 M 层的引用
 * 特点一：持有 V 层的引用
 * 对 M 层，V 层进行关联
 */
public class LoginPresenter_2 {

    private LogInModel_2 logInModel;

    private LoginView_2 loginView;

    public LoginPresenter_2() {
        this.logInModel = new LogInModel_2();
    }

    /**
     * 绑定
     * @param loginView
     */
    public void attachView(LoginView_2 loginView) {
        this.loginView = loginView;
    }

    /**
     * 解绑
     * @param loginView
     */
    public void detachView(LoginView_2 loginView) {
        this.loginView = null;
        // 终止请求
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
