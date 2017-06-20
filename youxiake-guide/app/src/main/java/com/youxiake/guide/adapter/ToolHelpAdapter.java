package com.youxiake.guide.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youxiake.guide.R;
import com.youxiake.guide.model.HelloModel;

import java.util.List;

/**
 * Created by Cvmars for LiTing  on 2017/6/20
 */

public class ToolHelpAdapter extends BaseMultiItemQuickAdapter<HelloModel,BaseViewHolder> {

    public ToolHelpAdapter(@Nullable List<HelloModel> data) {
        super( data);
        addItemType(HelloModel.IMG, R.layout.list_tool_help_type1);
        addItemType(HelloModel.TEXT, R.layout.list_tool_help_type2);
    }

    @Override
    protected void convert(BaseViewHolder helper, HelloModel item) {


    }
}