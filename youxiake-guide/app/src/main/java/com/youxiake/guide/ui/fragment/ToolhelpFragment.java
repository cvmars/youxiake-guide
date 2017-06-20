package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake.guide.R;
import com.youxiake.guide.adapter.HomeNoteAdapter;
import com.youxiake.guide.adapter.ToolHelpAdapter;
import com.youxiake.guide.base.BaseFragment;
import com.youxiake.guide.model.HelloModel;
import com.youxiake.guide.widget.pulltorefrash.PulltoRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class ToolhelpFragment extends BaseFragment {

    @BindView(R.id.list_shareNote)
    PulltoRefreshRecyclerView listShareNote;

    ToolHelpAdapter noteAdapter;

    List<HelloModel> models = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_tool_help, null);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {
//        listShareNote.setLayoutManager(new LinearLayoutManager(getActivity()));
        noteAdapter = new ToolHelpAdapter(models);
//        addMore();
        listShareNote.setAdapter(noteAdapter);
        listShareNote.setPullRefreshListener(new PulltoRefreshRecyclerView.RecyPtrHandler() {
            @Override
            public void onLoadMore() {
                listShareNote.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(!listShareNote.isLoadMoreEnd(4)){
                            addMore();
                            listShareNote.loadMoreComplete();
                        }
                    }
                }, 1800);
            }
            @Override
            public void onRefresh() {
                listShareNote.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        models.clear();
                        addMore();
                        listShareNote.setNewData(models);
                        listShareNote.refreshComplete();
                    }
                }, 1800);
            }
        });
        listShareNote.setAutoRefresh();
    }

    private void addMore(){
        for (int i = 0; i < 20 ; i++) {
            HelloModel model = new HelloModel();
            if(i%7 ==0){
                model.setItemType(HelloModel.IMG);
            }
            models.add(model);
        }

    }
}
