package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.qiushui.blurredview.BlurredView;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/7/28.
 */

public class BlurredViewAc extends BaseActivity implements DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.blurred_view)
    BlurredView blurredView;
    @BindView(R.id.seek)
    DiscreteSeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blurred_view);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BlurredView");

        seek.setOnProgressChangeListener(this);
        // 可以在代码中使用setBlurredImg()方法指定需要模糊的图片
        blurredView.setBlurredImg(getResources().getDrawable(R.mipmap.eye_test));
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
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        blurredView.setBlurredLevel(value);
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
