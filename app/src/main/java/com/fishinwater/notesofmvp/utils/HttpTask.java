package com.fishinwater.notesofmvp.utils;

import android.os.AsyncTask;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class HttpTask extends AsyncTask<String, String , String> {

    // OnHttpResultListener
    private HttpUtils.OnHttpResultListener listener;

    private final String TAG = "MainActivity";

    // 方法回调
    public HttpTask(HttpUtils.OnHttpResultListener listener) {
        this.listener = listener;
    }

    /**
     * 异步GET请求:
     * new OkHttpClient;
     * 构造Request对象；
     * 通过前两步中的对象构建Call对象；
     * 通过Call#enqueue(Callback)方法来提交异步请求；
     */
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0] + "/" + strings[1] + "/" + strings[2];
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        return ;
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        listener.onResult(response);
                    }
                });
        return null;
    }


}
