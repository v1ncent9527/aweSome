package com.v1ncent.awesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.v1ncent.awesome.base.BaseFragment;
import com.v1ncent.awesome.common.animaiton.activity.AVLoadingAc;
import com.v1ncent.awesome.common.animaiton.activity.CommonAnimAc;
import com.v1ncent.awesome.common.customview.activity.BadgeViewAc;
import com.v1ncent.awesome.common.customview.activity.BlurAc;
import com.v1ncent.awesome.common.customview.activity.ButtonAc;
import com.v1ncent.awesome.common.customview.activity.CircularAnimAc;
import com.v1ncent.awesome.common.customview.activity.CornerLabelAc;
import com.v1ncent.awesome.common.customview.activity.CountdownViewAc;
import com.v1ncent.awesome.common.customview.activity.CouponViewAc;
import com.v1ncent.awesome.common.customview.activity.DialogAc;
import com.v1ncent.awesome.common.customview.activity.DragLayoutAc;
import com.v1ncent.awesome.common.customview.activity.EditTextAc;
import com.v1ncent.awesome.common.customview.activity.ExplosionFieldAc;
import com.v1ncent.awesome.common.customview.activity.MarqueeViewAc;
import com.v1ncent.awesome.common.customview.activity.MkloaderAc;
import com.v1ncent.awesome.common.customview.activity.PickViewAc;
import com.v1ncent.awesome.common.customview.activity.PopupAc;
import com.v1ncent.awesome.common.customview.activity.ProgressAc;
import com.v1ncent.awesome.common.customview.activity.ShapeRippleAc;
import com.v1ncent.awesome.common.customview.activity.SwitchButtonAc;
import com.v1ncent.awesome.common.customview.activity.TextViewActivity;
import com.v1ncent.awesome.common.customview.activity.VerificationCodeAc;
import com.v1ncent.awesome.common.customview.activity.WaveLoadingAc;
import com.v1ncent.awesome.common.new_technology.activity.EvetBusAc1;
import com.v1ncent.awesome.common.recyclerview.activity.CommonAdapterAc;
import com.v1ncent.awesome.common.recyclerview.activity.DiscreteScrollViewAc;
import com.v1ncent.awesome.common.recyclerview.activity.LayoutSwitchAc;
import com.v1ncent.awesome.common.recyclerview.activity.ShimmerLayoutAc;
import com.v1ncent.awesome.common.recyclerview.activity.SwipeLayoutAc;
import com.v1ncent.awesome.common.recyclerview.activity.SwipeMenuAc;
import com.v1ncent.awesome.common.test.activity.XxxHdpiAc;
import com.v1ncent.awesome.common.viewpager.activity.MagicIndicatorMainAc;
import com.v1ncent.awesome.common.viewpager.activity.WeixinTabAc;
import com.v1ncent.awesome.utils.impl.OnRecyclerViewListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.everything.android.ui.overscroll.IOverScrollDecor;
import me.everything.android.ui.overscroll.IOverScrollUpdateListener;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by v1ncent on 2017/5/12.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.main_recycler)
    RecyclerView mainRecycler;

    private ArrayList<String> itemList = new ArrayList<>();
    private MainAdapter mainAdapter;
    private Context mContext;
    private String TAG;
    private IOverScrollDecor mVertOverScrollEffect;

    @Override
    public void onClickListener(View v) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        mContext = getActivity();

        initDate();
        initView();
        return view;
    }

    private void initView() {
        mainRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mainAdapter = new MainAdapter(mContext, itemList);
        mainRecycler.setAdapter(mainAdapter);

        // Vertical
        mVertOverScrollEffect = OverScrollDecoratorHelper.setUpOverScroll(mainRecycler, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        mVertOverScrollEffect.setOverScrollUpdateListener(new IOverScrollUpdateListener() {
            @Override
            public void onOverScrollUpdate(IOverScrollDecor decor, int state, float offset) {
                EventBus.getDefault().post(String.valueOf((int) offset));
                Logger.i(String.valueOf((int) offset));
            }
        });
        mainAdapter.addItemClickListener(new OnRecyclerViewListener() {
            @Override
            public void onItemClickListener(int position) {
                switch (TAG) {
                    case "navigation_item_ui":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), TextViewActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(getActivity(), SwipeMenuAc.class));
                                break;
                            case 2:
                                startActivity(new Intent(getActivity(), SwitchButtonAc.class));
                                break;
                            case 3:
                                startActivity(new Intent(getActivity(), ButtonAc.class));
                                break;
                            case 4:
                                startActivity(new Intent(getActivity(), CircularAnimAc.class));
                                break;
                            case 5:
                                startActivity(new Intent(getActivity(), ShapeRippleAc.class));
                                break;
                            case 6:
                                startActivity(new Intent(getActivity(), MkloaderAc.class));
                                break;
                            case 7:
                                startActivity(new Intent(getActivity(), MarqueeViewAc.class));
                                break;
                            case 8:
                                startActivity(new Intent(getActivity(), WaveLoadingAc.class));
                                break;
                            case 9:
                                startActivity(new Intent(getActivity(), VerificationCodeAc.class));
                                break;
                            case 10:
                                startActivity(new Intent(getActivity(), CornerLabelAc.class));
                                break;
                            case 11:
                                startActivity(new Intent(getActivity(), EditTextAc.class));
                                break;
                            case 12:
                                startActivity(new Intent(getActivity(), ProgressAc.class));
                                break;
                            case 13:
                                startActivity(new Intent(getActivity(), DialogAc.class));
                                break;
                            case 14:
                                startActivity(new Intent(getActivity(), BlurAc.class));
                                break;
                            case 15:
                                startActivity(new Intent(getActivity(), PopupAc.class));
                                break;
                            case 16:
                                startActivity(new Intent(getActivity(), DragLayoutAc.class));
                                break;
                            case 17:
                                startActivity(new Intent(getActivity(), CountdownViewAc.class));
                                break;
                            case 18:
                                startActivity(new Intent(getActivity(), ExplosionFieldAc.class));
                                break;
                            case 19:
                                startActivity(new Intent(getActivity(), PickViewAc.class));
                                break;
                            case 20:
                                startActivity(new Intent(getActivity(), CouponViewAc.class));
                                break;
                            case 21:
                                startActivity(new Intent(getActivity(), BadgeViewAc.class));
                                break;
                        }
                        break;
                    case "navigation_item_recycler":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), CommonAdapterAc.class));
                                break;
                            case 1:
                                startActivity(new Intent(getActivity(), DiscreteScrollViewAc.class));
                                break;
                            case 2:
                                startActivity(new Intent(getActivity(), LayoutSwitchAc.class));
                                break;
                            case 3:
                                startActivity(new Intent(getActivity(), SwipeLayoutAc.class));
                                break;
                            case 4:
                                startActivity(new Intent(getActivity(), ShimmerLayoutAc.class));
                                break;
                        }
                        break;
                    case "navigation_item_test":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), XxxHdpiAc.class));
                                break;
                        }
                        break;
                    case "navigation_item_photo":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), XxxHdpiAc.class));
                                break;
                        }
                        break;
                    case "navigation_item_new_technology":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), EvetBusAc1.class));
                                break;
                        }
                        break;
                    case "navigation_item_viewpager":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), MagicIndicatorMainAc.class));
                                break;
                            case 1:
                                startActivity(new Intent(getActivity(), WeixinTabAc.class));
                                break;
                        }
                        break;
                    case "navigation_item_animation":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), CommonAnimAc.class));
                                break;
                            case 1:
                                startActivity(new Intent(getActivity(), MkloaderAc.class));
                                break;
                            case 2:
                                startActivity(new Intent(getActivity(), AVLoadingAc.class));
                                break;
                        }
                        break;
                }
            }

            @Override
            public void onItemViewClickListener(int position) {

            }
        });
    }

    private void initDate() {
        Bundle bundle = getArguments();
        itemList.addAll(bundle.getStringArrayList("itemsList"));
        TAG = bundle.getString("TAG");
    }
}
