package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;

/**
 * Created by v1ncent on 2017/8/3.
 */

public class ExplosionFieldAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.img_4)
    ImageView img4;
    @BindView(R.id.img_5)
    ImageView img5;
    @BindView(R.id.img_6)
    ImageView img6;
    @BindView(R.id.btn)
    Button btn;

    private ExplosionField mExplosionField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explosion_field);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CountdownView");

        mExplosionField = ExplosionField.attach2Window(this);

    }

    @OnClick({R.id.img_1, R.id.img_2, R.id.img_3, R.id.img_4, R.id.img_5, R.id.img_6, R.id.btn})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.img_1:
                mExplosionField.explode(img1);
                break;
            case R.id.img_2:
                mExplosionField.explode(img2);
                break;
            case R.id.img_3:
                mExplosionField.explode(img3);
                break;
            case R.id.img_4:
                mExplosionField.explode(img4);
                break;
            case R.id.img_5:
                mExplosionField.explode(img5);
                break;
            case R.id.img_6:
                mExplosionField.explode(img6);
                break;
            case R.id.btn:
                mExplosionField.explode(btn);
                break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
