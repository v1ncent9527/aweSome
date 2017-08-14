package com.v1ncent.awesome.common.viewpager.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.viewpager.fragment.TextFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/8/8.
 */

public class WeixinTabAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.alphaTabsIndicator)
    AlphaTabsIndicator alphaTabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_tab);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("仿微信Tab");

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mViewPager.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator.setViewPager(mViewPager);
        alphaTabsIndicator.getTabView(0).showNumber(6);
        alphaTabsIndicator.getTabView(1).showNumber(888);
        alphaTabsIndicator.getTabView(2).showNumber(88);
        alphaTabsIndicator.getTabView(3).showPoint();
    }

    @Override
    public void onClickListener(View v) {

    }

    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"微信", "通讯录", "发现", "我"};

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(TextFragment.newInstance(titles[0]));
            fragments.add(TextFragment.newInstance(titles[1]));
            fragments.add(TextFragment.newInstance(titles[2]));
            fragments.add(TextFragment.newInstance(titles[3]));
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (0 == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (2 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (3 == position) {
                alphaTabsIndicator.removeAllBadge();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
