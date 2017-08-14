package com.v1ncent.awesome.common.recyclerview.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v1ncent.awesome.R;

import java.util.List;

/**
 * Created by v1ncent on 2017/8/8.
 */

public class SwipeLayoutAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SwipeLayoutAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.ll);

        switch (helper.getAdapterPosition() % 4) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.google_icon);
                helper.setText(R.id.tv, "www.google.com.hk");
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.mijia_icon);
                helper.setText(R.id.tv, "www.mi.cn");
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.tahu_icon);
                helper.setText(R.id.tv, "www.yahu.com");
                break;
            case 3:
                helper.setImageResource(R.id.img, R.mipmap.sina_icon);
                helper.setText(R.id.tv, "www.sina.com");
                break;
        }

        helper.getView(R.id.btnTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onTop(helper.getAdapterPosition());
                }
            }
        });
        helper.getView(R.id.btnUnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        helper.getView(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mOnSwipeListener) {
                    if (null != mOnSwipeListener) {
                        mOnSwipeListener.onDel(helper.getAdapterPosition());
                    }
                }
            }
        });
    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public onSwipeListener getOnDelListener() {
        return mOnSwipeListener;
    }

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

}
