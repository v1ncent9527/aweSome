package com.v1ncent.awesome.common.activity;

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
import com.v1ncent.awesome.common.adapter.SectionAdapter;
import com.v1ncent.awesome.common.pojo.MySection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/6/30.
 */

public class SectionUseAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    private SectionUseAc context;
    private List<MySection> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_use);
        ButterKnife.bind(this);
        context = this;

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SectionUse");
        mData = getSampleData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mData);
        sectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySection mySection = mData.get(position);
                if (mySection.isHeader)
                    showToast(mySection.header);
                else
                    showToast(mySection.t);
            }
        });
        sectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("onItemChildClick" + position);
            }
        });
        mRecyclerView.setAdapter(sectionAdapter);
    }

    @Override
    public void onClickListener(View v) {

    }

    public static List<MySection> getSampleData() {
        List<MySection> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new MySection(true, "2017/06/0" + i, true));

            for (int j = 0; j < 6; j++) {
                list.add(new MySection("￥" + j + "00.00"));
            }
        }
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
