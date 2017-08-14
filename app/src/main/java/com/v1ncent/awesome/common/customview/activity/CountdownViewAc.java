package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.adapter.CountDownAdapter;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/8/2.
 */

public class CountdownViewAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private CountDownAdapter countDownAdapter;
    private CountdownViewAc mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
        mContext = this;

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CountdownView");

        countDownAdapter = new CountDownAdapter(R.layout.item_count_view, Arrays.asList(new Long[]{(long) 48 * 60 * 1000, (long) 18 * 60 * 1000
                , (long) 38 * 60 * 1000, (long) 72 * 60 * 1000, (long) 48 * 60 * 1000, (long) 60 * 60 * 1000, (long) 48 * 60 * 1000, (long) 48 * 60 * 1000, (long) 27 * 60 * 1000}));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(countDownAdapter);

    }

    @Override
    public void onClickListener(View v) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
