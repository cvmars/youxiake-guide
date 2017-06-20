package com.youxiake.guide.ui.activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseActivity;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;

public class StartActivity extends BaseActivity {


    @BindView(R.id.iv_start)
    public ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        StatusBarUtil.setTranslucent(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goActivity(MainActivity.class);
                finish();
            }
        },2000);

        ivImage.setImageDrawable(getDefaultImageDrawble());
    }


    private BitmapDrawable getDefaultImageDrawble(){

        BitmapFactory.Options opt = new BitmapFactory.Options();

        opt.inPreferredConfig = Bitmap.Config.RGB_565;

        opt.inPurgeable = true;

        opt.inInputShareable = true;

        InputStream is = getResources().openRawResource(R.raw.welcome);

        Bitmap bitmap = BitmapFactory.decodeStream(is,null, opt);

        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BitmapDrawable(getResources(),bitmap);
    }
}
