package com.v1ncent.awesome.common.customview.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceBottomEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceLeftEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceRightEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceRightExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceTopEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideEnter.SlideTopEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideExit.SlideBottomExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideExit.SlideLeftExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideExit.SlideTopExit;
import com.v1ncent.awesome.widget.custom_dialog.popup.BubblePopup;
import com.v1ncent.awesome.widget.custom_dialog.popup.base.BaseBubblePopup;
import com.v1ncent.awesome.widget.custom_dialog.popup.base.BasePopup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by v1ncent on 2017/8/2.
 */

public class PopupAc extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.popup_1)
    TextView popup1;
    @BindView(R.id.popup_2)
    TextView popup2;
    @BindView(R.id.popup_3)
    TextView popup3;
    @BindView(R.id.popup_4)
    TextView popup4;
    @BindView(R.id.popup_5)
    TextView popup5;
    @BindView(R.id.popup_6)
    TextView popup6;
    @BindView(R.id.popup_7)
    TextView popup7;
    @BindView(R.id.popup_8)
    TextView popup8;
    @BindView(R.id.popup_9)
    TextView popup9;
    @BindView(R.id.popup_10)
    TextView popup10;

    private PopupAc mContext;
    private SimpleCustomPop mQuickCustomPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);
        mContext = this;
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Popup");

        mQuickCustomPopup = new SimpleCustomPop(mContext);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.popup_1, R.id.popup_2, R.id.popup_3, R.id.popup_4, R.id.popup_5
            , R.id.popup_6, R.id.popup_7, R.id.popup_8, R.id.popup_9, R.id.popup_10})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.popup_1:
                mQuickCustomPopup
                        .alignCenter(true)
                        .anchorView(popup1)
                        .gravity(Gravity.BOTTOM)
                        .showAnim(new SlideTopEnter())
                        .dismissAnim(new SlideTopExit())
                        .offset(0, 0)
                        .dimEnabled(false)
                        .show();
                break;
            case R.id.popup_2:
                mQuickCustomPopup
                        .anchorView(popup2)
                        .gravity(Gravity.BOTTOM)
                        .offset(0, 0)
                        .showAnim(new BounceTopEnter())
                        .dismissAnim(new SlideTopExit())
                        .dimEnabled(false)
                        .show();
                break;
            case R.id.popup_3:
                mQuickCustomPopup
                        .anchorView(popup3)
                        .offset(-10, 5)
                        .gravity(Gravity.BOTTOM)
                        .showAnim(new BounceTopEnter())
                        .dismissAnim(new SlideTopExit())
                        .dimEnabled(false)
                        .show();
                break;
            case R.id.popup_4:
                mQuickCustomPopup
                        .anchorView(popup4)
                        .offset(10, -5)
                        .gravity(Gravity.TOP)
                        .showAnim(new BounceBottomEnter())
                        .dismissAnim(new SlideBottomExit())
                        .dimEnabled(true)
                        .show();
                break;
            case R.id.popup_5:
                mQuickCustomPopup
                        .showAnim(null)
                        .dismissAnim(null)
                        .dimEnabled(true)
                        .anchorView(popup5)
                        .offset(-10, -5)
                        .dimEnabled(false)
                        .gravity(Gravity.TOP)
                        .show();
                break;
            case R.id.popup_6:
                View inflate = View.inflate(mContext, R.layout.popup_bubble_text, null);
                TextView tv = ButterKnife.findById(inflate, R.id.tv_bubble);
                final BubblePopup bubblePopup = new BubblePopup(mContext, inflate);
                tv.setText("最美的不是下雨天,是曾与你躲过雨的屋檐~");
                bubblePopup.anchorView(popup6)
                        .gravity(Gravity.BOTTOM)
                        .show();

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("最美的不是下雨天,是曾与你躲过雨的屋檐~");
                        bubblePopup.dismiss();
                    }
                });
                break;
            case R.id.popup_7:
                CustomBubblePopup customBubblePopup = new CustomBubblePopup(mContext);
//        customBubblePopup.setCanceledOnTouchOutside(false);
                customBubblePopup
                        .gravity(Gravity.BOTTOM)
                        .anchorView(popup7)
                        .triangleWidth(20)
                        .triangleHeight(10)
                        .showAnim(null)
                        .dismissAnim(null)
                        .show();
                break;
            case R.id.popup_8:
                View popup_8 = View.inflate(mContext, R.layout.popup_bubble_image, null);
                BubblePopup bubblePopup_popup_8 = new BubblePopup(mContext, popup_8);
                bubblePopup_popup_8.anchorView(popup8)
                        .showAnim(new BounceRightEnter())
                        .dismissAnim(new SlideLeftExit())
                        .autoDismiss(true)
                        .show();
                break;
            case R.id.popup_9:
                View popup_9 = View.inflate(mContext, R.layout.popup_bubble_text, null);
                new BubblePopup(mContext, popup_9)
                        .anchorView(popup9)
                        .showAnim(null)
                        .dismissAnim(null)
                        .show();
                break;
            case R.id.popup_10:
                View popup_10 = View.inflate(mContext, R.layout.popup_bubble_image, null);
                new BubblePopup(mContext, popup_10).anchorView(popup10)
                        .bubbleColor(ContextCompat.getColor(mContext, R.color.colorAccent))
                        .showAnim(new BounceLeftEnter())
                        .dismissAnim(new BounceRightExit())
                        .show();
                break;
        }
    }

    class SimpleCustomPop extends BasePopup<SimpleCustomPop> {

        @BindView(R.id.tv_item_1)
        TextView mTvItem1;
        @BindView(R.id.tv_item_2)
        TextView mTvItem2;
        @BindView(R.id.tv_item_3)
        TextView mTvItem3;
        @BindView(R.id.tv_item_4)
        TextView mTvItem4;

        public SimpleCustomPop(Context context) {
            super(context);
//            setCanceledOnTouchOutside(false);
        }

        @Override
        public View onCreatePopupView() {
            View inflate = View.inflate(mContext, R.layout.popup_custom, null);
            ButterKnife.bind(this, inflate);
            return inflate;
        }

        @Override
        public void setUiBeforShow() {
            mTvItem1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast((String) mTvItem1.getText());
                }
            });
            mTvItem2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast((String) mTvItem2.getText());
                }
            });
            mTvItem3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast((String) mTvItem3.getText());
                }
            });
            mTvItem4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast((String) mTvItem4.getText());
                }
            });
        }
    }

    class CustomBubblePopup extends BaseBubblePopup<CustomBubblePopup> {

        TextView tvZan;
        TextView tvCommit;

        public CustomBubblePopup(Context context) {
            super(context);
        }

        @Override
        public View onCreateBubbleView() {
            View inflate = View.inflate(mContext, R.layout.popup_bubble_image, null);
            tvZan = (TextView) inflate.findViewById(R.id.tv_zan);
            tvCommit = (TextView) inflate.findViewById(R.id.tv_commit);

            return inflate;
        }

        @Override
        public void setUiBeforShow() {
            super.setUiBeforShow();

            tvZan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast("点赞");
                }
            });
            tvCommit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast("评论");
                }
            });
        }
    }
}
