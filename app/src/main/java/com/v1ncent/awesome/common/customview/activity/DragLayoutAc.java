package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.fragment.VerticalFragment1;
import com.v1ncent.awesome.common.customview.fragment.VerticalFragment2;
import com.v1ncent.awesome.common.customview.view.DragLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/8/2.
 */

public class DragLayoutAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.first)
    FrameLayout first;
    @BindView(R.id.second)
    FrameLayout second;
    @BindView(R.id.draglayout)
    DragLayout draglayout;

    private VerticalFragment1 fragment1;
    private VerticalFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_layout);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("商品详情");

        fragment1 = new VerticalFragment1();
        fragment2 = new VerticalFragment2();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first, fragment1).add(R.id.second, fragment2)
                .commit();
        DragLayout.ShowNextPageNotifier nextIntf = new DragLayout.ShowNextPageNotifier() {
            @Override
            public void onDragNext() {
                fragment2.initView();
            }
        };
        draglayout.setNextPageListener(nextIntf);

    }

    @Override
    public void onClickListener(View v) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
