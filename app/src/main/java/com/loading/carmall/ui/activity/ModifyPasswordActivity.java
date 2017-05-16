package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ModifyPasswordActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();

    }

    private void initClick() {

    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon,mTvTitleCommon,"修改密码");

    }

    @Override
    public void initData() {

    }
}
