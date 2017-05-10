package com.loading.carmall.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.loading.carmall.App;

/**
 *                                                      __----~~~~~~~~~~~------___
 *                                     .  .   ~~//====......          __--~ ~~
 *                     -.            \_|//     |||\\  ~~~~~~::::... /~
 *                  ___-==_       _-~o~  \/    |||  \\            _/~~-
 *          __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 *      _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 *    .~       .~       |   \\ -_    /  /-   /   ||      \   /
 *   /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 *   |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 *            '         ~-|      /|    |-~\~~       __--~~
 *                        |-~~-_/ |    |   ~\_   _-~            /\
 *                             /  \     \__   \/~                \__
 *                         _--~ _/ | .-~~____--~-/                  ~~==.
 *                        ((->/~   '.|||' -_|    ~~-/ ,              . _||
 *                                   -_     ~\      ~~---l__i__i__i--~~_/
 *                                   _-~-__   ~)  \--______________--~~
 *                                 //.-~~~-~_--~- |-------~~~~~~~~
 *                                        //.-~~~--\
 *                    神兽保佑
 *                  代码无BUG!
 */
public abstract class BaseAty extends LifeCityBaseAty {

    public AppCompatActivity mActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    public abstract void initView();

    public abstract void initData();


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

//    @Override
//    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
//        super.startActivityForResult(intent, requestCode, options);
//        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
//    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
//        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 设置返回toolbar
     *
     * @param toolbarCommon toolbar
     * @param title         放标题的text view
     * @param titleString   标题内容
     */
    public void setCommonBackToolBar(Toolbar toolbarCommon, TextView title, String titleString) {
        toolbarCommon.setTitle("");
        setSupportActionBar(toolbarCommon);
        ActionBar supportActionBar = getSupportActionBar();
        if (null != supportActionBar)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        title.setText(titleString);
    }


    // 获取点击事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View view = getCurrentFocus();
            if (isHideInput(view, ev)) {
                hideSoftInput(view);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
    private boolean isHideInput(View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);//获取view在整个窗口内的绝对坐标
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            //用户点击在view内。
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top
                    && ev.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    // 隐藏软键盘
    private void hideSoftInput(View view) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (manager != null) {
            manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
