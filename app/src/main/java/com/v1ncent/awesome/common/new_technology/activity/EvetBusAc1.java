package com.v1ncent.awesome.common.new_technology.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.new_technology.pojo.GirlFriend;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/10.
 */

public class EvetBusAc1 extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btn_next)
    FancyButton btnNext;
    @BindView(R.id.obj)
    TextView obj;

    private static final String TAG = "EvetBusAc1";
    @BindView(R.id.women_img)
    ImageView womenImg;
    @BindView(R.id.price_total)
    TextView priceTotal;
    private EvetBusAc1 context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evetbus_1);
        ButterKnife.bind(this);
        context = this;
        //注册成为订阅者
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EventBus1");
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(GirlFriend girlFriend) {
        womenImg.setVisibility(View.VISIBLE);
        Logger.i(girlFriend.toString());
        obj.setText(girlFriend.toString());
    }

    @OnClick(R.id.btn_next)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(context, EvetBusAc2.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
    }
}
