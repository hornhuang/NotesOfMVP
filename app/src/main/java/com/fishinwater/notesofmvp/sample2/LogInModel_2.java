package com.fishinwater.notesofmvp.sample2;

import android.graphics.Bitmap;

import com.fishinwater.notesofmvpstudy.utils.HttpTask;
import com.fishinwater.notesofmvpstudy.utils.HttpUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

public class LogInModel_2 {

    public static final String URL_GIRL = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9";

    public void login(String counts, String pages, final HttpUtils.OnHttpResultListener onHttpResultListener){
        HttpTask httpTask = new HttpTask(new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                // JSON 数据格式解析、数据库操作、文件操作
                JSONArray jsonArray   = null;
                JSONObject jsonObject = null;
                String url            = null;
                try {
                    JSONObject myJsonObject = new JSONObject(result);
                    jsonArray = myJsonObject.getJSONArray("results");
                    jsonObject = jsonArray.getJSONObject(0);
                    url = jsonObject.getString("url");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                OkHttpUtils
                        .get()//
                        .url(url)//
                        .build()//
                        .execute(new BitmapCallback()
                        {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(Bitmap response, int id) {
                                onHttpResultListener.onBitmap(response);
                            }
                        });

            }

            @Override
            public void onBitmap(Bitmap bitmap) {

            }
        });
        // 妹子图：http://gank.io/api/data/福利/10/1
        httpTask.execute(URL_GIRL, counts, pages);
    }
}
