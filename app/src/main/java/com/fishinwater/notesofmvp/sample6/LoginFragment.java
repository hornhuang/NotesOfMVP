package com.fishinwater.notesofmvp.sample6;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fishinwater.notesofmvp.R;
import com.fishinwater.notesofmvp.sample5.LoginPresenter_5;
import com.fishinwater.notesofmvp.sample5.LoginView_5;
import com.fishinwater.notesofmvp.sample6.base.BaseFragment_6;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 第七步：MVP 设计 - 代码优化 - 第6步
 *
 * 扩张功能：fragment/LinearLayout
 */
public class LoginFragment extends BaseFragment_6<LoginView_5, LoginPresenter_5> implements LoginView_5 {

    private ImageView mGirlPic;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public LoginPresenter_5 createPresenter() {
        return new LoginPresenter_5();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGirlPic = view.findViewById(R.id.girl_pic);

        view.findViewById(R.id.get_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().login("1", "1");
            }
        });
    }

    @Override
    public void onLoginResult(String result) {

    }

    @Override
    public void onLoginBitmap(Bitmap result) {
        Observable.just(result)
                // 指定 subscribe() 发生在 IO 线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        mGirlPic.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public LoginView_5 createView() {
        return this;
    }
}
