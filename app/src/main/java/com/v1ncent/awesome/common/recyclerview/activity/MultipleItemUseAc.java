package com.v1ncent.awesome.common.recyclerview.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.MultipleItemAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.CommonAdapterVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by v1ncent on 2017/6/12.
 */

public class MultipleItemUseAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;
    private static final String CYM_CHAD = "CymChad";

    private MultipleItemAdapter multipleItemAdapter;
    private List<CommonAdapterVO> commonAdapterVOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleitem);
        ButterKnife.bind(this);
        initDate();
        initView();

    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CommonAdapterVOUse");

        multipleItemAdapter = new MultipleItemAdapter(this, commonAdapterVOList);
//        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mRecyclerView.setAdapter(multipleItemAdapter);

    }

    private void initDate() {
        commonAdapterVOList = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            commonAdapterVOList.add(new CommonAdapterVO(CommonAdapterVO.IMG, CommonAdapterVO.IMG_SPAN_SIZE));
            commonAdapterVOList.add(new CommonAdapterVO(CommonAdapterVO.TEXT, CommonAdapterVO.TEXT_SPAN_SIZE, "第" + i + "个Text"));
            commonAdapterVOList.add(new CommonAdapterVO(CommonAdapterVO.IMG_TEXT, CommonAdapterVO.IMG_TEXT_SPAN_SIZE));
            commonAdapterVOList.add(new CommonAdapterVO(CommonAdapterVO.IMG_TEXT, CommonAdapterVO.IMG_TEXT_SPAN_SIZE_MIN));
            commonAdapterVOList.add(new CommonAdapterVO(CommonAdapterVO.IMG_TEXT, CommonAdapterVO.IMG_TEXT_SPAN_SIZE_MIN));
        }
    }

    @Override
    public void onClickListener(View v) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
