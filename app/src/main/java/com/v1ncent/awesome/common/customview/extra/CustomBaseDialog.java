package com.v1ncent.awesome.common.customview.extra;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.v1ncent.awesome.R;
import com.v1ncent.awesome.widget.custom_dialog.anim.Attention.Swing;
import com.v1ncent.awesome.widget.custom_dialog.base.BaseDialog;
import com.v1ncent.awesome.widget.custom_dialog.utils.CornerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomBaseDialog extends BaseDialog<CustomBaseDialog> {
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_exit)
    TextView mTvExit;

    public CustomBaseDialog(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        showAnim(new Swing());

        // dismissAnim(this, new ZoomOutExit());
        View inflate = View.inflate(mContext, R.layout.dialog_custom_base, null);
        ButterKnife.bind(this, inflate);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));

        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mTvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
