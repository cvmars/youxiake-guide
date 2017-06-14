package com.youxiake.guide.api;

import com.youxiake.guide.utils.MyLog;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Cvmars on 2017/6/14.
 */

public abstract class SimpleSubscriber<T>  extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }


    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onNext(T t) {
        if(t != null){
            MyLog.d("result :" + t.toString());
        }
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if(e instanceof HttpException){
            HttpException exception = (HttpException)e;
            String message = exception.response().message();
            int code = exception.response().code();
            MyLog.d("HttpException code :" + code +"  message:" + message);
        }
        _onError(e.getMessage());

//        if (NetUtils.isConnected(MyApp.getApplication())) { //这里自行替换判断网络的代码
//            _onError("网络不可用");
//        } else if (e instanceof ApiException) {
//        } else {
//            _onError("请求失败，请稍后再试...");
//        }
    }

    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
    protected abstract void _onNext(T t);
    protected abstract void _onError(String message);
}
