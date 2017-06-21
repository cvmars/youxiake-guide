package com.youxiake.guide.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseActivity;

public class UpDateInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_info);
        initToobar();
    }

    private void initToobar(){
        setToolbarTitle("手机号码");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean isNeedToolBar() {
        return true;
    }

    @Override
    public boolean isNeedNaviBack() {
        return true;
    }
}
