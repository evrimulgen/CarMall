package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.loading.carmall.R;
import com.loading.carmall.adapter.CommonViewpageAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.ui.fragment.GoodsDetailFragment;
import com.loading.carmall.ui.fragment.GoodsEvaluationFragment;
import com.loading.carmall.ui.fragment.GoodsParameterFragment;
import com.loading.carmall.ui.weiget.banner.BGABanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsDetailActivity extends BaseAty implements View.OnClickListener {

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        if (mViewPager != null) {
            setupViewPager(mViewPager);
            mViewPager.setOffscreenPageLimit(2);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    public void initData() {

    }

    private void setupViewPager(ViewPager viewPager) {
        String id = getIntent().getStringExtra("id");
        CommonViewpageAdapter adapter = new CommonViewpageAdapter(getSupportFragmentManager());
        adapter.addFragment(GoodsDetailFragment.newInstance(id), "详情");
        adapter.addFragment(GoodsParameterFragment.newInstance(id), "参数");
        adapter.addFragment(new GoodsEvaluationFragment(), "评价");
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.tv_order_now,R.id.iv_back})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_order_now:
                startActivity(new Intent(this, SubmitOrderActivity.class));
                break;
            case R.id.iv_back:
                this.finish();
                break;
            default:
                break;
        }

    }

}
