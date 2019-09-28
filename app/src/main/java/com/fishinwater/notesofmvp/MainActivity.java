package com.fishinwater.notesofmvp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.fishinwater.notesofmvp.sample1.LoginPresenter;
import com.fishinwater.notesofmvp.sample1.LoginView;
import com.fishinwater.notesofmvp.sample2.LoginPresenter_2;
import com.fishinwater.notesofmvp.sample2.LoginView_2;
import com.fishinwater.notesofmvp.sample3.LoginPresenter_3;
import com.fishinwater.notesofmvp.sample3.LoginView_3;
import com.fishinwater.notesofmvp.sample4.LoginPresenter_4;
import com.fishinwater.notesofmvp.sample4.LoginView_4;
import com.fishinwater.notesofmvp.sample5.LoginPresenter_5;
import com.fishinwater.notesofmvp.sample5.LoginView_5;
import com.fishinwater.notesofmvp.sample5.base.BaseActivity;
import com.fishinwater.notesofmvp.utils.HttpTask;
import com.fishinwater.notesofmvp.utils.HttpUtils;

import org.json.JSONObject;

import java.util.function.Consumer;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * V 层 就是我们的 activity
 */
public class MainActivity extends BaseActivity<LoginView_5, LoginPresenter_5> implements LoginView_5 {

    private final String TAG = "MainActivity";

    @BindView(R.id.girl_pic)
    ImageView mGirlPic;

    private LoginPresenter_4 loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 第一步：原始案例
     * 普通写法
     */
//    public void clickLogin(View v) {
//        HttpTask httpTask = new HttpTask(new HttpUtils.OnHttpResultListener() {
//            @Override
//            public void onResult(String result) {
//                Log.d(TAG, "result-->" + result);
//            }
//        });
//        // 妹子图：http://gank.io/api/data/福利/10/1
//        httpTask.execute("http://gank.io/api/data/福利", "1", "1");
//    }

    /**
     * 第二步：MVP 设计-代码优化-第1步
     * 例如：外包项目（2个月完成 -> 两个开发 ） -> 1个月完成 -> 投入4个开发
     * 进行模块搭建
     * M 层：LoginModel -> 专门负责数据操作、网络操作、文件操作等等
     * V 层：LoginView_2  -> 进行 UI 交互回调
     * P 层：LoginPresenter -> 专门负责交互（中介） -> 将 UI 层和数据层进行关联
     */
//    public void clickLogin(View v) {
//        LoginPresenter loginPresenter = new LoginPresenter(this);
//        loginPresenter.login("1", "1");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        // Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT);
//    }
//
//    @Override
//    public void onLoginBitmap(Bitmap result) {
//        Observable.just(result)
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bitmap>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bitmap bitmap) {
//                        mGirlPic.setImageBitmap(bitmap);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    /**
     * 第三步：MVP 设计-代码优化-第2步
     * 发现问题：当我们网络请求正在进行，
     * 这时候我们推出了 Activity ，然而 UI 层引用还在，还会回调，其实没有必要了，我们可以直接解绑
     * 解决方案：方法 -> 绑定和解绑
     */
//    public void clickLogin(View v) {
//        loginPresenter = new LoginPresenter_2();
//        loginPresenter.attachView(this);
//        loginPresenter.login("1", "1");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        // do sth...
//    }
//
//    @Override
//    public void onLoginBitmap(Bitmap result) {
//        Observable.just(result)
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bitmap>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bitmap bitmap) {
//                        mGirlPic.setImageBitmap(bitmap);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//
//    /**
//     * 销毁时解绑
//     */
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (this.loginPresenter != null){
//            loginPresenter.detachView(this);
//        }
//    }

    /**
     * 第四步：MVP 设计 - 代码优化 - 第三步
     * 发现问题：一个类（一个接口还好），如果多个类，就要去反复的定义绑定和解绑的方法？
     * 解决方案：见我们的绑定和解绑进行抽象：定义我们的 BasePresenter
     */
//    public void clickLogin(View v) {
//        loginPresenter = new LoginPresenter_3();
//        loginPresenter.attachView(this);
//        loginPresenter.login("1", "1");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        // do sth...
//    }
//
//    @Override
//    public void onLoginBitmap(Bitmap result) {
//        Observable.just(result)
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bitmap>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bitmap bitmap) {
//                        mGirlPic.setImageBitmap(bitmap);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//
//    /**
//     * 销毁时解绑
//     */
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (this.loginPresenter != null){
//            loginPresenter.detachView(this);
//        }
//    }

    /**
     * 第五步
     * MVP 设计 - 代码优化 - 第四步
     * 发现问题，类型写死了
     *
     * 解决方案一：泛型设计
     *
     * 解决方案二：强制类型转换（每一次都要进行类型转换，很麻烦）
     */
//    public void clickLogin(View v) {
//        loginPresenter = new LoginPresenter_4();
//        loginPresenter.attachView(this);
//        loginPresenter.login("1", "1");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        // do sth...
//    }
//
//    @Override
//    public void onLoginBitmap(Bitmap result) {
//        Observable.just(result)
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bitmap>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bitmap bitmap) {
//                        mGirlPic.setImageBitmap(bitmap);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//
//    /**
//     * 销毁时解绑
//     */
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (this.loginPresenter != null){
//            loginPresenter.detachView(this);
//        }
//    }

    /**
     * 第六步：MVP 设计 - 代码优化 - 第四步
     * 发现问题：随着 Activity 、 Fragment 数量的增加，会发现我们会反复的绑定和解除绑定
     * 这个过程属于我们的代码冗余？
     * （1 个写一个， 100 个写 100 次）
     *
     * 解决方案： Activity 的抽象
     */
    public void clickLogin(View v) {
        getPresenter().login("1", "1");
    }

    @Override
    public void onLoginResult(String result) {
        // do sth...
    }

    @Override
    public void onLoginBitmap(Bitmap result) {
        Observable.just(result)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
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
    public LoginPresenter_5 createPresenter() {
        return new LoginPresenter_5();
    }

    @Override
    public LoginView_5 createView() {
        return this;
    }
}
