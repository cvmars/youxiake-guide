package com.youxiake.guide.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.youxiake.guide.R;
import com.youxiake.guide.eventbus.EventBusWrap;

import butterknife.ButterKnife;

/**
 * Created by Cvmars on 2017/6/14.
 */

public abstract class BaseFragment extends Fragment {

    protected Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViewsAndEvents(view);

        if (isRegisteredEventBus()) {
            EventBusWrap.register(this);
        }
        if(isNeedToolBar()){
             toolbar = (Toolbar) view.findViewById(R.id.toolbar_base);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }
    }

    protected abstract void initViewsAndEvents(View parentView);

    /**
     * 判断是否注册eventBus，如果子类需要注册重写 isRegisteredEventBus()方法，返回true;
     * @return
     */
    public boolean isRegisteredEventBus(){

        return false;
    }
    /**
     * 判断是否注册eventBus，如果子类需要注册重写 isRegisteredEventBus()方法，返回true;
     * @return
     */
    public boolean isNeedToolBar(){
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisteredEventBus()) {
            EventBusWrap.unregister(this);
        }
    }

    /**
     * 跳转界面
     * @param cls
     */
    public void goActivity(Class<?> cls){
        FragmentActivity context = getActivity();
        if(context != null){
            goActivity(null,cls);
        }
    }

    /**
     * 跳转界面
     */
    public void goActivity(Bundle bundle ,Class<?> cls){

        FragmentActivity context = getActivity();
        if(context != null){
            Intent intent =  new Intent(context,cls);
            Bundle bundle1 = new Bundle();
            if(bundle !=null){
                bundle1.putAll(bundle);
            }
            intent.putExtras(bundle1);
            startActivity(intent);
        }
    }
}
