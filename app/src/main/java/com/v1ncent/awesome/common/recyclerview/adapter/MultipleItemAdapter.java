package com.v1ncent.awesome.common.recyclerview.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.recyclerview.pojo.CommonAdapterVO;

import java.util.List;

/**
 * Created by v1ncent on 2017/6/15.
 */

public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<CommonAdapterVO, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemAdapter(Context context, List<CommonAdapterVO> data) {
        super(data);
        addItemType(CommonAdapterVO.TEXT, R.layout.item_layout_only_tv);
        addItemType(CommonAdapterVO.IMG, R.layout.item_layout_only_image);
        addItemType(CommonAdapterVO.IMG_TEXT, R.layout.item_layout_img_text);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommonAdapterVO item) {
        helper.addOnClickListener(R.id.iv);
        switch (helper.getItemViewType()) {
            case CommonAdapterVO.TEXT:
                helper.setText(R.id.tv1, item.getContent());
                break;
            case CommonAdapterVO.IMG_TEXT:
                switch (helper.getLayoutPosition() % 2) {
                    case 0:
                        helper.setImageResource(R.id.iv, R.mipmap.banner_4);
                        helper.setText(R.id.tv, "R.mipmap.banner_4");
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv, R.mipmap.banner_3);
                        helper.setText(R.id.tv, "R.mipmap.banner_3");

                        break;
                }
                break;
        }


    }
}
