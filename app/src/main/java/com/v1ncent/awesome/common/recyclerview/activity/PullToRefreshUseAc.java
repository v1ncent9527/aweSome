package com.v1ncent.awesome.common.recyclerview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.HeaderandFooterAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.CommonAdapterVO;
import com.v1ncent.awesome.ui.textview.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/6/19.
 */

public class PullToRefreshUseAc extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private PullToRefreshUseAc context;
    private List<CommonAdapterVO> commonAdapterVOList;
    private HeaderandFooterAdapter headerandFooterAdapter;
    private int delayMillis = 1000;
    private int mCurrentCounter = 0;
    private static final int PAGE_SIZE = 6;
    private boolean isErr;
    private boolean mLoadMoreEndGone = false;
    private static final int TOTAL_COUNTER = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);
        ButterKnife.bind(this);
        context = this;

        initView();
        initDate(10);
        initAdapter();
    }


    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("PullToRefreshUse");
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //SwipeRefreshLayout
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.GRAY);


    }

    private List<CommonAdapterVO> initDate(int size) {
        commonAdapterVOList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            CommonAdapterVO commonAdapterVO = new CommonAdapterVO("banner" + i, "text\ntext" + i);
            commonAdapterVOList.add(commonAdapterVO);
        }
        return commonAdapterVOList;
    }

    private void initAdapter() {
        headerandFooterAdapter = new HeaderandFooterAdapter(R.layout.item_layout_animation, commonAdapterVOList);
        headerandFooterAdapter.openLoadAnimation();
        headerandFooterAdapter.setOnLoadMoreListener(this, mRecyclerView);

        //headView
        View headView = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        headView.findViewById(R.id.iv).setVisibility(View.GONE);
        headerandFooterAdapter.addHeaderView(headView);

        //CustomLoadMoreView
        headerandFooterAdapter.setLoadMoreView(new CustomLoadMoreView());

        mRecyclerView.setAdapter(headerandFooterAdapter);
        mCurrentCounter = headerandFooterAdapter.getData().size();

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                showToast(String.valueOf(position));
            }
        });
    }

    @Override
    public void onClickListener(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        headerandFooterAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                headerandFooterAdapter.setNewData(initDate(PAGE_SIZE));
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                mSwipeRefreshLayout.setRefreshing(false);
                headerandFooterAdapter.setEnableLoadMore(true);
            }
        }, delayMillis);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        if (headerandFooterAdapter.getData().size() < PAGE_SIZE) {
            headerandFooterAdapter.loadMoreEnd(true);
        } else {
            if (mCurrentCounter >= TOTAL_COUNTER) {
//                    headerandFooterAdapter.loadMoreEnd();//default visible
                headerandFooterAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
            } else {
                if (isErr) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            headerandFooterAdapter.addData(initDate(PAGE_SIZE));
                            mCurrentCounter = headerandFooterAdapter.getData().size();
                            headerandFooterAdapter.loadMoreComplete();
                        }
                    },delayMillis);

                } else {
                    isErr = true;
                    showToast("net did not work");
                    headerandFooterAdapter.loadMoreFail();
                }
            }
            mSwipeRefreshLayout.setEnabled(true);
        }
    }
}
