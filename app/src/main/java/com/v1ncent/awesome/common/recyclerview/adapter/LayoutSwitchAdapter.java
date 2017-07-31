package com.v1ncent.awesome.common.recyclerview.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;

import java.util.List;

/**
 * Created by v1ncent on 2017/7/19.
 */

public class LayoutSwitchAdapter extends BaseQuickAdapter<Movie, BaseViewHolder> {
    private GridLayoutManager mLayoutManager;

    public LayoutSwitchAdapter(@LayoutRes int layoutResId, @Nullable List<Movie> data, GridLayoutManager layoutManager) {
        super(layoutResId, data);
        mLayoutManager = layoutManager;
    }

    @Override
    protected void convert(BaseViewHolder helper, Movie item) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == 1) {
            helper.setVisible(R.id.layout_big, true);
            helper.setVisible(R.id.layout_small, false);
        } else {
            helper.setVisible(R.id.layout_big, false);
            helper.setVisible(R.id.layout_small, true);
        }

        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.image_big, R.mipmap.bxjg);
                helper.setImageResource(R.id.image_small, R.mipmap.bxjg);
                break;
            case 1:
                helper.setImageResource(R.id.image_big, R.mipmap.lg);
                helper.setImageResource(R.id.image_small, R.mipmap.lg);
                break;
            case 2:
                helper.setImageResource(R.id.image_big, R.mipmap.ksx);
                helper.setImageResource(R.id.image_small, R.mipmap.ksx);
                break;
        }

        helper.setText(R.id.movie_name_small, item.getName());
        helper.setText(R.id.movie_name_big, item.getName());
        helper.setText(R.id.movie_content, item.getContent());
        helper.setText(R.id.movie_price, "$" + item.getPrice());
    }
}
