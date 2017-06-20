package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake.guide.R;
import com.youxiake.guide.adapter.IndexGuideRecordAdapter;
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
    PulltoRefreshRecyclerView listIndexHome;
    protected IndexGuideRecordAdapter noteAdapter;
    protected List<HelloModel> models = new ArrayList<>();
    ColorArcProgressBar pgHomeGoal;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View parentView = inflater.inflate(R.layout.frg_index_home, null);
        return parentView;
    }


    @Override
    public void onResume() {
        super.onResume();
        pgHomeGoal.setCurrentValues(4.7f);
    }

    @Override
    protected void initViewsAndEvents(View parentView) {
        noteAdapter = new IndexGuideRecordAdapter(R.layout.list_index_guide, models);
//        addMore();
        listIndexHome.setAdapter(noteAdapter);
        View header = LayoutInflater.from(getContext()).inflate(R.layout.header_index, null);
        pgHomeGoal = (ColorArcProgressBar) header.findViewById(R.id.pg_home_goal);
        noteAdapter.addHeaderView(header);
        listIndexHome.setPullRefreshListener(new PulltoRefreshRecyclerView.RecyPtrHandler() {
            @Override
            public void onLoadMore() {
                listIndexHome.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (!listIndexHome.isLoadMoreEnd(4)) {
                            addMore();
                            listIndexHome.loadMoreComplete();
                        }
                    }
                }, 1800);
            }

            @Override
            public void onRefresh() {
                listIndexHome.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        models.clear();
                        addMore();
                        listIndexHome.setNewData(models);
                        listIndexHome.refreshComplete();
                    }
                }, 1800);
            }
        });
        addMore();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    private void addMore() {
        for (int i = 0; i < 10; i++) {
            HelloModel model = new HelloModel();
            models.add(model);
        }

    }
}
