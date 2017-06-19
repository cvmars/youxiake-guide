package com.youxiake.guide.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.DebugUtil;
import com.youxiake.guide.R;
import com.youxiake.guide.base.BaseActivity;
import com.youxiake.guide.utils.ImageLoader;
import com.youxiake.guide.utils.MyLog;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MeInfoActivity extends BaseActivity {

    @BindView(R.id.iv_meinfo_avator)
    ImageView ivMeinfoAvator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_info);

    }



    @OnClick(R.id.iv_meinfo_avator)
    public void onViewClicked() {

        PictureSelector.create(MeInfoActivity.this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .theme(R.style.picture_default_style)
                .selectionMode(PictureConfig.SINGLE)
                .previewImage(true)
//                .previewVideo(true)
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)
                .compressMaxKB(400)
                .compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)
                .glideOverride(800,800)// 是否压缩 true or false
                .withAspectRatio(1,1)
                .rotateEnabled(true)
                .scaleEnabled(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    if(localMedias != null && localMedias.size()>0){
                        ImageLoader.loadImage(MeInfoActivity.this,ivMeinfoAvator,localMedias.get(0).getCutPath());
                    }
                    break;
            }
        }
    }

}
