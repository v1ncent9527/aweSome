package com.v1ncent.awesome.common.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.adapter.AnimationAdapter;
import com.v1ncent.awesome.common.animation.CustomAnimation;
import com.v1ncent.awesome.common.pojo.CommonAdapterVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/6/8.
 */

public class AnimationUseAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    private Context context;
    private List<CommonAdapterVO> commonAdapterVOList;
    private AnimationAdapter animtionAdapter;
    private int mFirstPageItemCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_use);
        ButterKnife.bind(this);
        context = this;

        initView();
        initDate();
        initAdapter();
    }


    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("AnimationUse(->选取样式)");
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDate() {
        commonAdapterVOList = new ArrayList<>();
        for (int i = 0; i < 66; i++) {
            CommonAdapterVO commonAdapterVO = new CommonAdapterVO("banner" + i, "text\ntext" + i);
            commonAdapterVOList.add(commonAdapterVO);
        }
    }

    private void initAdapter() {
        animtionAdapter = new AnimationAdapter(R.layout.item_layout_animation, commonAdapterVOList);
        animtionAdapter.openLoadAnimation();
        animtionAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        animtionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CommonAdapterVO status = (CommonAdapterVO) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.img:
                        showToast("我是图片" + position);
                        break;
                    case R.id.banner_title:
                        showToast(status.getTitle());
                        break;
                    case R.id.banner_text:
                        showToast(status.getContent());
                        break;

                }
            }
        });
        animtionAdapter.isFirstOnly(false);
        mRecyclerView.setAdapter(animtionAdapter);

    }

    @Override
    public void onClickListener(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.AlphaIn:
                animtionAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            case R.id.ScaleIn:
                animtionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            case R.id.SlideInBottom:
                animtionAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            case R.id.SlideInLeft:
                animtionAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            case R.id.SlideInRight:
                animtionAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            case R.id.Custom:
                animtionAdapter.openLoadAnimation(new CustomAnimation());
                mRecyclerView.setAdapter(animtionAdapter);
                break;
            default:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_anim, menu);
        return true;
    }

}
