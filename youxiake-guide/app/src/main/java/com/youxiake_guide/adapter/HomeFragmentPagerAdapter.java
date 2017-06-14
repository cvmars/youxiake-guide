package com.youxiake_guide.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Cvmars on 2017/6/14.
 */

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    FragmentManager fm;

    public HomeFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 :fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = fragments.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
}
