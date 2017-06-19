package com.youxiake.guide.api;

import android.support.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.youxiake.guide.utils.MyLog;

import io.reactivex.disposables.Disposable;
import io.reactivex.Observer;

/**
 * Created by Cvmars on 2017/6/14.
 */

public  abstract class SimpleSubscriber<T>  implements Observer<T> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        if(t != null){
            MyLog.d("result :" + t.toString());
        }
        _onNext(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if(e instanceof HttpException){
            HttpException exception = (HttpException)e;
            String message = exception.response().message();
            int code = exception.response().code();
            MyLog.d("HttpException code :" + code +"  message:" + message);
        }
        _onError(e.getMessage());

    }

    @Override
    public void onComplete() {

    }

    protected abstract void _onNext(T t);
    protected abstract void _onError(String message);
}
