package com.youxiake_guide.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.youxiake_guide.listener.PermissionListener;
import com.youxiake_guide.utils.ActivityUtils;
import com.youxiake_guide.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class BaseActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();

    private static PermissionListener mPermissionListener;

    private static final int CODE_REQUEST_PERMISSION = 1;

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyLog.d(TAG + "--->>> onStart :");
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        ActivityUtils.addActivity(this);
    }

    public static void requestPermissions(String[] permissions, PermissionListener listener) {
        Activity activity = ActivityUtils.getTopActivity();
        if (null == activity) {
            return;
        }

        mPermissionListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissionList) {
            //权限没有授权
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(activity, permissionList.toArray(new String[permissionList.size()]),
                    CODE_REQUEST_PERMISSION);
        } else {
            mPermissionListener.onGranted();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CODE_REQUEST_PERMISSION:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int result = grantResults[i];
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            String permission = permissions[i];
                            deniedPermissions.add(permission);
                        }
                    }

                    if (deniedPermissions.isEmpty()) {
                        mPermissionListener.onGranted();
                    } else {
                        mPermissionListener.onDenied(deniedPermissions);
                    }
                }
                break;

            default:
                break;
        }
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
        lifecycleSubject.onNext(ActivityLifeCycleEvent.START);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MyLog.d(TAG + "--->>> onRestart :");
        lifecycleSubject.onNext(ActivityLifeCycleEvent.RESTART);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyLog.d(TAG + "--->>> onResume :");
        lifecycleSubject.onNext(ActivityLifeCycleEvent.RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLog.d(TAG + "--->>> onPause :");
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLog.d(TAG + "--->>> onStop :");
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.d(TAG + "--->>> onDestroy :");
        ActivityUtils.removeActivity(this);
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
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
