package com.v1ncent.awesome.common.customview.activity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.v1ncent.awesome.R;
import com.v1ncent.awesome.base.BaseActivity;
import com.v1ncent.awesome.common.customview.view.FlikerProgressBar;
import com.v1ncent.awesome.common.customview.view.NewCreditSesameView;
import com.v1ncent.awesome.common.customview.view.OldCreditSesameView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by v1ncent on 2017/7/27.
 */

public class ProgressAc extends BaseActivity implements Runnable {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.FlikerProgressBar_1)
    FlikerProgressBar FlikerProgressBar1;
    @BindView(R.id.FlikerProgressBar_2)
    FlikerProgressBar FlikerProgressBar2;
    @BindView(R.id.reload)
    FancyButton reload;
    @BindView(R.id.new_credit_sesame)
    NewCreditSesameView newCreditSesame;
    @BindView(R.id.old_credit_sesame)
    OldCreditSesameView oldCreditSesame;
    @BindView(R.id.reload_2)
    FancyButton reload2;

    Thread downLoadThread;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            FlikerProgressBar1.setProgress(msg.arg1);
            FlikerProgressBar2.setProgress(msg.arg1);
            if (msg.arg1 == 100) {
                FlikerProgressBar1.finishLoad();
                FlikerProgressBar2.finishLoad();
            }
        }
    };
    @BindView(R.id.number_progress_bar)
    NumberProgressBar numberProgressBar;
    private Random random = new Random();
    private final int[] mColors = new int[]{
            0xFFFF0066,
            0xFFE31177,
            0xFFC62288,
            0xFFAA3399,
            0xFF8E44AA,
            0xFF7155BB,
            0xFF5566CC,
            0xFF3977DD,
            0xFF1C88EE,
            0xFF0099FF
    };

    private int chartNum = 24;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Progress");

        downLoad();

        newCreditSesame.setBackgroundColor(mColors[0]);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        numberProgressBar.incrementProgressBy(1);
                    }
                });
            }
        }, 1000, 100);
    }

    private void downLoad() {
        downLoadThread = new Thread(this);
        downLoadThread.start();
    }

    @OnClick({R.id.reload, R.id.FlikerProgressBar_1,
            R.id.FlikerProgressBar_2, R.id.reload_2})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.reload:
                downLoadThread.interrupt();
                // 重新加载
                FlikerProgressBar1.reset();
                FlikerProgressBar2.reset();
                downLoad();
                break;
            case R.id.FlikerProgressBar_1:
                if (!FlikerProgressBar1.isFinish()) {
                    FlikerProgressBar1.toggle();
                    if (FlikerProgressBar1.isStop()) {
                        downLoadThread.interrupt();
                    } else {
                        downLoad();
                    }
                }
                break;
            case R.id.FlikerProgressBar_2:
                if (!FlikerProgressBar2.isFinish()) {
                    FlikerProgressBar2.toggle();
                    if (FlikerProgressBar2.isStop()) {
                        downLoadThread.interrupt();
                    } else {
                        downLoad();
                    }
                }
                break;
            case R.id.reload_2:
                int i = random.nextInt(950);
                newCreditSesame.setSesameValues(i);
                oldCreditSesame.setSesameValues(i);
                startColorChangeAnim();
                break;
        }
    }

    private void startColorChangeAnim() {
        ObjectAnimator animator = ObjectAnimator.ofInt(newCreditSesame, "backgroundColor", mColors);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void run() {
        try {
            while (!downLoadThread.isInterrupted()) {
                float progress = FlikerProgressBar1.getProgress();
                progress += 2;
                Thread.sleep(200);
                Message message = handler.obtainMessage();
                message.arg1 = (int) progress;
                handler.sendMessage(message);
                if (progress == 100) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
