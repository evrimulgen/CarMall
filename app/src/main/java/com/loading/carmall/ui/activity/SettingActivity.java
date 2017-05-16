package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
    *Created by 马小布 on 2017/5/16.
    *Project : 易购汽车
    *Program Name :  com.loading.carmall.ui.activity.SettingActivity.java
    *Author :马庆龙 on 2017/5/16 8:52
    *email:maxiaobu1999@163.com
    *功能：设置
    *伪码：
    *待完成：
*/
public class SettingActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.ly_modify_password)
    LinearLayout mLyModifyPassword;
    @Bind(R.id.ly_agreement)
    LinearLayout mLyAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    private void initClick() {
        mLyModifyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, ModifyPasswordActivity.class));
            }
        });

        mLyAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,AgreementActivity.class));
            }
        });
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "设置");
    }

    @Override
    public void initData() {

    }

}
