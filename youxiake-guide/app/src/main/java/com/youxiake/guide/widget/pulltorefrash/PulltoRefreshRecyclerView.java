package com.youxiake.guide.widget.pulltorefrash;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.youxiake.guide.R;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by Cvmars for LiTing  on 2017/6/14
 */

public class PulltoRefreshRecyclerView extends FrameLayout {

    private  PtrPullRefreshLayout ptrlayout;
    private RecyclerView recyclerView;
    private RecyPtrHandler ptrHandler;
    private LinearLayoutManager layoutManager;

    public PulltoRefreshRecyclerView(Context context) {
        super(context);
        setUpView();
    }

    public PulltoRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpView();
    }

    public PulltoRefreshRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpView();
    }

    private void setUpView() {
        LayoutInflater.from(getContext()).inflate(R.layout.pulltorefresh_layout, this, true);
        ptrlayout = (PtrPullRefreshLayout) findViewById(R.id.ptr_frame);
        recyclerView = (RecyclerView) findViewById(R.id.mRecycler);
        if(layoutManager != null ){
            recyclerView.setLayoutManager(layoutManager);
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }


    /** 设置 LayoutManager
     * @param layout
     */
    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        this.recyclerView.setLayoutManager(layout);
    }

    /** 设置监听器
     * @param _ptrHandler
     */
    public void setPtrHandler(RecyPtrHandler _ptrHandler) {

        this.ptrHandler = _ptrHandler;
        ptrlayout.setPtrHandler(new RecyPtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return ptrHandler.checkCanDoRefresh(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

            }

            @Override
            protected void onRefreshMore() {


            }
        });
    }


    public static abstract class RecyPtrHandler implements PtrHandler {

        @Override
        public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
            return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
        }

        protected abstract void onRefreshMore();

    }

}
