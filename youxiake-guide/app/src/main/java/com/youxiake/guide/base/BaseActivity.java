package com.youxiake.guide.base;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youxiake.guide.eventbus.EventBusWrap;
import com.youxiake.guide.utils.ActivityUtils;
import com.youxiake.guide.utils.MyLog;

import butterknife.ButterKnife;

/**
 * Created by Cvmars on 2017/6/13.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyLog.d(TAG + "--->>> onStart :");
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActivityUtils.addActivity(this);
        //判断是否注册eventBus，如果子类需要注册重写 isRegisteredEventBus()方法，返回true;
        if (isRegisteredEventBus()) {
            EventBusWrap.register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.d(TAG + "--->>> onDestroy :");
        ActivityUtils.removeActivity(this);
        if (isRegisteredEventBus()) {
            EventBusWrap.unregister(this);
        }
    }

    /**
     * 判断是否注册eventBus，如果子类需要注册重写 isRegisteredEventBus()方法，返回true;
     * @return
     */
    public boolean isRegisteredEventBus(){

        return false;
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }





    /**
     * 跳转界面
     * @param cls
     */
    public void goActivity(Class<?> cls){
        goActivity(null,cls);
    }

    /**
     * 跳转界面带动画
     * @param cls
     */
    public void goActivityForTran(Class<?> cls){
        Intent intent =  new Intent(this,cls);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }
    }


    /**
     * 跳转界面
     */
    public void goActivity(Bundle bundle ,Class<?> cls){
        Intent intent =  new Intent(this,cls);
        Bundle bundle1 = new Bundle();
        if(bundle !=null){
            bundle1.putAll(bundle);
        }
        intent.putExtras(bundle1);
        startActivity(intent);
    }
//    /**
//     * 跳转界面
//     */
//    public void goActivity(String key1,Object values1 ,Class<?> cls){
//        Intent intent =  new Intent(this,cls);
//        Bundle bundle1 = new Bundle();
//        intent.putExtras(bundle1);
//        startActivity(intent);
//    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view,params);
        ButterKnife.bind(this);
    }

    /** 导航栏后退事件
     * @param v
     */
    public void onBack(View v) {
        finish();
    }

    /**
     * 弹出对话框
     * @param text
     */
    public void showToast(String text) {

        if (!TextUtils.isEmpty(text)) {
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLog.d(TAG + "--->>> onStart :");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MyLog.d(TAG + "--->>> onRestart :");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyLog.d(TAG + "--->>> onResume :");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLog.d(TAG + "--->>> onPause :");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLog.d(TAG + "--->>> onStop :");
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MyLog.d(TAG + "--->>> onLowMemory :");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MyLog.d(TAG + "--->>> onBackPressed :");
    }
}
