package com.v1ncent.awesome.common.customview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.v1ncent.awesome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalFragment2 extends Fragment {
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    private boolean hasInited = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vertical_fragment2, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void initView() {
        if (!hasInited) {
            hasInited = true;
            progressbar.setVisibility(View.GONE);
        }
    }
}
