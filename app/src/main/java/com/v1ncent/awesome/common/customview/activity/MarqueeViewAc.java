package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gongwen.marqueen.MarqueeFactory;
import com.gongwen.marqueen.MarqueeView;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.NoticeMF;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/7/19.
 */

public class MarqueeViewAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;

    private final List<String> datas = Arrays.asList("平板打字太慢？带个套打字如飞", "处男测试仪，男人的噩梦", "4万砸出来的床，没想到..", "小米新手机发布会：5X");
    private MarqueeViewAc mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee_view);
        ButterKnife.bind(this);
        mContext = this;

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MarqueeView");

        MarqueeFactory<TextView, String> marqueeFactory4 = new NoticeMF(this);
        marqueeFactory4.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(MarqueeFactory.ViewHolder<TextView, String> holder) {
                showToast(holder.data);
            }
        });
        marqueeFactory4.setData(datas);
        marqueeView.setAnimInAndOut(R.anim.bottom_in, R.anim.top_out);
        marqueeView.setInterval(3000);
        marqueeView.setAnimDuration(600);
        marqueeView.setMarqueeFactory(marqueeFactory4);
        marqueeView.startFlipping();
    }

    @Override
    public void onClickListener(View v) {

    }

    @Override
    public void onStart() {
        super.onStart();
        marqueeView.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView.stopFlipping();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
