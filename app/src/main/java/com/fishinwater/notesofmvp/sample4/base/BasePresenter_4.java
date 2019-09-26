package com.fishinwater.notesofmvp.sample4.base;

/**
 * 存在巨大问题
 * 该父类（抽象类），类型写死了
 */
public abstract class BasePresenter_4<V extends BaseView_4> {

    // 写死了
    // 只能为 'LoginView_3' 类型
    private V View;

    /**
     * 绑定
     * @param loginView
     */
    public void attachView(V loginView) {
        this.View = loginView;
    }

    /**
     * 解绑
     * @param loginView
     */
    public void detachView(V loginView) {
        this.View = null;
        // 终止请求
    }

    public V getLoginView() {
        return View;
    }

}
