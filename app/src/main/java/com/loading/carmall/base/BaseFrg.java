package com.loading.carmall.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * _oo0oo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * 0\  =  /0
 * ___/`---'\___
 * .' \\|     |# '.
 * / \\|||  :  |||# \
 * / _||||| -:- |||||- \
 * |   | \\\  -  #/ |   |
 * | \_|  ''\---/''  |_/ |
 * \  .-\__  '-'  ___/-. /
 * ___'. .'  /--.--\  `. .'___
 * ."" '<  `.___\_<|>_/___.' >' "".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `_.   \_ __\ /__ _/   .-` /  /
 * =====`-.____`.___ \_____/___.-`___.-'=====
 * `=---='
 * <p>
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * 佛祖保佑         永无BUG
 */
public abstract class BaseFrg extends android.support.v4.app.Fragment {
    String tag = this.getClass().getName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(tag, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(tag, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(tag, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(tag, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(tag, "onStop");
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        Log.d(tag, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(tag, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.d(tag, "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    abstract public void initView();

    abstract public void initData();
}
