package com.fishinwater.notesofmvp.sample5;


import android.graphics.Bitmap;

import com.fishinwater.notesofmvp.sample5.base.BasePresenter_5;
import com.fishinwater.notesofmvp.utils.HttpUtils;

/**
 * P 层
 * 特点
 * 特点一：持有 M 层的引用
 * 特点一：持有 V 层的引用
 * 对 M 层，V 层进行关联
 *
 * @author fishinwater-1999
 */
public class LoginPresenter_5 extends BasePresenter_5<LoginView_5> {

    private LogInModel_5 logInModel;

    public LoginPresenter_5() {
        this.logInModel = new LogInModel_5();
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
