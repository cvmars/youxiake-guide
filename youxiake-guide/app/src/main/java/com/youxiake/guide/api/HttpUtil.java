package com.youxiake.guide.api;

import com.youxiake.guide.model.HomeModel;
import com.youxiake.guide.utils.MyLog;
import com.youxiake.guide.utils.ToastUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Cvmars on 2017/6/14.
 */

public class HttpUtil {


    private HttpUtil(){}

    /**
     * 在访问HttpMethods时创建单例
     */
    private static class SingletonHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }

    /**
     * 获取单例
     */
    public static HttpUtil getInstance() {
        return HttpUtil.SingletonHolder.INSTANCE;
    }


    public <T> void toSubscribe(Observable<HttpResult<T>> ob, final Subscriber subscriber){

        ob.flatMap(new Func1<HttpResult<T>, Observable<T>>() {
            @Override
            public Observable<T> call(HttpResult<T> result) {
                MyLog.d(result.toString());
                if (result.getCode() != 0) {
                    return createData(result.getData());
                } else {
                    return Observable.error(new ApiException(result.getCode()));
                }
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    MyLog.d("onNext"+ data);
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });

    }
}
