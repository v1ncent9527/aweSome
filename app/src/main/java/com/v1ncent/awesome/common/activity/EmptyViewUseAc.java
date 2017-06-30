package com.v1ncent.awesome.common.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.adapter.HeaderandFooterAdapter;
import com.v1ncent.awesome.common.pojo.CommonAdapterVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/6/30.
 */

public class EmptyViewUseAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_reset)
    FloatingActionButton btnReset;

    private EmptyViewUseAc context;
    private HeaderandFooterAdapter mQuickAdapter;
    private View notDataView;
    private View errorView;
    private List<CommonAdapterVO> commonAdapterVOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_view);
        ButterKnife.bind(this);
        context = this;

        initDate();
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EmptyViewUse");

        btnReset.setOnClickListener(context);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        mQuickAdapter = new HeaderandFooterAdapter(R.layout.item_layout_animation, commonAdapterVOList);
        mRecyclerView.setAdapter(mQuickAdapter);

    }

    private void initDate() {
        commonAdapterVOList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            CommonAdapterVO commonAdapterVO = new CommonAdapterVO("banner" + i, "text\ntext" + i);
            commonAdapterVOList.add(commonAdapterVO);
        }
    }

    private boolean mError = true;
    private boolean mNoData = true;

    private void onRefresh() {
        mQuickAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mError) {
                    mQuickAdapter.setEmptyView(errorView);
                    mError = false;
                } else {
                    if (mNoData) {
                        mQuickAdapter.setEmptyView(notDataView);
                        mNoData = false;
                    } else {
                        mQuickAdapter.setNewData(commonAdapterVOList);
                    }
                }
            }
        }, 1000);
    }

    @Override
    public void onClickListener(View v) {
        mError = true;
        mNoData = true;
        mQuickAdapter.setNewData(null);
        onRefresh();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
