package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.view.VerificationCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/25.
 */

public class VerificationCodeAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.verification_1)
    VerificationCodeView verification1;
    @BindView(R.id.submit_1)
    FancyButton submit1;
    @BindView(R.id.verification_2)
    VerificationCodeView verification2;
    @BindView(R.id.net_pregressbar)
    ProgressBar netPregressbar;
    @BindView(R.id.submit_2)
    FancyButton submit2;
    @BindView(R.id.verification_3)
    VerificationCodeView verification3;
    @BindView(R.id.net_frame)
    FrameLayout netFrame;
    @BindView(R.id.et_1)
    EditText et1;
    @BindView(R.id.et_2)
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("VerificationCode");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                netPregressbar.setVisibility(View.GONE);
                verification2.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    @OnClick({R.id.submit_1, R.id.submit_2, R.id.verification_1
            , R.id.verification_2, R.id.verification_3})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.submit_1:
                String str = et1.getText().toString().trim().toLowerCase();
                String code = verification1.getvCode().toLowerCase();
                if (!TextUtils.isEmpty(str) && str.equals(code)) {
                    showToast("验证成功！");
                } else {
                    showToast("验证失败！");
                }
                break;
            case R.id.submit_2:
                String str_2 = et2.getText().toString().trim().toLowerCase();
                String code_2 = verification2.getvCode().toLowerCase();
                if (!TextUtils.isEmpty(str_2) && str_2.equals(code_2)) {
                    showToast("验证成功！");
                } else {
                    showToast("验证失败！");
                }
                break;
            case R.id.verification_1:
                et1.setText("");
                verification1.refreshCode();
                break;
            case R.id.verification_2:
                et2.setText("");
                verification2.setVisibility(View.GONE);
                netPregressbar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        verification2.refreshCode();
                        verification2.setVisibility(View.VISIBLE);
                        netPregressbar.setVisibility(View.GONE);
                    }
                }, 1000);
                break;
            case R.id.verification_3:
                verification3.refreshCode();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
