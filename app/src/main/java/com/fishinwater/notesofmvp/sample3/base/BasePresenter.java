package com.fishinwater.notesofmvp.sample3.base;

import com.fishinwater.notesofmvp.sample3.LoginView_3;

/**
 * 存在巨大问题
 * 该父类（抽象类），类型写死了
 */
public abstract class BasePresenter {

    // 写死了
    // 只能为 'LoginView_3' 类型
    private LoginView_3 loginView;

    /**
     * 绑定
     * @param loginView
     */
    public void attachView(LoginView_3 loginView) {
        this.loginView = loginView;
    }

    /**
     * 解绑
     * @param loginView
     */
    public void detachView(LoginView_3 loginView) {
        this.loginView = null;
        // 终止请求
    }

    public LoginView_3 getLoginView() {
        return loginView;
    }

}
