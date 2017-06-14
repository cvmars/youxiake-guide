//package com.youxiake_guide.api;
//
//import android.content.Context;
//import com.youxiake_guide.utils.MyLog;
//import com.youxiake_guide.widget.SimpleLoadDialog;
//
//
//import rx.Subscriber;
//
///**
// * Created by Administrator on 2017/6/13 0013.
// */
//
//public abstract class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
//
//    private SimpleLoadDialog dialogHandler;
//
//    public ProgressSubscriber(Context context) {
//        dialogHandler = new SimpleLoadDialog(context,this,true);
//    }
//
//    @Override
//    public void onCompleted() {
//        dismissProgressDialog();
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        _onStart();
//    }
//
//    /**
//     * 显示Dialog
//     */
//    public void showProgressDialog(){
//        if (dialogHandler != null) {
////            dialogHandler.obtainMessage(SimpleLoadDialog.SHOW_PROGRESS_DIALOG).sendToTarget();
//            dialogHandler.show();
//        }
//    }
//
//    @Override
//    public void onNext(T t) {
//        if(t != null){
//            MyLog.d("result :" + t.toString());
//        }
//        _onNext(t);
//    }
//
//    /**
//     * 隐藏Dialog
//     */
//    private void dismissProgressDialog(){
//        if (dialogHandler != null) {
////            dialogHandler.obtainMessage(SimpleLoadDialog.DISMISS_PROGRESS_DIALOG).sendToTarget();
//            dialogHandler.dismiss();;
//            dialogHandler=null;
//        }
//    }
//    @Override
//    public void onError(Throwable e) {
//        e.printStackTrace();
////        if (NetUtils.isConnected(MyApp.getApplication())) { //这里自行替换判断网络的代码
////            _onError("网络不可用");
////        } else if (e instanceof ApiException) {
////            _onError(e.getMessage());
////        } else {
////            _onError("请求失败，请稍后再试...");
////        }
//        dismissProgressDialog();
//    }
//
//
//    @Override
//    public void onCancelProgress() {
//        if (!this.isUnsubscribed()) {
//            this.unsubscribe();
//        }
//    }
//    protected abstract void _onNext(T t);
//    protected abstract void _onError(String message);
//    protected abstract void _onStart();
//}
