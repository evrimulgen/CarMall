package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.ui.weiget.StateTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondHandSaleActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.commit)
    StateTextView mCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_sale);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    private void initClick() {
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, SecondHandSaleSuccessActivity.class));
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
