package com.v1ncent.awesome.common.customview.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;
import com.rodolfonavalon.shaperipplelibrary.model.Circle;
import com.rodolfonavalon.shaperipplelibrary.model.Image;
import com.rodolfonavalon.shaperipplelibrary.model.Square;
import com.rodolfonavalon.shaperipplelibrary.model.Star;
import com.rodolfonavalon.shaperipplelibrary.model.Triangle;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/17.
 */

public class ShapeRippleAc extends BaseActivity implements CompoundButton.OnCheckedChangeListener, DiscreteSeekBar.OnProgressChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.ripple)
    ShapeRipple ripple;
    @BindView(R.id.enable_single_ripple)
    AppCompatCheckBox enableSingleRipple;
    @BindView(R.id.enable_stroke_ripple)
    AppCompatCheckBox enableStrokeRipple;
    @BindView(R.id.enable_color_transition)
    AppCompatCheckBox enableColorTransition;
    @BindView(R.id.enable_random_color)
    AppCompatCheckBox enableRandomColor;
    @BindView(R.id.enable_random_position)
    AppCompatCheckBox enableRandomPosition;
    @BindView(R.id.ripple_duration)
    DiscreteSeekBar rippleDuration;
    @BindView(R.id.ripple_count)
    DiscreteSeekBar rippleCount;
    @BindView(R.id.ripple_max_size)
    DiscreteSeekBar rippleMaxSize;
    @BindView(R.id.btn_select_color)
    FancyButton btnSelectColor;

    private ShapeRippleAc context;
    private int currentBackgroundColor = 0xffffffff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_ripple);
        ButterKnife.bind(this);
        context = this;

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ShapeRipple");

        ripple.setRippleShape(new Circle());

        rippleDuration.setOnProgressChangeListener(this);
        rippleCount.setOnProgressChangeListener(this);
        rippleMaxSize.setOnProgressChangeListener(this);
        enableColorTransition.setOnCheckedChangeListener(this);
        enableRandomColor.setOnCheckedChangeListener(this);
        enableRandomPosition.setOnCheckedChangeListener(this);
        enableSingleRipple.setOnCheckedChangeListener(this);
        enableStrokeRipple.setOnCheckedChangeListener(this);

        ripple.post(new Runnable() {
            @Override
            public void run() {
                rippleCount.setMax(ripple.getRippleCount() * 2);
                rippleCount.setProgress(ripple.getRippleCount());

                rippleMaxSize.setMax((int) ripple.getRippleMaximumRadius() * 3);
                rippleMaxSize.setProgress((int) ripple.getRippleMaximumRadius());
                rippleMaxSize.setMin((int) (ripple.getRippleMaximumRadius() * 0.25));
            }
        });
    }

    @OnClick(R.id.btn_select_color)
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.btn_select_color:
                ColorPickerDialogBuilder
                        .with(context)
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
                                ripple.setRippleColor(selectedColor);
                                ripple.setRippleFromColor(selectedColor);
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
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Circle:
                ripple.setRippleShape(new Circle());
                break;
            case R.id.Square:
                ripple.setRippleShape(new Square());
                break;
            case R.id.Triangle:
                ripple.setRippleShape(new Triangle());
                break;
            case R.id.Star:
                ripple.setRippleShape(new Star());
                break;
            case R.id.Image:
                ripple.setRippleShape(new Image(R.mipmap.wifi));
                break;
            default:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shape_ripple, menu);
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();

        switch (id) {
            case R.id.enable_color_transition:
                ripple.setEnableColorTransition(compoundButton.isChecked());
                showToast("1");
                break;
            case R.id.enable_single_ripple:
                ripple.setEnableSingleRipple(compoundButton.isChecked());
                break;
            case R.id.enable_random_position:
                ripple.setEnableRandomPosition(compoundButton.isChecked());
                break;
            case R.id.enable_random_color:
                ripple.setEnableRandomColor(compoundButton.isChecked());
                break;
            case R.id.enable_stroke_ripple:
                ripple.setEnableStrokeStyle(compoundButton.isChecked());
                break;
            default:

        }
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.ripple_duration:
                ripple.setRippleDuration(seekBar.getProgress());
                break;
            case R.id.ripple_count:
                ripple.setRippleCount(seekBar.getProgress());
                break;
            case R.id.ripple_max_size:
                ripple.setRippleMaximumRadius(seekBar.getProgress());
                break;
            default:

        }
    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
