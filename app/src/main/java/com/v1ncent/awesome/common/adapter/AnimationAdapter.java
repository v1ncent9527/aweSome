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

public class AnimationAdapter extends BaseQuickAdapter<CommonAdapterVO, BaseViewHolder> {
    public AnimationAdapter(@LayoutRes int layoutResId, @Nullable List<CommonAdapterVO> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonAdapterVO item) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.banner_title).addOnClickListener(R.id.banner_text);
        switch (helper.getLayoutPosition() % 4) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.banner_1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.banner_2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.banner_3);
                break;
            case 3:
                helper.setImageResource(R.id.img, R.mipmap.banner_4);
                break;
        }

        helper.setText(R.id.banner_title, item.getTitle());
        helper.setText(R.id.banner_text, item.getContent());


    }
}
