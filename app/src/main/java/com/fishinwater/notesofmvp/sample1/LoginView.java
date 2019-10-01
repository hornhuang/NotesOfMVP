package com.fishinwater.notesofmvp.sample1;

import android.graphics.Bitmap;

/**
 * UI 层回调接口
 *
 * @author fishinwater-1999
 */
public interface LoginView {

    /**
     * 回调方法
     * 用于获得请求结果
     *
     * @param result
     */
    void onLoginResult(String result);

    /**
     * 回调方法
     *
     * 用于向前一个 listener 发送 Bitmap
     * @param result
     */
    void onLoginBitmap(Bitmap result);

}
