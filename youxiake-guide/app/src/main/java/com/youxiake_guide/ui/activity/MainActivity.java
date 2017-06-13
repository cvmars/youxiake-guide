package com.youxiake_guide.ui.activity;

import android.os.Bundle;

import com.youxiake_guide.R;
import com.youxiake_guide.api.Api;
import com.youxiake_guide.base.BaseActivity;

import java.util.Observable;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestData(){


//        //获取豆瓣电影TOP 100
//        Observable ob = Api.getDefault().getTopMovie(0, 100);
//        //嵌套请求
////        ob.flatMap(new Func1<String, Observable<HttpResult<Subject>>>() {
////
////            @Override
////            public Observable<HttpResult<Subject>> call(String s) {
////                return Api.getDefault().getUser("aa");
////            }
////        });
//
//
//        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<List<Subject>>(this) {
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected void _onNext(List<Subject> list) {
//                String str = "";
//                for (int i = 0; i < list.size(); i++) {
//                    str += "电影名：" + list.get(i).getTitle() + "\n";
//                }
//                mText.setText(str);
//            }
//        }, "cacheKey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);
    }
}
