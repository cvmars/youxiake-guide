package com.youxiake.guide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class MeFragment extends BaseFragment{

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_me,null);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {

        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);

    }
}
