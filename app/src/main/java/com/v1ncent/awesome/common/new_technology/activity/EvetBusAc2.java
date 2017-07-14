package com.v1ncent.awesome.common.new_technology.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.new_technology.pojo.GirlFriend;

import org.greenrobot.eventbus.EventBus;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/10.
 */

public class EvetBusAc2 extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btn_up)
    FancyButton btnNext;
    @BindView(R.id.to_see)
    TextView toSee;

    private EvetBusAc2 context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evetbus_2);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EventBus2");
    }

    @OnClick(R.id.btn_up)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.btn_up:
                EventBus.getDefault().post(new GirlFriend("v1ncent", String.valueOf(new Random().nextInt(20)), "172cm", "Scorpio"));
                toSee.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

}
