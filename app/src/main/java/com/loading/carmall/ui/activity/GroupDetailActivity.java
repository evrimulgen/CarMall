package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.ui.weiget.banner.BGABanner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GroupDetailActivity extends BaseAty implements BGABanner.Delegate, BGABanner.Adapter {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.banner)
    BGABanner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "报名");
        //处理banner
        mBanner.setDelegate(this);
        mBanner.setAdapter(this);
        mBanner.setData(DataServer.getSampleData(10), null);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {

    }

    @Override
    public void fillBannerItem(BGABanner banner, View itemView, Object model, int position) {
        Glide.with(mActivity)
                .load("https://modao.cc/uploads3/images/858/8588083/raw_1491450436.png")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.test_schedule_red_500_24dp)
                .into((ImageView) itemView);
    }
}
