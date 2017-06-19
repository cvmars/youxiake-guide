package com.youxiake.guide.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseFragment;
import com.youxiake.guide.ui.activity.LoginActivity;
import com.youxiake.guide.ui.activity.MeInfoActivity;
import com.youxiake.guide.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Cvmars on 2017/6/13.
 */

public class MeFragment extends BaseFragment {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.txt_me_info)
    TextView txtMeInfo;
    @BindView(R.id.fake_statusbar_view)
    View fakeStatusbarView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View parentView = inflater.inflate(R.layout.frg_me, null);
        unbinder = ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    protected void initViewsAndEvents(View view) {

        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fakeStatusbarView.getLayoutParams();
            layoutParams.height = ScreenUtils.getStatusHeight(getActivity());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.txt_me_info)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_me_info:
                goActivity(MeInfoActivity.class);
                break;
        }
    }

    @OnClick(R.id.my_toolbar)
    public void onViewClicked() {


        goActivity(LoginActivity.class);
    }
}
