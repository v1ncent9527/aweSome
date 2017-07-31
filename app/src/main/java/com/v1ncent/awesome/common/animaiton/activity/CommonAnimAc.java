package com.v1ncent.awesome.common.animaiton.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.github.hujiaweibujidao.wava.Techniques;
import com.github.hujiaweibujidao.wava.YoYo;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.animaiton.adapter.CommonAnimAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/7/31.
 */

public class CommonAnimAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.test_img)
    ImageView testImg;
    @BindView(R.id.wrapper)
    LinearLayout wrapper;
    @BindView(R.id.list)
    ListView list;

    private YoYo.YoYoString rope;
    private CommonAnimAdapter commonAnimAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_anim);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CommonAnim");

        commonAnimAdapter = new CommonAnimAdapter(this);
        list.setAdapter(commonAnimAdapter);

        rope = YoYo.with(Techniques.FadeIn).duration(1000).playOn(testImg);// after start,just click mTarget view, rope is not init
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Techniques technique = (Techniques) view.getTag();
                rope = YoYo.with(technique).duration(1200)
                        .interpolate(new AccelerateDecelerateInterpolator())
                        .listen(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationCancel(Animator animation) {
                                showToast("canceled");
                            }
                        })
                        .playOn(testImg);
            }
        });
    }

    @OnClick(R.id.test_img)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.test_img:
                if (rope != null) {
                    rope.stop(true);
                }
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
