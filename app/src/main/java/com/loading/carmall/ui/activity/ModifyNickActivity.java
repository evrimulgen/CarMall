package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ModifyNickActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.edit_text)
    EditText mEditText;
    @Bind(R.id.tv_confirm)
    TextView mTvConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_nick);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
setCommonBackToolBar(mToolbarCommon,mTvTitleCommon,"修改姓名");
    }

    @Override
    public void initData() {

    }
}
