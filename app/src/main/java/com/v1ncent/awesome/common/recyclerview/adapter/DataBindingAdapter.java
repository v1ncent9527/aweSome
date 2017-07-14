package com.v1ncent.awesome.common.recyclerview.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.BR;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;
import com.v1ncent.awesome.common.recyclerview.pojo.MoviePresenter;

import java.util.List;

/**
 * Created by v1ncent on 2017/7/4.
 */

public class DataBindingAdapter extends BaseQuickAdapter<Movie, DataBindingAdapter.MovieViewHolder> {
    private MoviePresenter mPresenter;

    public DataBindingAdapter(@LayoutRes int layoutResId, @Nullable List<Movie> data) {
        super(layoutResId, data);
        mPresenter = new MoviePresenter();
    }

    @Override
    protected void convert(MovieViewHolder helper, Movie item) {
        ViewDataBinding binding = helper.getBinding();
        helper.addOnClickListener(R.id.movie_price);
        binding.setVariable(BR.movie, item);
        binding.setVariable(BR.presenter, mPresenter);
        binding.executePendingBindings();
        switch (helper.getLayoutPosition() %
                3) {
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
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public class MovieViewHolder extends BaseViewHolder {
        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}
