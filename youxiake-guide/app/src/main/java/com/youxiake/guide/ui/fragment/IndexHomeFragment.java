package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake.guide.R;
import com.youxiake.guide.adapter.HomeNoteAdapter;
import com.youxiake.guide.base.BaseFragment;
import com.youxiake.guide.model.HelloModel;
import com.youxiake.guide.widget.ColorArcProgressBar;
import com.youxiake.guide.widget.pulltorefrash.PulltoRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Cvmars on 2017/6/13
 */

public class IndexHomeFragment extends BaseFragment {


    @BindView(R.id.list_home)
    PulltoRefreshRecyclerView listShareNote;

    protected HomeNoteAdapter noteAdapter;
    protected List<HelloModel> models = new ArrayList<>();
    @BindView(R.id.pg_home_goal)
    ColorArcProgressBar pgHomeGoal;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View parentView = inflater.inflate(R.layout.frg_index_home, null);
        unbinder = ButterKnife.bind(this, parentView);
        return parentView;
    }


    @Override
    public void onResume() {
        super.onResume();
        pgHomeGoal.setCurrentValues(4.7f);
        pgHomeGoal.animate();
    }

    @Override
    protected void initViewsAndEvents(View parentView) {
        noteAdapter = new HomeNoteAdapter(R.layout.list_home_note, models);
//        addMore();
        listShareNote.setAdapter(noteAdapter);
        listShareNote.setPullRefreshListener(new PulltoRefreshRecyclerView.RecyPtrHandler() {
            @Override
            public void onLoadMore() {
                listShareNote.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (!listShareNote.isLoadMoreEnd(4)) {
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void addMore() {
        for (int i = 0; i < 10; i++) {
            HelloModel model = new HelloModel();
            models.add(model);
        }

    }
}
