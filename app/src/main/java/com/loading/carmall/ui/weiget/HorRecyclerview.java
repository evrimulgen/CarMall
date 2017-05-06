package com.loading.carmall.ui.weiget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by 马小布 on 2017/1/13：21:28.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：
 * 伪码：
 * 待完成：
 */

public class HorRecyclerview extends RecyclerView {
    // 滑动距离及坐标
    private float xDistance, yDistance, xLast, yLast;

    public HorRecyclerview(Context context) {
        super(context);
    }

    public HorRecyclerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorRecyclerview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                if (xDistance < yDistance) {//上下滑动
                    return true;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
