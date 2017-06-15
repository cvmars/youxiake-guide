package com.youxiake.guide.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.youxiake.guide.eventbus.EventBusWrap;

import butterknife.ButterKnife;

/**
 * Created by Cvmars on 2017/6/14.
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViewsAndEvents(view);
        if (isRegisteredEventBus()) {
            EventBusWrap.register(this);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisteredEventBus()) {
            EventBusWrap.unregister(this);
        }
    }
}
