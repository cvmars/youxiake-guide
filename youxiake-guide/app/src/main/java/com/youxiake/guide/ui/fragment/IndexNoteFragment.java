package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseFragment;

/**
 * Created by Cvmars for LiTing  on 2017/6/15
 */

public class IndexNoteFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_index_note,null);
        return parentView;
    }


    @Override
    protected void initViewsAndEvents(View parentView) {

    }
}
