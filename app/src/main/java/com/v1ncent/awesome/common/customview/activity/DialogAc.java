package com.v1ncent.awesome.common.customview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.adapter.TestAdapter;
import com.v1ncent.awesome.common.customview.extra.CustomBaseDialog;
import com.v1ncent.awesome.common.customview.extra.IOSTaoBaoDialog;
import com.v1ncent.awesome.common.customview.extra.ShareBottomDialog;
import com.v1ncent.awesome.common.customview.extra.ShareTopDialog;
import com.v1ncent.awesome.widget.custom_dialog.ActionSheetDialog;
import com.v1ncent.awesome.widget.custom_dialog.MaterialDialog;
import com.v1ncent.awesome.widget.custom_dialog.NormalDialog;
import com.v1ncent.awesome.widget.custom_dialog.NormalListDialog;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceLeftEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceRightExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter.BounceTopEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.FlipEnter.FlipInXAnimator;
import com.v1ncent.awesome.widget.custom_dialog.anim.FlipEnter.FlipInXExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideEnter.SlideLeftEnter;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideExit.SlideBottomExit;
import com.v1ncent.awesome.widget.custom_dialog.anim.SlideExit.SlideRightExit;
import com.v1ncent.awesome.widget.custom_dialog.entity.DialogMenuItem;
import com.v1ncent.awesome.widget.custom_dialog.listener.OnBtnClickL;
import com.v1ncent.awesome.widget.custom_dialog.listener.OnOperItemClickL;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/28.
 */

public class DialogAc extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.default_two_btns)
    FancyButton defaultTwoBtns;
    @BindView(R.id.style_two)
    FancyButton styleTwo;
    @BindView(R.id.custom_attr)
    FancyButton customAttr;
    @BindView(R.id.one_btn)
    FancyButton oneBtn;
    @BindView(R.id.thres_btns)
    FancyButton thresBtns;
    @BindView(R.id.md_two_btns)
    FancyButton mdTwoBtns;
    @BindView(R.id.md_one_btn)
    FancyButton mdOneBtn;
    @BindView(R.id.md_three_btns)
    FancyButton mdThreeBtns;
    @BindView(R.id.normal_list)
    FancyButton normalList;
    @BindView(R.id.list_custom_attr)
    FancyButton listCustomAttr;
    @BindView(R.id.list_no_title)
    FancyButton listNoTitle;
    @BindView(R.id.list_with_data)
    FancyButton listWithData;
    @BindView(R.id.list_with_adapter)
    FancyButton listWithAdapter;
    @BindView(R.id.action_sheet)
    FancyButton actionSheet;
    @BindView(R.id.action_sheet_no_title)
    FancyButton actionSheetNoTitle;
    @BindView(R.id.root)
    FrameLayout root;
    @BindView(R.id.cd_base_dialog)
    FancyButton cdBaseDialog;
    @BindView(R.id.cd_bottom_base_dialog)
    FancyButton cdBottomBaseDialog;
    @BindView(R.id.cd_top_base_dialog)
    FancyButton cdTopBaseDialog;
    @BindView(R.id.ios_taobao)
    FancyButton iosTaobao;

    private DialogAc mContext;
    private ArrayList<DialogMenuItem> mMenuItems = new ArrayList<>();
    private String[] mStringItems = {"收藏", "下载", "分享", "删除", "歌手", "专辑"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        ButterKnife.bind(this);
        mContext = this;

        intView();
        initData();
    }

    private void initData() {
        mMenuItems.add(new DialogMenuItem("QQ", R.mipmap.ic_qq));
        mMenuItems.add(new DialogMenuItem("微信", R.mipmap.ic_wechart));
        mMenuItems.add(new DialogMenuItem("朋友圈", R.mipmap.ic_pyquan));
        mMenuItems.add(new DialogMenuItem("QQ空间", R.mipmap.ic_qq_zone));
        mMenuItems.add(new DialogMenuItem("支付宝", R.mipmap.ic_alibaba));
        mMenuItems.add(new DialogMenuItem("新浪微博", R.mipmap.ic_sina));
        mMenuItems.add(new DialogMenuItem("钉钉", R.mipmap.ic_dingding));
    }

    private void intView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dialog");
    }

    @OnClick({R.id.default_two_btns, R.id.style_two, R.id.custom_attr, R.id.one_btn
            , R.id.thres_btns, R.id.md_two_btns, R.id.md_one_btn, R.id.md_three_btns
            , R.id.normal_list, R.id.list_custom_attr, R.id.list_no_title, R.id.list_with_data
            , R.id.list_with_adapter, R.id.action_sheet, R.id.action_sheet_no_title
            , R.id.cd_base_dialog, R.id.cd_bottom_base_dialog, R.id.cd_top_base_dialog
            , R.id.ios_taobao})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.default_two_btns:
                final NormalDialog default_two_btns = new NormalDialog(mContext);
                default_two_btns.content("客观确定要退出吗？？")
                        .showAnim(new BounceEnter())
                        .dismissAnim(new BounceExit())
                        .show();
                /**
                 * set btn click listener(设置按钮监听事件)
                 * onBtnClickLs size 1, middle
                 * onBtnClickLs size 2, left right
                 * onBtnClickLs size 3, left right middle
                 */
                default_two_btns.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("left");
                                default_two_btns.dismiss();
                            }

                        },

                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("right");
                                default_two_btns.dismiss();
                            }
                        });
                break;
            case R.id.style_two:
                final NormalDialog style_two = new NormalDialog(mContext);
                style_two.content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                        .style(NormalDialog.STYLE_TWO)//
                        .titleTextSize(23)//
                        .showAnim(new BounceEnter())//
                        .dismissAnim(new BounceExit())//
                        .show();

                style_two.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("left");
                                style_two.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("right");
                                style_two.dismiss();
                            }
                        });
                break;
            case R.id.custom_attr:
                final NormalDialog custom_attr = new NormalDialog(mContext);
                custom_attr.isTitleShow(false)//是否显示Title
                        .bgColor(Color.parseColor("#383838"))//设置背景颜色
                        .cornerRadius(5)//设置圆角大小
                        .content("是否确定退出程序?")//
                        .contentGravity(Gravity.CENTER)//
                        .contentTextColor(Color.parseColor("#ffffff"))//
                        .dividerColor(Color.parseColor("#222222"))//设置分割线颜色
                        .btnTextSize(15.5f, 15.5f)//设置按钮字体大小
                        .btnTextColor(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))//设置按钮颜色
                        .btnPressColor(Color.parseColor("#2B2B2B"))//设置按钮按下颜色
                        .widthScale(0.85f)//设置宽度屏占比
                        .dimEnabled(false)
                        .showAnim(new BounceEnter())//
                        .dismissAnim(new BounceExit())//
                        .show();

                custom_attr.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("left");
                                custom_attr.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("right");
                                custom_attr.dismiss();
                            }
                        });
                break;
            case R.id.one_btn:
                final NormalDialog one_btn = new NormalDialog(mContext);
                one_btn.content("你今天的抢购名额已用完~")//
                        .btnNum(1)
                        .btnText("继续逛逛")//
                        .showAnim(new BounceEnter())
                        .dismissAnim(new BounceExit())
                        .show();

                one_btn.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        showToast("right");
                        one_btn.dismiss();
                    }
                });
                break;
            case R.id.thres_btns:
                final NormalDialog thres_btns = new NormalDialog(mContext);
                thres_btns.content("你今天的抢购名额已用完~")//
                        .style(NormalDialog.STYLE_TWO)//
                        .btnNum(3)
                        .btnText("取消", "确定", "继续逛逛")//
                        .showAnim(new BounceEnter())
                        .dismissAnim(new BounceExit())
                        .show();

                thres_btns.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("left");
                                thres_btns.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("right");
                                thres_btns.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                showToast("middle");
                                thres_btns.dismiss();
                            }
                        });
                break;
            case R.id.md_two_btns:
                final MaterialDialog md_two_btns = new MaterialDialog(mContext);
                md_two_btns.content(
                        "嗨！这是一个 MaterialDialogDefault. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来。"
                                + "它简洁小巧，完全遵照 Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^")//
                        .btnText("取消", "确定")//
                        .showAnim(new BounceLeftEnter())
                        .dismissAnim(new BounceRightExit())
                        .show();

                md_two_btns.setOnBtnClickL(
                        new OnBtnClickL() {//left btn click listener
                            @Override
                            public void onBtnClick() {
                                showToast("left");
                                md_two_btns.dismiss();
                            }
                        },
                        new OnBtnClickL() {//right btn click listener
                            @Override
                            public void onBtnClick() {
                                showToast("right");
                                md_two_btns.dismiss();
                            }
                        }
                );
                break;
            case R.id.md_one_btn:
                final MaterialDialog md_one_btn = new MaterialDialog(mContext);
                md_one_btn//
                        .btnNum(1)
                        .content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                        .btnText("确定")//
                        .showAnim(new SlideLeftEnter())
                        .dismissAnim(new SlideRightExit())
                        .show();

                md_one_btn.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        showToast("middle");
                        md_one_btn.dismiss();
                    }
                });
                break;
            case R.id.md_three_btns:
                final MaterialDialog md_three_btns = new MaterialDialog(mContext);
                md_three_btns.isTitleShow(false)//
                        .btnNum(3)
                        .content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                        .btnText("确定", "取消", "知道了")//
                        .showAnim(new SlideLeftEnter())
                        .dismissAnim(new SlideRightExit())
                        .show();

                md_three_btns.setOnBtnClickL(
                        new OnBtnClickL() {//left btn click listener
                            @Override
                            public void onBtnClick() {
                                showToast("middle");
                                md_three_btns.dismiss();
                            }
                        },
                        new OnBtnClickL() {//right btn click listener
                            @Override
                            public void onBtnClick() {
                                showToast("middle");
                                md_three_btns.dismiss();
                            }
                        }
                        ,
                        new OnBtnClickL() {//middle btn click listener
                            @Override
                            public void onBtnClick() {
                                showToast("middle");
                                md_three_btns.dismiss();
                            }
                        }
                );
                break;
            case R.id.normal_list:
                final NormalListDialog normal_list = new NormalListDialog(mContext, mMenuItems);
                normal_list.title("分享至")//
                        .showAnim(new BounceTopEnter())//
                        .dismissAnim(new SlideBottomExit())//
                        .show();
                normal_list.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast("已分享至" + mMenuItems.get(position).mOperName);
                        normal_list.dismiss();
                    }
                });
                break;
            case R.id.list_custom_attr:
                final NormalListDialog list_custom_attr = new NormalListDialog(mContext, mMenuItems);
                list_custom_attr.title("分享至")//
                        .titleTextSize_SP(18)//
                        .titleBgColor(ContextCompat.getColor(mContext, R.color.primary))//
                        .itemPressColor(ContextCompat.getColor(mContext, R.color.primary_light))//
                        .itemTextColor(Color.parseColor("#303030"))//
                        .itemTextSize(14)//
                        .cornerRadius(0)//
                        .widthScale(0.8f)//
                        .showAnim(new BounceLeftEnter())//
                        .dismissAnim(new BounceRightExit())//
                        .show();

                list_custom_attr.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast("已分享至" + mMenuItems.get(position).mOperName);
                        list_custom_attr.dismiss();
                    }
                });
                break;
            case R.id.list_no_title:
                final NormalListDialog list_no_title = new NormalListDialog(mContext, mMenuItems);
                list_no_title.title("分享至")//
                        .isTitleShow(false)//
                        .itemPressColor(Color.parseColor("#85D3EF"))//
                        .itemTextColor(Color.parseColor("#303030"))//
                        .itemTextSize(15)//
                        .cornerRadius(2)//
                        .widthScale(0.75f)//
                        .show();

                list_no_title.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast("已分享至" + mMenuItems.get(position).mOperName);
                        list_no_title.dismiss();
                    }
                });
                break;
            case R.id.list_with_data:
                final NormalListDialog list_with_data = new NormalListDialog(mContext, mStringItems);
                list_with_data.title("请选择")//
                        .layoutAnimation(null)//关闭item进入动画
                        .showAnim(new BounceTopEnter())//
                        .dismissAnim(new SlideBottomExit())//
                        .show();
                list_with_data.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast("已分享至" + mMenuItems.get(position).mOperName);
                        list_with_data.dismiss();
                    }
                });
                break;
            case R.id.list_with_adapter:
                final NormalListDialog list_with_adapter = new NormalListDialog(mContext, new TestAdapter(mContext, mMenuItems));
                list_with_adapter.title("请选择")//
                        .showAnim(new BounceTopEnter())//
                        .dismissAnim(new SlideBottomExit())//
                        .show();
                list_with_adapter.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast("已分享至" + mMenuItems.get(position).mOperName);
                        list_with_adapter.dismiss();
                    }
                });
                break;
            case R.id.action_sheet:
                final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
                final ActionSheetDialog action_sheet = new ActionSheetDialog(mContext, stringItems, null);
                action_sheet.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                        .titleTextSize_SP(14.5f)//
                        .show();

                action_sheet.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast(stringItems[position]);
                        action_sheet.dismiss();
                    }
                });
                break;
            case R.id.action_sheet_no_title:
                final String[] stringItems_2 = {"版本更新", "帮助与反馈", "退出QQ"};
                final ActionSheetDialog action_sheet_no_title = new ActionSheetDialog(mContext, stringItems_2, root);
                action_sheet_no_title
                        .isTitleShow(false)
                        .show();

                action_sheet_no_title.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showToast(stringItems_2[position]);
                        action_sheet_no_title.dismiss();
                    }
                });
                break;
            case R.id.cd_base_dialog:
                final CustomBaseDialog cd_base_dialog = new CustomBaseDialog(mContext);
                cd_base_dialog.show();
                cd_base_dialog.setCanceledOnTouchOutside(false);
                break;
            case R.id.cd_bottom_base_dialog:
                final ShareBottomDialog cd_bottom_base_dialog = new ShareBottomDialog(mContext, root);
                cd_bottom_base_dialog.showAnim(new BounceEnter())//
                        .show();//
                break;
            case R.id.cd_top_base_dialog:
                final ShareTopDialog dialog = new ShareTopDialog(mContext);
                dialog.showAnim(new BounceTopEnter())//
                        .show();
                break;
            case R.id.ios_taobao:
                final IOSTaoBaoDialog ios_taobao = new IOSTaoBaoDialog(mContext, root);
                ios_taobao.show();
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.content("亲,真的要走吗?再看会儿吧~(●—●)")//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .btnText("继续逛逛", "残忍退出")//
                .btnTextColor(Color.parseColor("#383838"), Color.parseColor("#D4D4D4"))//
                .btnTextSize(16f, 16f)//
                .showAnim(new FlipInXAnimator())//
                .dismissAnim(new FlipInXExit())//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        dialog.superDismiss();
                        finish();
                    }
                });
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.content("亲,真的要走吗?再看会儿吧~(●—●)")//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .btnText("继续逛逛", "残忍退出")//
                .btnTextColor(Color.parseColor("#383838"), Color.parseColor("#D4D4D4"))//
                .btnTextSize(16f, 16f)//
                .showAnim(new FlipInXAnimator())//
                .dismissAnim(new FlipInXExit())//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        dialog.superDismiss();
                        finish();
                    }
                });
    }
}
