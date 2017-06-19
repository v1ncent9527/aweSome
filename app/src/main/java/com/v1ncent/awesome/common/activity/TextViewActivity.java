package com.v1ncent.awesome.common.activity;

/**
 * Created by v1ncent on 2017/5/15.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.robinhood.ticker.TickerUtils;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/5/15.
 */

public class TextViewActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.TickerView)
    com.robinhood.ticker.TickerView TickerView;
    private static final char[] NUMBER_LIST = TickerUtils.getDefaultNumberList();
    @BindView(R.id.RevealTextView)
    com.v1ncent.awesome.ui.textview.RevealTextView RevealTextView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.expandable_text)
    TextView expandableText;
    @BindView(R.id.expand_collapse)
    ImageButton expandCollapse;
    @BindView(R.id.expand_text_view)
    ExpandableTextView expandTextView;
    @BindView(R.id.super_tv)
    SuperTextView superTv;
    @BindView(R.id.LinkBuilder)
    TextView LinkBuilderTV;
    @BindView(R.id.SuperTextView)
    TextView SuperTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_facebook);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TextView");

        TickerView.setCharacterList(NUMBER_LIST);
        TickerView.setText("$1234.234");

        title.setText("title");
        expandTextView.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                showToast(isExpanded ? "open" : "close");
            }
        });
        expandTextView.setText(getString(R.string.dummy_text2));

        Link link = new Link("https://github.com/v1ncent9527")
                .setHighlightAlpha(.4f)                                     // optional, defaults to .15f
                .setUnderlined(true)                                       // optional, defaults to true
                .setBold(true)                                              // optional, defaults to false
                .setOnLongClickListener(new Link.OnLongClickListener() {
                    @Override
                    public void onLongClick(String clickedText) {
                        showToast("long click!");
                    }
                })
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/v1ncent9527"));
                        startActivity(browserIntent);
                    }
                });
        LinkBuilder.on(LinkBuilderTV)
                .addLink(link)
                .build(); // create the clickable links

    }

    @OnClick({R.id.TickerView, R.id.SuperTextView})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.TickerView:
                String currencyFloat = Float.toString((new Random(System.currentTimeMillis()).nextFloat() * 100));
                TickerView.setText("$" + currencyFloat);
                break;
            case R.id.SuperTextView:
                mSwipeBackHelper.forward(SuperTextViewAc.class);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}

