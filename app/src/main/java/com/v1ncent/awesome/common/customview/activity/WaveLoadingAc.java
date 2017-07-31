package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/7/25.
 */

public class WaveLoadingAc extends BaseActivity implements CompoundButton.OnCheckedChangeListener, DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.img_mi)
    ImageView imgMi;
    @BindView(R.id.img_android)
    ImageView imgAndroid;
    @BindView(R.id.enable_indeterminate)
    AppCompatCheckBox enableIndeterminate;
    @BindView(R.id.level)
    DiscreteSeekBar level;
    @BindView(R.id.amplitude)
    DiscreteSeekBar amplitude;
    @BindView(R.id.length)
    DiscreteSeekBar length;
    @BindView(R.id.speed)
    DiscreteSeekBar speed;

    private WaveDrawable miWaveDrawable, androidWaveDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_loading);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("WaveLoading");

        miWaveDrawable = new WaveDrawable(this, R.mipmap.mi_ic);
        imgMi.setImageDrawable(miWaveDrawable);
        miWaveDrawable.setIndeterminate(true);

        androidWaveDrawable = new WaveDrawable(this, R.mipmap.lips_ic);
        imgAndroid.setImageDrawable(androidWaveDrawable);

        enableIndeterminate.setOnCheckedChangeListener(this);
        level.setOnProgressChangeListener(this);
        amplitude.setOnProgressChangeListener(this);
        length.setOnProgressChangeListener(this);
        speed.setOnProgressChangeListener(this);
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
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        switch (id) {
            case R.id.enable_indeterminate:
                setIndeterminateMode(compoundButton.isChecked());
                break;
        }
    }


    private void setIndeterminateMode(boolean indeterminate) {
        androidWaveDrawable.setIndeterminate(indeterminate);

        if (!indeterminate) {
            androidWaveDrawable.setLevel(level.getProgress());
        }
        androidWaveDrawable.setWaveAmplitude(amplitude.getProgress());
        androidWaveDrawable.setWaveLength(length.getProgress());
        androidWaveDrawable.setWaveSpeed(speed.getProgress());
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.level:
                androidWaveDrawable.setLevel(seekBar.getProgress());
                break;
            case R.id.amplitude:
                androidWaveDrawable.setWaveAmplitude(seekBar.getProgress());
                break;
            case R.id.length:
                androidWaveDrawable.setWaveAmplitude(seekBar.getProgress());
                break;
            case R.id.speed:
                androidWaveDrawable.setWaveSpeed(seekBar.getProgress());
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
