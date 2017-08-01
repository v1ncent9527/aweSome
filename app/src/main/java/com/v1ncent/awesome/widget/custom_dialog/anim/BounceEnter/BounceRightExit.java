package com.v1ncent.awesome.widget.custom_dialog.anim.BounceEnter;

import android.animation.ObjectAnimator;
import android.util.DisplayMetrics;
import android.view.View;

import com.v1ncent.awesome.widget.custom_dialog.anim.BaseAnimatorSet;

public class BounceRightExit extends BaseAnimatorSet {
    public BounceRightExit() {
        duration = 1000;
    }

    @Override
    public void setAnimation(View view) {

        DisplayMetrics dm = view.getContext().getResources().getDisplayMetrics();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1, 1, 1, 0),//
                ObjectAnimator.ofFloat(view, "translationX", 0, 10, 30, 250 * dm.density));
    }
}
