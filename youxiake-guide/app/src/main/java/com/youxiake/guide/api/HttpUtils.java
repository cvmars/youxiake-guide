//package com.youxiake_guide.api;
//
//import com.youxiake_guide.base.ActivityLifeCycleEvent;
//
//import rx.Observable;
//import rx.functions.Action0;
//import rx.subjects.PublishSubject;
//
///**
// * Created by Administrator on 2017/6/13 0013.
// */
//
//public class HttpUtils {
//
//    private HttpUtils(){}
//
//    /**
//     * 在访问HttpMethods时创建单例
//     */
//    private static class SingletonHolder {
//        private static final HttpUtils INSTANCE = new HttpUtils();
//    }
//
//
//    /**
//     * 获取单例
//     */
//    public static HttpUtils getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    /**
//     * 添加线程管理并订阅
//     * @param ob
//     * @param subscriber
//     * @param cacheKey 缓存kay
//     * @param event Activity 生命周期
//     * @param lifecycleSubject
//     * @param isSave 是否缓存
//     * @param forceRefresh 是否强制刷新
//     */
//    public void toSubscribe(Observable ob, final ProgressSubscriber subscriber, String cacheKey, final ActivityLifeCycleEvent event,
//                            final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject, boolean isSave, boolean forceRefresh) {
//        //数据预处理
//        Observable.Transformer<HttpResult<Object>, Object> result = RxHelper.handleResult(event,lifecycleSubject);
//        Observable observable = ob.compose(result)
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        //显示Dialog和一些其他操作
//                        subscriber.showProgressDialog();
//                    }
//                });
//        RetrofitCache.load(cacheKey,observable,isSave,forceRefresh).subscribe(subscriber);
//    }
//
//    /**
//     * 添加线程管理并订阅
//     * @param ob
//     * @param subscriber
//     * @param event Activity 生命周期
//     * @param lifecycleSubject
//     */
//    public void toSubscribe(Observable ob, final ProgressSubscriber subscriber, final ActivityLifeCycleEvent event,
//                            final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
//        toSubscribe(ob,subscriber,"",event,lifecycleSubject,false,true);
//    }
//}
