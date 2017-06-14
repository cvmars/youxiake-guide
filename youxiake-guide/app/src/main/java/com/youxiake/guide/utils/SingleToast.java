package com.youxiake.guide.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.youxiake.guide.app.MyApp;

/** 显示信息
 * Created by zsm on 16/7/22.
 */
public class SingleToast {

    private Toast mToast;
    private String mMsg;

    private static SingleToast instance = new SingleToast();


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.obj!=null && mToast!=null){
                mToast.setText(msg.obj.toString());
            }
        }
    };

    /** 显示吐司 防止重复吐司时间过长
     * @param msg
     */
    private void _showToast(String msg) {
        if (mToast != null) {
            Message message = Message.obtain();
            message.obj = msg;
            handler.sendMessage(message);
        } else {
            mToast = Toast.makeText(MyApp.getApplication(), msg, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }


    /**显示吐司
     * @param msg
     */
    public static void showToast(String msg) {
        instance._showToast(msg);
    }

}
