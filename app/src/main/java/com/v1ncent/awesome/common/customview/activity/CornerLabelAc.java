package com.v1ncent.awesome.common.customview.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.github.czy1121.view.CornerLabelView;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/26.
 */

public class CornerLabelAc extends BaseActivity implements DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.corner_label_view)
    CornerLabelView cornerLabelView;
    @BindView(R.id.color_pick)
    FancyButton colorPick;
    @BindView(R.id.left_top)
    FancyButton leftTop;
    @BindView(R.id.left_bottom)
    FancyButton leftBottom;
    @BindView(R.id.right_top)
    FancyButton rightTop;
    @BindView(R.id.right_bottom)
    FancyButton rightBottom;
    @BindView(R.id.text_size)
    DiscreteSeekBar textSize;
    @BindView(R.id.height)
    DiscreteSeekBar height;
    @BindView(R.id.triangle)
    FancyButton triangle;
    @BindView(R.id.no_triangle)
    FancyButton noTriangle;

    private int currentBackgroundColor = 0xffffffff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corner_label);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CornerLabel");

        textSize.setOnProgressChangeListener(this);
        height.setOnProgressChangeListener(this);
    }

    @OnClick({R.id.color_pick, R.id.left_top, R.id.left_bottom,
            R.id.right_top, R.id.right_bottom, R.id.triangle, R.id.no_triangle})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.color_pick:
                ColorPickerDialogBuilder
                        .with(this)
                        .setTitle("请选择颜色")
                        .initialColor(currentBackgroundColor)
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                            }
                        })
                        .setPositiveButton("确认", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                cornerLabelView.setFillColor(selectedColor);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
                break;
            case R.id.left_top:
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) cornerLabelView.getLayoutParams();
                lp.gravity = Gravity.LEFT | Gravity.TOP;
                cornerLabelView.setLayoutParams(lp);
                break;
            case R.id.left_bottom:
                FrameLayout.LayoutParams lp2 = (FrameLayout.LayoutParams) cornerLabelView.getLayoutParams();
                lp2.gravity = Gravity.LEFT | Gravity.BOTTOM;
                cornerLabelView.setLayoutParams(lp2);
                break;
            case R.id.right_top:
                FrameLayout.LayoutParams lp3 = (FrameLayout.LayoutParams) cornerLabelView.getLayoutParams();
                lp3.gravity = Gravity.RIGHT | Gravity.TOP;
                cornerLabelView.setLayoutParams(lp3);
                break;
            case R.id.right_bottom:
                FrameLayout.LayoutParams lp4 = (FrameLayout.LayoutParams) cornerLabelView.getLayoutParams();
                lp4.gravity = Gravity.RIGHT | Gravity.BOTTOM;
                cornerLabelView.setLayoutParams(lp4);
                break;
            case R.id.triangle:
                cornerLabelView.triangle(true);
                break;
            case R.id.no_triangle:
                cornerLabelView.triangle(false);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.text_size:
                cornerLabelView.setText1Height(seekBar.getProgress());
                break;
            case R.id.height:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
