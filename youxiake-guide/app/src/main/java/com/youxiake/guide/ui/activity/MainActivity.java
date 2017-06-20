package com.youxiake.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.youxiake.guide.R;
import com.youxiake.guide.api.Api;
import com.youxiake.guide.api.HttpResult;
import com.youxiake.guide.api.HttpUtil;
import com.youxiake.guide.app.MyConfig;
import com.youxiake.guide.api.SimpleSubscriber;
import com.youxiake.guide.base.BaseActivity;
import com.youxiake.guide.model.HomeModel;
import com.youxiake.guide.ui.fragment.ToolFragment;
import com.youxiake.guide.ui.fragment.IndexHomeFragment;
import com.youxiake.guide.ui.fragment.MeFragment;
import com.youxiake.guide.ui.fragment.MessageCenterFragment;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

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
    private IndexHomeFragment homeFragment;
    private MessageCenterFragment shareNoteFragment;
    private ToolFragment guideFragment;
    private MeFragment meFragment;
    private long mExitTime;
    public static final long TWO_SECOND = 2 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTranslucentForImageViewInFragment(this,null);
        ButterKnife.bind(this);
        initView();
        requestData();
    }


    private void initView() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new IndexHomeFragment();
        fragmentTransaction.replace(R.id.home_fral_content, homeFragment);
        fragmentTransaction.commit();
    }

    public void requestData() {

        final Observable<HttpResult<HomeModel>> homeInfo = Api.getInstanceV1().getHomeInfo();
        HttpUtil.getInstance().toSubscribe(homeInfo,
                new SimpleSubscriber<HomeModel>() {

                    @Override
                    protected void _onNext(HomeModel o) {


                    }
                    @Override
                    protected void _onError(String message) {
                        showToast("_onError :" + message);
                    }

                }, MyConfig.CACHE_KEY_HOME);

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
                    homeFragment = new IndexHomeFragment();
                    fragmentTransaction.add(R.id.home_fral_content, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }

                break;
            case R.id.ll_home_find:
                txtHomeShareNote.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeShareNote.setImageResource(R.drawable.main_icon_gongxiang_selected);
                if (shareNoteFragment == null) {
                    shareNoteFragment = new MessageCenterFragment();
                    fragmentTransaction.add(R.id.home_fral_content, shareNoteFragment);
                } else {
                    fragmentTransaction.show(shareNoteFragment);
                }
                break;
            case R.id.ll_home_camera:
                txtHomeGuide.setTextColor(getResources().getColor(R.color.color_Base));
                ivHomeGuide.setImageResource(R.drawable.main_icon_xuzhi_selected);
                if (guideFragment == null) {
                    guideFragment = new ToolFragment();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > TWO_SECOND) {
                showToast("再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
