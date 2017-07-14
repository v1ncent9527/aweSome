package com.v1ncent.awesome.common.recyclerview.pojo;

import android.view.View;
import android.widget.Toast;

/**
 * Created by v1ncent on 2017/7/4.
 */

public class MoviePresenter {
    public void buyTicket(View view, Movie movie) {
        Toast.makeText(view.getContext(), "buy ticket: " + movie.name, Toast.LENGTH_SHORT).show();
//        EventBus.getDefault().post(movie);
    }
}
