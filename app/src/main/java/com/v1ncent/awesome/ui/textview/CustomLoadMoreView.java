package com.v1ncent.awesome.ui.textview;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.v1ncent.awesome.R;

/**
 * Created by v1ncent on 2017/6/19.
 */

public final class CustomLoadMoreView extends LoadMoreView {

    @Override
    public int getLayoutId() {
        return R.layout.view_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
