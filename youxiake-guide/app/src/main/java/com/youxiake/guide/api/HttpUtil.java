package com.youxiake.guide.api;

import com.youxiake.guide.utils.MyLog;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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


    public <T> void toSubscribe(Observable<HttpResult<T>> ob, final SimpleSubscriber subscriber,String cacheKey){

        Observable<T> resultObservable = ob.flatMap(new Function<HttpResult<T>, Observable<T>>() {
            @Override
            public Observable<T> apply(HttpResult<T> result) throws Exception {
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
                .observeOn(AndroidSchedulers.mainThread());
        RetrofitCache.load(resultObservable,cacheKey).subscribe(subscriber);
    }

    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {

        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter subscriber) throws Exception {
                try {
                    MyLog.d("onNext"+ data);
                    subscriber.onNext(data);
                    subscriber.onComplete();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
