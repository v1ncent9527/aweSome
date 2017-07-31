package com.v1ncent.awesome.common.animaiton.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.hujiaweibujidao.wava.Techniques;
import com.v1ncent.awesome.R;

/**
 * Created by v1ncent on 2017/7/31.
 */

public class CommonAnimAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;

    public CommonAnimAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Techniques.values().length;
    }

    @Override
    public Object getItem(int position) {
        return Techniques.values()[position].getAnimator();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View v = mLayoutInflater.inflate(R.layout.item_common_anim, null, false);
        TextView t = (TextView) v.findViewById(R.id.list_item_text);
        Object o = getItem(position);
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        String name = o.getClass().getName().substring(start);
        t.setText(name);
        v.setTag(Techniques.values()[position]);
        return v;
    }
}
