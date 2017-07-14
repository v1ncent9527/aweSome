package com.v1ncent.awesome.common.recyclerview.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.brioal.swipemenu.view.SwipeMenu;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by v1ncent on 2017/5/17.
 */

public class SwipeMenuAc extends BaseActivity {
    @BindView(R.id.rb_trans1)
    RadioButton rbTrans1;
    @BindView(R.id.rb_trans2)
    RadioButton rbTrans2;
    @BindView(R.id.rb_trans3)
    RadioButton rbTrans3;
    @BindView(R.id.menu_rg_trans)
    RadioGroup menuRgTrans;
    @BindView(R.id.menu_cb_scale)
    CheckBox menuCbScale;
    @BindView(R.id.menu_sb_scale)
    SeekBar menuSbScale;
    @BindView(R.id.menu_cb_alpha)
    CheckBox menuCbAlpha;
    @BindView(R.id.menu_sb_alpha)
    SeekBar menuSbAlpha;
    @BindView(R.id.rb_rotate1)
    RadioButton rbRotate1;
    @BindView(R.id.rb_rotate2)
    RadioButton rbRotate2;
    @BindView(R.id.rb_rotate3)
    RadioButton rbRotate3;
    @BindView(R.id.rb_rotate4)
    RadioButton rbRotate4;
    @BindView(R.id.rb_rotate5)
    RadioButton rbRotate5;
    @BindView(R.id.rb_rotate6)
    RadioButton rbRotate6;
    @BindView(R.id.menu_rg_rotate)
    RadioGroup menuRgRotate;
    @BindView(R.id.menu_Sb_rotate)
    SeekBar menuSbRotate;
    @BindView(R.id.main_btn_menu)
    ImageButton mainBtnMenu;
    @BindView(R.id.content_rb_blur)
    RadioButton contentRbBlur;
    @BindView(R.id.content_rb_changeblur)
    RadioButton contentRbChangeblur;
    @BindView(R.id.content_rb_reversechangeblur)
    RadioButton contentRbReversechangeblur;
    @BindView(R.id.content_rg_blur)
    RadioGroup contentRgBlur;
    @BindView(R.id.cb_pic)
    CheckBox cbPic;
    @BindView(R.id.content_recyclerView)
    RecyclerView contentRecyclerView;
    @BindView(R.id.main_swipemenu)
    SwipeMenu mainSwipemenu;
    private int mStyleCode = 11111; //风格代码
    private int mScaleProgress = 0; //起始缩放程度
    private int mAlphaProgress = 0; //起始透明程度
    private int mAngleProgress = 0; //起始3D旋转角度

    private int mTransCode = 1; //移动动画代码
    private int mScaleCode = 1; //缩放动画代码
    private int mAlphaCode = 1; //透明度动画代码
    private int mRotateCode = 1; //旋转动画代码

    private List<String> mTips;
    private Context mContext;
    private TipAdapter mTipAdapter;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_swipemenu);
        ButterKnife.bind(this);
        initTranslate();
        initScale();
        initAlpha();
        initRotate();
        initRecyclerView();
        mPreferences = getPreferences(Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        int isPic = mPreferences.getInt("Pic", 0);
        boolean isBlur = mPreferences.getBoolean("IsBlur", false);
        boolean isChangeBlur = mPreferences.getBoolean("IsChangeBlur", false);
        boolean isReverseChangeBlur = mPreferences.getBoolean("IsReverseChangeBlur", false);
        if (isPic == 0) {
            mainSwipemenu.setFullColor(SwipeMenuAc.this, R.color.primary);
        } else {
            cbPic.setChecked(true);
            if (isBlur) {
                contentRgBlur.check(R.id.content_rb_blur);
                mainSwipemenu.setBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary, 22f);
            } else if (isChangeBlur) {
                contentRgBlur.check(R.id.content_rb_changeblur);
                mainSwipemenu.setChangedBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary);
            } else if (isReverseChangeBlur) {
                contentRgBlur.check(R.id.content_rb_reversechangeblur);
                mainSwipemenu.setReverseChangedBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary);
            } else {

                contentRgBlur.check(-1);
                mainSwipemenu.setBackImage(SwipeMenuAc.this, R.mipmap.earth, R.color.primary);
            }
        }
        mainBtnMenu.setOnClickListener(this);
        cbPic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mEditor = mPreferences.edit();
                if (b) {
                    mEditor.putInt("Pic", 1);
                } else {
                    mEditor.putInt("Pic", 0);
                }
                mEditor.putBoolean("IsBlur", false);
                mEditor.putBoolean("IsChangeBlur", false);
                mEditor.putBoolean("IsReverseChangeBlur", false);
                mEditor.commit();
                Intent intent = new Intent(mContext, SwipeMenuAc.class);
                startActivity(intent);
                finish();
            }
        });
        contentRgBlur.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mEditor = mPreferences.edit();
                switch (i) {
                    case R.id.content_rb_blur:
                        mEditor.putBoolean("IsBlur", true);
                        mEditor.putBoolean("IsChangeBlur", false);
                        mEditor.putBoolean("IsReverseChangeBlur", false);
                        break;
                    case R.id.content_rb_changeblur:
                        mEditor.putBoolean("IsBlur", false);
                        mEditor.putBoolean("IsChangeBlur", true);
                        mEditor.putBoolean("IsReverseChangeBlur", true);
                        break;
                    case R.id.content_rb_reversechangeblur:
                        mEditor.putBoolean("IsBlur", false);
                        mEditor.putBoolean("IsChangeBlur", false);
                        mEditor.putBoolean("IsReverseChangeBlur", true);
                        break;
                }
                mEditor.putInt("Pic", 1);
                mEditor.commit();
                Intent intent = new Intent(mContext, SwipeMenuAc.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //初始化旋转动画
    private void initRotate() {
        menuRgRotate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_rotate1:
                        mRotateCode = 1;
                        break;
                    case R.id.rb_rotate2:
                        mRotateCode = 2;
                        break;
                    case R.id.rb_rotate3:
                        mRotateCode = 3;
                        break;
                    case R.id.rb_rotate4:
                        mRotateCode = 4;
                        break;
                    case R.id.rb_rotate5:
                        mRotateCode = 5;
                        break;
                    case R.id.rb_rotate6:
                        mRotateCode = 6;
                        break;
                }

                changeStyleCode();
            }
        });
        menuSbAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mAngleProgress = i;
                mainSwipemenu.setStart3DAngle((int) (i * 1.0f / 100 * 90));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //初始化提示列表
    private void initRecyclerView() {
        if (mTipAdapter == null) {
            mTips = new ArrayList<>();
            mTips.add("本侧滑菜单库使用非常简单");
            mTips.add("提供多达144种动画效果");
            mTips.add("顶部切换按钮提供图片沉浸与颜色沉浸两种模式");
            mTips.add("并且支持动态模糊");
            mTips.add("模糊程度与范围可自定义");
            mTips.add("此用例主要用于效果预览");
            mTips.add("其次是显示参数设置方法");
            mTips.add("再次是用表明已处理滑动事件冲突");
            mTips.add("根据左边可视化调整的效果");
            mTips.add("只要按照顶部显示的参数设置即可");
            mTips.add("建议中心旋转搭配透明度动画,否则会有明显卡顿");
            mTipAdapter = new TipAdapter();
            contentRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            contentRecyclerView.setAdapter(mTipAdapter);
        } else {
            mTipAdapter.notifyDataSetChanged();
        }
    }


    //初始化透明动画
    private void initAlpha() {
        menuCbAlpha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mAlphaCode = 2;
                } else {
                    mAlphaCode = 1;
                }
                changeStyleCode();
            }
        });
        menuSbAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mAlphaProgress = i;
                mainSwipemenu.setStartAlpha(i * 1.0f / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    //初始化缩放动画
    private void initScale() {
        menuCbScale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mScaleCode = 2;
                } else {
                    mScaleCode = 1;
                }
                changeStyleCode();
            }
        });
        menuSbScale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mScaleProgress = i;
                mainSwipemenu.setStartScale(i * 1.0f / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //初始化移动动画
    private void initTranslate() {
        menuRgRotate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_trans1:
                        mTransCode = 1;
                        break;
                    case R.id.rb_trans2:
                        mTransCode = 2;
                        break;
                    case R.id.rb_trans3:
                        mTransCode = 3;
                        break;
                }
                changeStyleCode();
            }
        });
    }

    //更新风格代码
    public void changeStyleCode() {
        mStyleCode = mTransCode * 1000 + mScaleCode * 100 + mAlphaCode * 10 + mRotateCode;
        Toast.makeText(mContext, mStyleCode + "", Toast.LENGTH_SHORT).show();
        mainSwipemenu.setStyleCode(mStyleCode);
        initRecyclerView();
    }

    @Override
    public void onBackPressed() {
        if (mainSwipemenu.isMenuShowing()) {
            mainSwipemenu.hideMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_menu:
                if (mainSwipemenu.isMenuShowing()) {
                    mainSwipemenu.hideMenu();
                } else {
                    mainSwipemenu.showMenu();
                }
                break;
        }
    }

    class TipAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new TipViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tip, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String context = "";
            if (position == 0) {
                StringBuilder builder = new StringBuilder();
                builder.append("setStyleCode(" + mStyleCode + ")\n");
                if (cbPic.isChecked()) {
                    builder.append("setBackImage(SwipeMenuAc.this, R.mipmap.earth, R.color.primary)\n");
                } else {
                    builder.append("setFullColor(SwipeMenuAc.this, R.color.primary\n");
                }
                if (menuCbScale.isChecked()) { //存在缩放
                    builder.append("setMinScale(" + (mScaleProgress * 1.0f / 100) + ")\n");
                }
                if (menuCbAlpha.isChecked()) { //存在透明度改变
                    builder.append("setStartAlpha(" + (mAlphaProgress * 1.0f / 100) + ")\n");
                }
                if (menuRgRotate.getCheckedRadioButtonId() == R.id.rb_rotate3) { //存在旋转动态
                    builder.append("setStart3DAngle(" + (mAngleProgress * 1.0f / 100) + ")");
                }
                if (cbPic.isChecked() && contentRgBlur.getCheckedRadioButtonId() == -1) { //
                    builder.append("setBackImage(SwipeMenuAc.this, R.mipmap.earth, R.color.primary)\n");
                }
                if (contentRgBlur.getCheckedRadioButtonId() == R.id.content_rb_blur) { //静态模糊
                    builder.append("setBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary, 22f)\n");
                }
                if (contentRgBlur.getCheckedRadioButtonId() == R.id.content_rb_changeblur) { //动态模糊
                    builder.append("setChangedBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary)\n");
                }
                if (contentRgBlur.getCheckedRadioButtonId() == R.id.content_rb_changeblur) { //动态模糊
                    builder.append("setReverseChangedBlur(SwipeMenuAc.this, R.mipmap.earth, R.color.primary)");
                }
                context = builder.toString();
            } else {
                context = mTips.get(position - 1);
            }
            ((TipViewHolder) holder).mTvContext.setText(context);
        }

        @Override
        public int getItemCount() {
            return mTips.size() + 1;
        }


    }


    //内容提示面板
    class TipViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tip_tv_content)
        TextView mTvContext;

        public TipViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onClickListener(View v) {

    }
}
