package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youxiake.guide.R;
import com.youxiake.guide.adapter.HomeNoteAdapter;
import com.youxiake.guide.base.BaseFragment;
import com.youxiake.guide.model.HelloModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class ShareNoteFragment extends BaseFragment {

    @BindView(R.id.list_shareNote)
    RecyclerView listShareNote;

    HomeNoteAdapter noteAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_sharenote, null);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {


        listShareNote.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<HelloModel> models = new ArrayList<>();
        for (int i = 0; i < 15 ; i++) {
            HelloModel model = new HelloModel();
            models.add(model);
        }
        noteAdapter = new HomeNoteAdapter(R.layout.list_home_note,models);
        listShareNote.setAdapter(noteAdapter);
        noteAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        noteAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {


            }
        }, listShareNote);
        noteAdapter.setEnableLoadMore(true);
    }
}
