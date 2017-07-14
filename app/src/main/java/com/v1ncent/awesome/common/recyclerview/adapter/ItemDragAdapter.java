package com.v1ncent.awesome.common.recyclerview.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;

import java.util.List;

/**
 * Created by v1ncent on 2017/6/30.
 */

public class ItemDragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public ItemDragAdapter(List<String> data) {
        super(R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        switch (helper.getLayoutPosition() %
                4) {
            case 0:
                helper.setImageResource(R.id.drag_img, R.mipmap.taobao);
                break;
            case 1:
                helper.setImageResource(R.id.drag_img, R.mipmap.jd);
                break;
            case 2:
                helper.setImageResource(R.id.drag_img, R.mipmap.eleme);
                break;
            case 3:
                helper.setImageResource(R.id.drag_img, R.mipmap.tmail);
                break;
        }
        helper.setText(R.id.drag_tv, item);
    }
}
