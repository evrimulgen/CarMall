package com.loading.carmall.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;

public class LifeCityBaseAty extends AppCompatActivity {
    String tag = this.getClass().getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
//        Log.d(tag, "onCreateView3");
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        Log.d(tag, "onCreateView4");
        return super.onCreateView(parent, name, context, attrs);
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "destroy");
        ButterKnife.unbind(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(tag, "onSaveInstanceState2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
        Log.d(tag, "onSaveInstanceState");
    }


}
