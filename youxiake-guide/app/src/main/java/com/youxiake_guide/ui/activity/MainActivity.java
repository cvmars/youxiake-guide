package com.youxiake_guide.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youxiake_guide.R;
import com.youxiake_guide.api.Api;
import com.youxiake_guide.api.HttpResult;
import com.youxiake_guide.api.HttpUtil;
import com.youxiake_guide.api.SimpleSubscriber;
import com.youxiake_guide.base.BaseActivity;
import com.youxiake_guide.model.HomeModel;
import com.youxiake_guide.ui.fragment.GuideFragment;
import com.youxiake_guide.ui.fragment.HomeFragment;
import com.youxiake_guide.ui.fragment.MeFragment;
import com.youxiake_guide.ui.fragment.ShareNoteFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ll_home_home)
    LinearLayout llHomeHome;
    @BindView(R.id.ll_home_find)
    LinearLayout llHomeFind;
    @BindView(R.id.ll_home_camera)
    LinearLayout llHomeCamera;
    @BindView(R.id.ll_home_me)
    LinearLayout llHomeMe;
    @BindView(R.id.home_fral_content)
    FrameLayout homeFralContent;
    @BindView(R.id.iv_home_home)
    ImageView ivHomeHome;
    @BindView(R.id.txt_home_home)
    TextView txtHomeHome;
    @BindView(R.id.iv_home_shareNote)
    ImageView ivHomeShareNote;
    @BindView(R.id.txt_home_shareNote)
    TextView txtHomeShareNote;
    @BindView(R.id.iv_home_guide)
    ImageView ivHomeGuide;
    @BindView(R.id.txt_home_guide)
    TextView txtHomeGuide;
    @BindView(R.id.iv_home_me)
    ImageView ivHomeMe;
    @BindView(R.id.txt_home_me)
    TextView txtHomeMe;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private ShareNoteFragment shareNoteFragment;
    private GuideFragment guideFragment;
    private MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        requestData();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.home_fral_content, homeFragment);
        fragmentTransaction.commit();
    }

    public void requestData() {

        Observable<HttpResult<HomeModel>> homeInfo = Api.getDefault().getHomeInfo();
        HttpUtil.getInstance().toSubscribe(homeInfo,
                new SimpleSubscriber<HttpResult<HomeModel>>() {

                    @Override
                    protected void _onNext(HttpResult<HomeModel> o) {

                        showToast("model :" + o.toString());
                    }

                    @Override
                    protected void _onError(String message) {
                        showToast("model :" + message);
                    }

                });

    }


    @OnClick({R.id.ll_home_home, R.id.ll_home_find, R.id.ll_home_camera, R.id.ll_home_me})
    public void onClick(View view) {

        fragmentTransaction = fragmentManager.beginTransaction();
        initDefaultFragment(fragmentTransaction);
        initTextIcon();
        switch (view.getId()) {

            case R.id.ll_home_home:
                txtHomeHome.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeHome.setImageResource(R.drawable.main_icon_chutuan_selected);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.home_fral_content, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }

                break;
            case R.id.ll_home_find:
                txtHomeShareNote.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeShareNote.setImageResource(R.drawable.main_icon_gongxiang_selected);
                if (shareNoteFragment == null) {
                    shareNoteFragment = new ShareNoteFragment();
                    fragmentTransaction.add(R.id.home_fral_content, shareNoteFragment);
                } else {
                    fragmentTransaction.show(shareNoteFragment);
                }
                break;
            case R.id.ll_home_camera:
                txtHomeGuide.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeGuide.setImageResource(R.drawable.main_icon_xuzhi_selected);
                if (guideFragment == null) {
                    guideFragment = new GuideFragment();
                    fragmentTransaction.add(R.id.home_fral_content, guideFragment);
                } else {
                    fragmentTransaction.show(guideFragment);
                }
                break;
            case R.id.ll_home_me:
                txtHomeMe.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeMe.setImageResource(R.drawable.main_icon_me_selected);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    fragmentTransaction.add(R.id.home_fral_content, meFragment);
                } else {
                    fragmentTransaction.show(meFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }


    private void initDefaultFragment(FragmentTransaction fm) {

        if (homeFragment != null) {
            fm.hide(homeFragment);
        }
        if (shareNoteFragment != null) {
            fm.hide(shareNoteFragment);
        }
        if (guideFragment != null) {
            fm.hide(guideFragment);
        }
        if (meFragment != null) {
            fm.hide(meFragment);
        }
    }

    private void initTextIcon(){
        int normalColor = getResources().getColor(R.color.color_home_tab_normal);
        txtHomeHome.setTextColor(normalColor);
        txtHomeShareNote.setTextColor(normalColor);
        txtHomeGuide.setTextColor(normalColor);
        txtHomeMe.setTextColor(normalColor);
        ivHomeHome.setImageResource(R.drawable.main_icon_chutuan_normal);
        ivHomeShareNote.setImageResource(R.drawable.main_icon_gongxiang_normal);
        ivHomeGuide.setImageResource(R.drawable.main_icon_xuzhi_normal);
        ivHomeMe.setImageResource(R.drawable.main_icon_me_normal);
    }
}
