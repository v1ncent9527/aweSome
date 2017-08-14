package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyydjk.com.library.CouponView;

/**
 * Created by v1ncent on 2017/8/9.
 */

public class CouponViewAc extends BaseActivity implements DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.couponView)
    CouponView mCouponView;
    @BindView(R.id.semicircle_top)
    CheckBox semicircleTop;
    @BindView(R.id.semicircle_bottom)
    CheckBox semicircleBottom;
    @BindView(R.id.semicircle_left)
    CheckBox semicircleLeft;
    @BindView(R.id.semicircle_right)
    CheckBox semicircleRight;
    @BindView(R.id.dash_line_top)
    CheckBox dashLineTop;
    @BindView(R.id.dash_line_bottom)
    CheckBox dashLineBottom;
    @BindView(R.id.dash_line_left)
    CheckBox dashLineLeft;
    @BindView(R.id.dash_line_right)
    CheckBox dashLineRight;
    @BindView(R.id.sbSemicircleRadius)
    DiscreteSeekBar sbSemicircleRadius;
    @BindView(R.id.sbSemicircleCap)
    DiscreteSeekBar sbSemicircleCap;
    @BindView(R.id.sbDashLineLength)
    DiscreteSeekBar sbDashLineLength;
    @BindView(R.id.sbDashLineGap)
    DiscreteSeekBar sbDashLineGap;
    @BindView(R.id.sbDashLineHeight)
    DiscreteSeekBar sbDashLineHeight;
    @BindView(R.id.sbTopDashLineMargin)
    DiscreteSeekBar sbTopDashLineMargin;
    @BindView(R.id.sbBottomDashLineMargin)
    DiscreteSeekBar sbBottomDashLineMargin;
    @BindView(R.id.sbLeftDashLineMargin)
    DiscreteSeekBar sbLeftDashLineMargin;
    @BindView(R.id.sbRightDashLineMargin)
    DiscreteSeekBar sbRightDashLineMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_view);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CouponView");

        semicircleTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setSemicircleTop(isChecked);
            }
        });
        semicircleBottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setSemicircleBottom(isChecked);
            }
        });
        semicircleLeft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setSemicircleLeft(isChecked);
            }
        });
        semicircleRight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setSemicircleRight(isChecked);
            }
        });

        dashLineTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setDashLineTop(isChecked);
            }
        });
        dashLineBottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setDashLineBottom(isChecked);
            }
        });
        dashLineLeft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setDashLineLeft(isChecked);
            }
        });
        dashLineRight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCouponView.setDashLineRight(isChecked);
            }
        });

        sbSemicircleRadius.setOnProgressChangeListener(this);
        sbSemicircleCap.setOnProgressChangeListener(this);
        sbDashLineLength.setOnProgressChangeListener(this);
        sbDashLineGap.setOnProgressChangeListener(this);
        sbDashLineHeight.setOnProgressChangeListener(this);
        sbTopDashLineMargin.setOnProgressChangeListener(this);
        sbBottomDashLineMargin.setOnProgressChangeListener(this);
        sbLeftDashLineMargin.setOnProgressChangeListener(this);
        sbRightDashLineMargin.setOnProgressChangeListener(this);

        sbSemicircleRadius.setProgress((int) mCouponView.getSemicircleRadius());
        sbSemicircleCap.setProgress((int) mCouponView.getSemicircleGap());
        sbDashLineLength.setProgress((int) mCouponView.getDashLineLength());
        sbDashLineGap.setProgress((int) mCouponView.getDashLineGap());
        sbDashLineHeight.setProgress((int) mCouponView.getDashLineHeight() * 10);
        sbTopDashLineMargin.setProgress((int) mCouponView.getDashLineMarginTop());
        sbBottomDashLineMargin.setProgress((int) mCouponView.getDashLineMarginBottom());
        sbLeftDashLineMargin.setProgress((int) mCouponView.getDashLineMarginLeft());
        sbRightDashLineMargin.setProgress((int) mCouponView.getDashLineMarginRight());

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
    public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sbSemicircleRadius:
                mCouponView.setSemicircleRadius(dp2Px(progress));
                break;
            case R.id.sbSemicircleCap:
                mCouponView.setSemicircleGap(dp2Px(progress));
                break;
            case R.id.sbDashLineLength:
                mCouponView.setDashLineLength(dp2Px(progress));
                break;
            case R.id.sbDashLineGap:
                mCouponView.setDashLineGap(dp2Px(progress));
                break;
            case R.id.sbDashLineHeight:
                mCouponView.setDashLineHeight(dp2Px(progress) / 10);
                break;
            case R.id.sbTopDashLineMargin:
                mCouponView.setDashLineMarginTop(dp2Px(progress));
                break;
            case R.id.sbBottomDashLineMargin:
                mCouponView.setDashLineMarginBottom(dp2Px(progress));
                break;
            case R.id.sbLeftDashLineMargin:
                mCouponView.setDashLineMarginLeft(dp2Px(progress));
                break;
            case R.id.sbRightDashLineMargin:
                mCouponView.setDashLineMarginRight(dp2Px(progress));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }

    private int dp2Px(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
