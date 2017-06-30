package com.v1ncent.awesome.common.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.pojo.MySection;

import java.util.List;

/**
 * Created by v1ncent on 2017/6/30.
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.time, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        String str = item.t;
        switch (helper.getLayoutPosition() %
                4) {
            case 0:
                helper.setImageResource(R.id.settion_img, R.mipmap.taobao);
                break;
            case 1:
                helper.setImageResource(R.id.settion_img, R.mipmap.jd);
                break;
            case 2:
                helper.setImageResource(R.id.settion_img, R.mipmap.eleme);
                break;
            case 3:
                helper.setImageResource(R.id.settion_img, R.mipmap.tmail);
                break;
        }
        helper.setText(R.id.money, str);
    }
}
