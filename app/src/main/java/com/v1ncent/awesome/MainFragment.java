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

import com.v1ncent.awesome.base.BaseFragment;
import com.v1ncent.awesome.common.customview.activity.ButtonAc;
import com.v1ncent.awesome.common.customview.activity.SwitchButtonAc;
import com.v1ncent.awesome.common.customview.activity.TextViewActivity;
import com.v1ncent.awesome.common.new_technology.activity.EvetBusAc1;
import com.v1ncent.awesome.common.recyclerview.activity.CommonAdapterAc;
import com.v1ncent.awesome.common.recyclerview.activity.SwipeMenuAc;
import com.v1ncent.awesome.common.test.activity.XxxHdpiAc;
import com.v1ncent.awesome.common.viewpager.activity.MagicIndicatorMainAc;
import com.v1ncent.awesome.utils.impl.OnRecyclerViewListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                        }
                        break;
                    case "navigation_item_recycler":
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), CommonAdapterAc.class));
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
