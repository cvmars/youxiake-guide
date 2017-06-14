package com.youxiake.guide.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youxiake.guide.model.HelloModel;

import java.util.List;

/**
 * Created by Cvmars for LiTing  on 2017/6/14
 */

public class HomeNoteAdapter extends BaseQuickAdapter<HelloModel,BaseViewHolder> {

    public HomeNoteAdapter(@LayoutRes int layoutResId, @Nullable List<HelloModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HelloModel item) {

    }
}
