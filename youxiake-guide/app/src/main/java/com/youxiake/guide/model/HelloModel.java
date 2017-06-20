package com.youxiake.guide.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Cvmars for LiTing  on 2017/6/14
 */

public class HelloModel implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType = TEXT;
    public String title,content,imgUrl,img;

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
