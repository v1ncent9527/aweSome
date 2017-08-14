package com.v1ncent.awesome.common.customview.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;

import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by v1ncent on 2017/8/2.
 */

public class CountDownAdapter extends BaseQuickAdapter<Long, BaseViewHolder> {

    public CountDownAdapter(@LayoutRes int layoutResId, @Nullable List<Long> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Long item) {
        switch (helper.getLayoutPosition() % 4) {
            case 0:
                helper.setImageResource(R.id.item_img, R.mipmap.mi_6);
                helper.setText(R.id.item_name, "小米6");
                ((CountdownView) helper.getView(R.id.item_countdownView)).start(item);
                break;
            case 1:
                helper.setImageResource(R.id.item_img, R.mipmap.iphone_5s);
                helper.setText(R.id.item_name, "iphone6");
                ((CountdownView) helper.getView(R.id.item_countdownView)).start(item);
                break;
            case 2:
                helper.setImageResource(R.id.item_img, R.mipmap.iphone_6);
                helper.setText(R.id.item_name, "iphone5s");
                ((CountdownView) helper.getView(R.id.item_countdownView)).start(item);
                break;
            case 3:
                helper.setImageResource(R.id.item_img, R.mipmap.samsung);
                helper.setText(R.id.item_name, "三星G_8");
                ((CountdownView) helper.getView(R.id.item_countdownView)).start(item);
                break;

        }
    }
}
