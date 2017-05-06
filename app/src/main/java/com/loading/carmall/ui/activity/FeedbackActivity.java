package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FeedbackActivity extends BaseAty {


    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.button1)
    AppCompatRadioButton mButton1;
    @Bind(R.id.button2)
    AppCompatRadioButton mButton2;
    @Bind(R.id.button3)
    AppCompatRadioButton mButton3;
    @Bind(R.id.button4)
    AppCompatRadioButton mButton4;
    @Bind(R.id.radio_group)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "意见反馈");
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.d("FeedbackActivity", "checkedId:" + checkedId);
            }
        });
    }

    @Override
    public void initData() {

    }
}
