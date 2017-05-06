package com.loading.carmall.utils;

import android.view.View;

import java.util.Calendar;
/**
    *Created by 马小布 on 2017/5/5.
    *Project : recycler adapter封装
    *Program Name :  com.loading.carmall.utils.NoDoubleClickListener.java
    *Author :马庆龙 on 2017/5/5 10:32
    *email:maxiaobu1999@163.com
    *功能：连续点击只取单击
    *伪码：
    *待完成：
*/
public abstract class NoDoubleClickListener implements View.OnClickListener {

    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    @Override
    public void onClick(View view) {

        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(view);
        }

    }

    protected abstract void onNoDoubleClick(View view);
}
