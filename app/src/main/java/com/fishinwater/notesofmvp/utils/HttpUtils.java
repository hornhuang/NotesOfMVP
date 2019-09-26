package com.fishinwater.notesofmvp.utils;

import android.graphics.Bitmap;

public class HttpUtils {

    public interface OnHttpResultListener {

        void onResult(String result);

        void onBitmap(Bitmap bitmap);

    }

}
