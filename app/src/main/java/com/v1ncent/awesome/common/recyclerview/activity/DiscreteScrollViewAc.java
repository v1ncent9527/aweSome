package com.v1ncent.awesome.common.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.recyclerview.adapter.DiscreteScrollViewAdapter;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/7/18.
 */

public class DiscreteScrollViewAc extends BaseActivity implements DiscreteScrollView.OnItemChangedListener
        , DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.item_name)
    TextView itemName;
    @BindView(R.id.item_price)
    TextView itemPrice;
    @BindView(R.id.item_picker)
    DiscreteScrollView itemPicker;
    @BindView(R.id.item_btn_comment)
    ImageView itemBtnComment;
    @BindView(R.id.item_btn_buy)
    FloatingActionButton itemBtnBuy;
    @BindView(R.id.item_btn_rate)
    ImageView itemBtnRate;
    @BindView(R.id.item_duration)
    DiscreteSeekBar itemDuration;

    private DiscreteScrollViewAc context;
    private InfiniteScrollAdapter infiniteAdapter;
    private List<Movie> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discrete_scrollview);
        ButterKnife.bind(this);
        context = this;
        getData();
        Logger.i(mData.get(mData.size() - 1).toString());

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DiscreteScrollView");

        itemPicker.setOrientation(Orientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);

        infiniteAdapter = InfiniteScrollAdapter.wrap(new DiscreteScrollViewAdapter(mData));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(300);
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(mData.get(0));
        itemDuration.setOnProgressChangeListener(this);
    }

    private void onItemChanged(Movie item) {
        itemName.setText(item.getName());
        itemPrice.setText("$" + item.getPrice());
    }

    @Override
    public void onClickListener(View v) {

    }

    private void getData() {
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            String name = null;
            switch (i % 3) {
                case 0:
                    name = "变形金刚";
                    break;
                case 1:
                    name = "流感";
                    break;
                case 2:
                    name = "釜山行";
                    break;
            }
            int price = random.nextInt(10) + 40;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            mData.add(movie);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(mData.get(positionInDataSet));
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        itemPicker.setItemTransitionTimeMillis(seekBar.getProgress());
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
