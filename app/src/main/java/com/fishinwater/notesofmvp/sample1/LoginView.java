package com.fishinwater.notesofmvp.sample1;

import android.graphics.Bitmap;

// UI 层回调接口
public interface LoginView {

    void onLoginResult(String result);

    void onLoginBitmap(Bitmap result);

}
