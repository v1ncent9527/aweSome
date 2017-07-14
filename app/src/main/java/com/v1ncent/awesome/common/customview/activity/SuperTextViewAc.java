package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.MoveEffectAdjuster;
import com.v1ncent.awesome.ui.textview.SuperTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.v1ncent.awesome.R.id.stv_17;
import static com.v1ncent.awesome.R.id.stv_18;
import static com.v1ncent.awesome.R.id.stv_19;
import static com.v1ncent.awesome.R.id.stv_20;
import static com.v1ncent.awesome.R.id.stv_21;

/**
 * Created by v1ncent on 2017/5/16.
 */

public class SuperTextViewAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.stv_0)
    SuperTextView stv0;
    @BindView(R.id.stv_2_1)
    SuperTextView stv_2_1;
    @BindView(R.id.stv_1)
    SuperTextView stv1;
    @BindView(R.id.stv_2)
    SuperTextView stv2;
    @BindView(R.id.stv_6)
    SuperTextView stv6;
    @BindView(R.id.stv_7)
    SuperTextView stv7;
    @BindView(R.id.stv_8)
    SuperTextView stv8;
    @BindView(R.id.stv_9)
    SuperTextView stv9;
    @BindView(R.id.stv_10)
    SuperTextView stv10;
    @BindView(R.id.stv_11)
    SuperTextView stv11;
    @BindView(R.id.stv_12)
    SuperTextView stv12;
    @BindView(R.id.stv_13)
    SuperTextView stv13;
    @BindView(R.id.stv_14)
    SuperTextView stv14;
    @BindView(R.id.stv_15)
    SuperTextView stv15;
    @BindView(R.id.stv_16)
    SuperTextView stv16;
    @BindView(R.id.stv_16_1)
    SuperTextView stv161;
    @BindView(stv_17)
    SuperTextView stv17;
    @BindView(stv_18)
    SuperTextView stv18;
    @BindView(stv_19)
    SuperTextView stv19;
    @BindView(stv_20)
    SuperTextView stv20;
    @BindView(stv_21)
    SuperTextView stv21;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_text_view);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SuperTextView");


        stv17.setAdjuster(new MoveEffectAdjuster())
                .setAutoAdjust(true)
                .startAnim();
        stv18.setAdjuster(new RippleAdjuster(getResources().getColor(R.color.opacity_3_white)));

        OpportunityDemoAdjuster opportunityDemoAdjuster1 = new OpportunityDemoAdjuster();
        opportunityDemoAdjuster1.setOpportunity(SuperTextView.Adjuster.Opportunity.BEFORE_DRAWABLE);
        stv19.setAdjuster(opportunityDemoAdjuster1);
        stv19.setAutoAdjust(true);

        OpportunityDemoAdjuster opportunityDemoAdjuster2 = new OpportunityDemoAdjuster();
        opportunityDemoAdjuster2.setOpportunity(SuperTextView.Adjuster.Opportunity.BEFORE_TEXT);
        stv20.setAdjuster(opportunityDemoAdjuster2);
        stv20.setAutoAdjust(true);

        OpportunityDemoAdjuster opportunityDemoAdjuster3 = new OpportunityDemoAdjuster();
        opportunityDemoAdjuster3.setOpportunity(SuperTextView.Adjuster.Opportunity.AT_LAST);
        stv21.setAdjuster(opportunityDemoAdjuster3);
        stv21.setAutoAdjust(true);
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
