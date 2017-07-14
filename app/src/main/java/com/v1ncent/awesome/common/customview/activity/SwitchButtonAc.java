package com.v1ncent.awesome.common.customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.github.zagum.switchicon.SwitchIconView;
import com.sevenheaven.iosswitch.ShSwitchView;
import com.suke.widget.SwitchButton;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/5/17.
 */

public class SwitchButtonAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.SwitchButton_1)
    SwitchButton SwitchButton1;
    @BindView(R.id.SwitchIconView1)
    SwitchIconView SwitchIconView1;
    @BindView(R.id.SwitchIconView2)
    SwitchIconView SwitchIconView2;
    @BindView(R.id.SwitchIconView3)
    SwitchIconView SwitchIconView3;
    @BindView(R.id.switch_view)
    ShSwitchView switchView;
    @BindView(R.id.switch_view2)
    ShSwitchView switchView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchbutton);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SwitchButton");

        SwitchButton1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                showToast(isChecked ? "open" : "close");
            }
        });

        switchView.setOnSwitchStateChangeListener(new ShSwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                showToast(isOn ? "open" : "close");
            }
        });

        switchView2.setOn(true);
    }

    @OnClick({R.id.SwitchIconView1, R.id.SwitchIconView2, R.id.SwitchIconView3})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.SwitchIconView1:
                SwitchIconView1.switchState();
                break;
            case R.id.SwitchIconView2:
                SwitchIconView2.switchState();
                break;
            case R.id.SwitchIconView3:
                SwitchIconView3.switchState();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
