package com.v1ncent.awesome.common.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.common.recyclerview.pojo.Movie;

import java.util.List;

/**
 * Created by v1ncent on 2017/7/18.
 */

public class DiscreteScrollViewAdapter extends RecyclerView.Adapter<DiscreteScrollViewAdapter.ViewHolder> {
    private List<Movie> data;

    public DiscreteScrollViewAdapter(List<Movie> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_discrete_scrollview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position %
                3) {
            case 0:
                holder.image.setImageResource(R.mipmap.bxjg);
                break;
            case 1:
                holder.image.setImageResource(R.mipmap.lg);
                break;
            case 2:
                holder.image.setImageResource(R.mipmap.ksx);
                break;

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
