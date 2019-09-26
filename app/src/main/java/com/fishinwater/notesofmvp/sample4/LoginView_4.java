package com.fishinwater.notesofmvp.sample4;

import android.graphics.Bitmap;

import com.fishinwater.notesofmvpstudy.sample4.base.BaseView_4;

public interface LoginView_4 extends BaseView_4{

    void onLoginResult(String result);

    void onLoginBitmap(Bitmap result);

}
