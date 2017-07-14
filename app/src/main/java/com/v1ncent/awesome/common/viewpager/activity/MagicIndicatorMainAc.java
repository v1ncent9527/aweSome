package com.v1ncent.awesome.common.viewpager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/7/11.
 */

public class MagicIndicatorMainAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.scrollable_tab)
    Button scrollableTab;
    @BindView(R.id.fixed_tab)
    Button fixedTab;
    @BindView(R.id.dynamic_tab)
    Button dynamicTab;
    @BindView(R.id.no_tab_only_indicator)
    Button noTabOnlyIndicator;
    @BindView(R.id.work_with_fragment_container)
    Button workWithFragmentContainer;
    @BindView(R.id.tab_with_badge_view)
    Button tabWithBadgeView;
    @BindView(R.id.load_custom_layout)
    Button loadCustomLayout;
    @BindView(R.id.custom_navigator)
    Button customNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_indication);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MagicIndicator");
    }

    @Override
    public void onClickListener(View v) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scrollable_tab:
                startActivity(new Intent(this, ScrollableTabExampleAc.class));
                break;
            case R.id.fixed_tab:
                startActivity(new Intent(this, FixedTabExampleAc.class));
                break;
            case R.id.dynamic_tab:
                startActivity(new Intent(this, DynamicTabExampleAc.class));
                break;
            case R.id.no_tab_only_indicator:
                startActivity(new Intent(this, NoTabOnlyIndicatorExampleAc.class));
                break;
            case R.id.tab_with_badge_view:
                startActivity(new Intent(this, BadgeTabExampleAc.class));
                break;
            case R.id.work_with_fragment_container:
                startActivity(new Intent(this, FragmentContainerExampleAc.class));
                break;
            case R.id.load_custom_layout:
                startActivity(new Intent(this, LoadCustomLayoutExampleAc.class));
                break;
            case R.id.custom_navigator:
                startActivity(new Intent(this, CustomNavigatorExampleAc.class));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


}
