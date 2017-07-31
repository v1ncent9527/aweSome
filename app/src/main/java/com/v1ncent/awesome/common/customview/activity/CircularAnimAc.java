package com.v1ncent.awesome.common.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.view.CircularAnim;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/7/14.
 */

public class CircularAnimAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.activity_image_btn)
    Button activityImageBtn;
    @BindView(R.id.activity_color_btn)
    Button activityColorBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.change_btn)
    Button changeBtn;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.change_btn2)
    Button changeBtn2;
    @BindView(R.id.content_layout)
    LinearLayout contentLayout;
    @BindView(R.id.logoBtn_iv)
    ImageView logoBtnIv;

    private CircularAnimAc mContext;
    boolean isContentVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_anim);
        ButterKnife.bind(this);
        mContext = this;

        initVew();
    }

    private void initVew() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CircularAnim");
    }

    @OnClick({R.id.progressBar, R.id.activity_image_btn, R.id.activity_color_btn,
            R.id.change_btn, R.id.change_btn2, R.id.logoBtn_iv})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.progressBar:
                progressBar.setVisibility(View.GONE);
                // 伸展按钮
                CircularAnim.show(changeBtn).go();
                break;
            case R.id.activity_image_btn:
                // 先将图片展出铺满，然后启动新的Activity
                CircularAnim.fullActivity(mContext, v)
                        .colorOrImageRes(R.mipmap.lg)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(mContext, ListActivity.class));
                            }
                        });
                break;
            case R.id.activity_color_btn:
                // 先将颜色展出铺满，然后启动新的Activity
                CircularAnim.fullActivity(mContext, v)
//                        .colorOrImageRes(R.color.colorPrimary)  //注释掉，因为该颜色已经在App.class 里配置为默认色
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(mContext, ListActivity.class));
                            }
                        });
                break;
            case R.id.change_btn:
                progressBar.setVisibility(View.VISIBLE);
                // 收缩按钮
                CircularAnim.hide(changeBtn).go();
                break;
            case R.id.change_btn2:
                CircularAnim.hide(changeBtn2)
                        .endRadius(progressBar2.getHeight() / 2)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                progressBar2.setVisibility(View.VISIBLE);
                                progressBar2.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CircularAnim.fullActivity(mContext, progressBar2)
                                                .go(new CircularAnim.OnAnimationEndListener() {
                                                    @Override
                                                    public void onAnimationEnd() {
                                                        startActivity(new Intent(mContext, ListActivity.class));
                                                        finish();
                                                    }
                                                });
                                    }
                                }, 3000);
                            }
                        });
                break;
            case R.id.logoBtn_iv:
                v.animate().rotationBy(45);
                // 以 @mLogoBtnIv 为中心，收缩或伸展 @mContentLayout
                if (isContentVisible)
                    CircularAnim.hide(contentLayout).triggerView(logoBtnIv).go();
                else
                    CircularAnim.show(contentLayout).triggerView(logoBtnIv).go();

                isContentVisible = !isContentVisible;
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
