package com.v1ncent.awesome.common.recyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;

import java.util.List;

/**
 * Created by v1ncent on 2017/8/9.
 */

public class ShimmerLayoutAdapter extends BaseQuickAdapter<Movie, BaseViewHolder> {

    public ShimmerLayoutAdapter(@Nullable List<Movie> data) {
        super(R.layout.item_shimmer_complete, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Movie item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.bxjg);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.lg);
                break;
            case 2:
                helper.setImageResource(R.id.iv, R.mipmap.ksx);
                break;

        }
        helper.setText(R.id.movie_name, item.getName());
        helper.setText(R.id.movie_content, item.getContent());
        helper.setText(R.id.movie_price, item.getPrice() + "");
    }
}
