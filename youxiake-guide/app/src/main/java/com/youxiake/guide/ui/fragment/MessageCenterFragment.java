package com.youxiake.guide.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.youxiake.guide.R;
import com.youxiake.guide.adapter.HomeNoteAdapter;
import com.youxiake.guide.adapter.MessageCenterAdapter;
import com.youxiake.guide.base.BaseFragment;
import com.youxiake.guide.model.HelloModel;
import com.youxiake.guide.utils.DensityUtils;
import com.youxiake.guide.utils.ScreenUtils;
import com.youxiake.guide.widget.pulltorefrash.PulltoRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class MessageCenterFragment extends BaseFragment {

    @BindView(R.id.list_shareNote)
    PulltoRefreshRecyclerView listShareNote;

    MessageCenterAdapter noteAdapter;

    List<HelloModel> models = new ArrayList<>();
    @BindView(R.id.fake_statusbar_view)
    View fakeStatusbarView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_messagecenter, null);
        unbinder = ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    public boolean isNeedToolBar() {
        return true;
    }

    @Override
    protected void initViewsAndEvents(View view) {
//        listShareNote.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fakeStatusbarView.getLayoutParams();
            layoutParams.height = ScreenUtils.getStatusHeight(getActivity());
        }

        noteAdapter = new MessageCenterAdapter(R.layout.list_message_item, models);
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

    private void addMore() {
        for (int i = 0; i < 10; i++) {
            HelloModel model = new HelloModel();
            models.add(model);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
