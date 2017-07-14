package com.v1ncent.awesome.common.viewpager.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.viewpager.adapter.ExamplePagerAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/7/14.
 */

public class DynamicTabExampleAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.magic_indicator1)
    MagicIndicator magicIndicator1;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.random_page)
    Button randomPage;

    private static final String[] CHANNELS = new String[]{"推荐", "热点", "娱乐", "数码", "游戏", "科技", "视频", "问答", "健康", "段子", "汽车"};
    private List<String> mDataList = new ArrayList<>(Arrays.asList(CHANNELS));
    private ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList);
    private DynamicTabExampleAc context;
    private CommonNavigator mCommonNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_tab);
        ButterKnife.bind(this);
        context = this;

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DynamicTabExample");

        viewPager.setAdapter(mExamplePagerAdapter);

        initView();
    }

    private void initView() {
        magicIndicator1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        mCommonNavigator = new CommonNavigator(this);
        mCommonNavigator.setSkimOver(true);
        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(mDataList.get(index));
                clipPagerTitleView.setTextColor(ContextCompat.getColor(context, R.color.black_21));
                clipPagerTitleView.setClipColor(ContextCompat.getColor(context, R.color.red_tt));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator1.setNavigator(mCommonNavigator);
        ViewPagerHelper.bind(magicIndicator1, viewPager);
    }


    @OnClick(R.id.random_page)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.random_page:
                mDataList.clear();
                int total = new Random().nextInt(CHANNELS.length);
                for (int i = 0; i <= total; i++) {
                    mDataList.add(CHANNELS[i]);
                }

                mCommonNavigator.notifyDataSetChanged();    // must call firstly
                mExamplePagerAdapter.notifyDataSetChanged();

                showToast("" + mDataList.size() + " page");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
