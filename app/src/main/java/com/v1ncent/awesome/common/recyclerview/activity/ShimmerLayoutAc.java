package com.v1ncent.awesome.common.recyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.ShimmerLayoutAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/8/9.
 */

public class ShimmerLayoutAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.facebook_shimmer)
    ShimmerFrameLayout facebookShimmer;
    @BindView(R.id.root_shimmer)
    ScrollView rootShimmer;

    private ShimmerLayoutAdapter shimmerLayoutAdapter, LayoutAdapter;
    private ShimmerLayoutAc mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer_layout);
        ButterKnife.bind(this);
        mContext = this;

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ShimmerLayout");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LayoutAdapter = new ShimmerLayoutAdapter(getData());
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                recyclerView.setAdapter(LayoutAdapter);
                recyclerView.setVisibility(View.VISIBLE);
                rootShimmer.setVisibility(View.GONE);
                facebookShimmer.setVisibility(View.GONE);
            }
        }, 3000);
    }

    private List<Movie> getData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
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
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
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
    public void onResume() {
        super.onResume();
        facebookShimmer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        facebookShimmer.stopShimmerAnimation();
        super.onPause();
    }

}
