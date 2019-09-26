package com.fishinwater.notesofmvp.sample4;


import android.graphics.Bitmap;

import com.fishinwater.notesofmvpstudy.sample4.base.BasePresenter_4;
import com.fishinwater.notesofmvpstudy.utils.HttpUtils;

/**
 * P 层
 * 特点
 * 特点一：持有 M 层的引用
 * 特点一：持有 V 层的引用
 * 对 M 层，V 层进行关联
 */
public class LoginPresenter_4 extends BasePresenter_4<LoginView_4> {

    private LogInModel_4 logInModel;

    public LoginPresenter_4() {
        this.logInModel = new LogInModel_4();
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
