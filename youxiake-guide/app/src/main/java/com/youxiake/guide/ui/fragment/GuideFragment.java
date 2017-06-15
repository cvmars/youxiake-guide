package com.youxiake.guide.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youxiake.guide.R;
import com.youxiake.guide.adapter.HomeFragmentPagerAdapter;
import com.youxiake.guide.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class GuideFragment extends BaseFragment implements ViewPager.OnPageChangeListener{


    @BindView(R.id.mys_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.viewPager_guide)
    ViewPager viewPagerHome;

    @BindView(R.id.txt_guide_note)
    TextView txtHomeNote;
    @BindView(R.id.txt_guide_guide)
    TextView txtHomeGuide;

    HomeFragmentPagerAdapter fragmentPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_guide,null);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GuidehelpFragment());
        fragments.add(new GuideTemplateFragment());
        fragmentPagerAdapter = new HomeFragmentPagerAdapter(getFragmentManager(), fragments);
        viewPagerHome.setAdapter(fragmentPagerAdapter);
        viewPagerHome.setOnPageChangeListener(this);
    }

    @OnClick({R.id.txt_guide_note, R.id.txt_guide_guide})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_guide_note:
                viewPagerHome.setCurrentItem(0);
                break;
            case R.id.txt_guide_guide:
                viewPagerHome.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        initText();
        if(position == 0){
            txtHomeNote.setTextColor(getResources().getColor(R.color.colorAccent));
        }else{
            txtHomeGuide.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initText(){
        txtHomeNote.setTextColor(Color.WHITE);
        txtHomeGuide.setTextColor(Color.WHITE);
    }
}
