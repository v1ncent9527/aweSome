package com.v1ncent.awesome.common.recyclerview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.LayoutSwitchAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/7/19.
 */

public class LayoutSwitchAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.floatBar)
    FloatingActionButton floatBar;

    private LayoutSwitchAdapter layoutSwitchAdapter;
    private GridLayoutManager gridLayoutManager;
    private List<Movie> mData = new ArrayList<>();
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchlayout);
        ButterKnife.bind(this);
        getData();

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LayoutSwitch");

        gridLayoutManager = new GridLayoutManager(this, 1);
        layoutSwitchAdapter = new LayoutSwitchAdapter(R.layout.item_layout_switch, mData, gridLayoutManager);
        layoutSwitchAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(layoutSwitchAdapter);

        layoutSwitchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showToast(mData.get(position).getName());
            }
        });
    }

    private void getData() {
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            String name = null;
            switch (i % 3) {
                case 0:
                    name = "变形金刚";
                    break;
                case 1:
                    name = "流感";
                    break;
                case 2:
                    name = "釜山行";
                    break;
            }
            int price = random.nextInt(10) + 40;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            mData.add(movie);
        }
    }

    @OnClick(R.id.floatBar)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.floatBar:
                if (isOpen) {
                    floatBar.setImageResource(R.drawable.ic_span_1);
                    isOpen = false;
                } else {
                    floatBar.setImageResource(R.drawable.ic_span_3);
                    isOpen = true;
                }
                switch (gridLayoutManager.getSpanCount()) {
                    case 1:
                        gridLayoutManager.setSpanCount(3);
                        break;
                    case 3:
                        gridLayoutManager.setSpanCount(1);
                        break;
                    default:
                        gridLayoutManager.setSpanCount(1);
                        break;
                }
                layoutSwitchAdapter.notifyItemRangeChanged(0, layoutSwitchAdapter.getItemCount());
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
