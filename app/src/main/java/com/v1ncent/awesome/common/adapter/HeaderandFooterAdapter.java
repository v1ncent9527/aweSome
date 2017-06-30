package com.v1ncent.awesome.common.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.pojo.CommonAdapterVO;

import java.util.List;

/**
 * Created by v1ncent on 2017/6/9.
 */

public class HeaderandFooterAdapter extends BaseQuickAdapter<CommonAdapterVO, BaseViewHolder> {
    public HeaderandFooterAdapter(@LayoutRes int layoutResId, @Nullable List<CommonAdapterVO> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonAdapterVO item) {
        helper.setVisible(R.id.banner_title, false);
        helper.setVisible(R.id.banner_text, false);
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.banner_1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.banner_2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.banner_3);
                break;
        }

    }
}
