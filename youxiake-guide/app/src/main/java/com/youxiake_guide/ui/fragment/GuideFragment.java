package com.youxiake_guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake_guide.R;
import com.youxiake_guide.base.BaseFragment;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class GuideFragment extends BaseFragment{



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_guide,null);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {

    }
}
