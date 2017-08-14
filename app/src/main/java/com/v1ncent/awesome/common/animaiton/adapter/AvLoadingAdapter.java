package com.v1ncent.awesome.common.animaiton.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

/**
 * Created by v1ncent on 2017/8/2.
 */

public class AvLoadingAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AvLoadingAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        AVLoadingIndicatorView avLoadingIndicatorView = helper.getView(R.id.item_av_loading_view);
        avLoadingIndicatorView.setIndicator(item);
        avLoadingIndicatorView.show();
    }
}
