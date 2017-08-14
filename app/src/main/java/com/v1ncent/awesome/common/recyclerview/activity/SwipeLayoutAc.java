package com.v1ncent.awesome.common.recyclerview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.SwipeLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/8/8.
 */

public class SwipeLayoutAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private SwipeLayoutAdapter swipeLayoutAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_layout);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mData.add(i + "");
        }
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SwipeLayout");

        swipeLayoutAdapter = new SwipeLayoutAdapter(R.layout.item_swipe_laout, mData);
        swipeLayoutAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll:
                        showToast((String) ((TextView) (adapter.getViewByPosition(recyclerView, position, R.id.tv))).getText());
                        break;
                }
            }
        });
        swipeLayoutAdapter.setOnDelListener(new SwipeLayoutAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                showToast("删除了" + mData.get(pos));
                mData.remove(pos);
                swipeLayoutAdapter.notifyItemRemoved(pos);
            }

            @Override
            public void onTop(int pos) {
                showToast("置顶了" + mData.get(pos));

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(swipeLayoutAdapter);
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
