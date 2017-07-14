package com.v1ncent.awesome.common.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.HomeAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.HomeItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/6/8.
 */

public class CommonAdapterAc extends BaseActivity {
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    private static final Class<?>[] ACTIVITY = {AnimationUseAc.class,
            MultipleItemUseAc.class,
            HeaderAndFooterUseAc.class,
            PullToRefreshUseAc.class,
            SectionUseAc.class,
            EmptyViewUseAc.class,
            ItemDragAndSwipeUseAc.class,
            ItemClickAc.class,
            ExpandableUseAc.class
            , DataBindingUseAc.class};
    private static final String[] TITLE = {"Animation", "MultipleItem",
            "Header/Footer", "PullToRefresh", "Section", "EmptyView",
            "DragAndSwipe", "ItemClick", "ExpandableItem", "DataBinding", "UpFetchData"};
    private static final int[] IMG = {R.mipmap.gv_animation,
            R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer,
            R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty,
            R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click,
            R.mipmap.gv_expandable, R.mipmap.gv_databinding, R.drawable.gv_up_fetch};
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    private ArrayList<HomeItem> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_adapter);
        ButterKnife.bind(this);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("通用Adapter");

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }

    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, mDataList);
        //animation
        homeAdapter.openLoadAnimation();
        //set header
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(CommonAdapterAc.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onClickListener(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
