package com.v1ncent.awesome.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.fenjuly.library.ArrowDownloadButton;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/5/17.
 */

public class ButtonAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btn_android)
    FancyButton btnAndroid;
    @BindView(R.id.btn_dropbox)
    FancyButton btnDropbox;
    @BindView(R.id.btn_facebook_like)
    FancyButton btnFacebookLike;
    @BindView(R.id.btn_facebook_share)
    FancyButton btnFacebookShare;
    @BindView(R.id.btn_facebook_follow)
    FancyButton btnFacebookFollow;
    @BindView(R.id.section_facebook)
    LinearLayout sectionFacebook;
    @BindView(R.id.btn_create_account)
    FancyButton btnCreateAccount;
    @BindView(R.id.btn_login)
    FancyButton btnLogin;
    @BindView(R.id.arrow_download_button)
    ArrowDownloadButton arrowDownloadButton;

    int count = 0;
    int progress = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("按钮");
    }

    @OnClick({R.id.arrow_download_button})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.arrow_download_button:
                if ((count % 2) == 0) {
                    arrowDownloadButton.startAnimating();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progress = progress + 1;
                                    arrowDownloadButton.setProgress(progress);
                                }
                            });
                        }
                    }, 800, 20);
                } else {
                    arrowDownloadButton.reset();
                }
                count++;
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
