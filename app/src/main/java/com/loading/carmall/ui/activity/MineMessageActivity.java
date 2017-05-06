package com.loading.carmall.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.R;
import com.loading.carmall.adapter.InformationTopicFrgAdapter;
import com.loading.carmall.adapter.MineMessageFrgAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 马小布 on 2017/4/25.
 * Project : 首页底部导航栏
 * Program Name :  com.loading.carmall.ui.activity.MineMessageActivity.java
 * Author :马庆龙 on 2017/4/25 13:54
 * email:maxiaobu1999@163.com
 * 功能：我的消息
 * 伪码：
 * 待完成：
 */
public class MineMessageActivity extends BaseAty
        implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private int mCurrentCounter = 0;
    private static final int PAGE_SIZE = 6;
    private static final int TOTAL_COUNTER = 18;
    private boolean mLoadMoreEndGone = false;//true is gone,false is visible
    private boolean isErr;
    private MineMessageFrgAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_message);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "我的消息");

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MineMessageFrgAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mRecyclerView.setAdapter(mAdapter);
        mCurrentCounter = mAdapter.getData().size();
    }

    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setNewData(DataServer.getSampleData(PAGE_SIZE));
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);
            }
        }, 200);
    }
    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        if (mAdapter.getData().size() < PAGE_SIZE) {
            mAdapter.loadMoreEnd(true);
        } else {
            if (mCurrentCounter >= TOTAL_COUNTER) {
//                    pullToRefreshAdapter.loadMoreEnd();//default visible
                mAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
            } else {
                if (isErr) {
                    mAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                    mCurrentCounter = mAdapter.getData().size();
                    mAdapter.loadMoreComplete();
                } else {
                    isErr = true;
                    Toast.makeText(mActivity, R.string.network_err, Toast.LENGTH_SHORT).show();
                    mAdapter.loadMoreFail();

                }
            }
            mSwipeRefreshLayout.setEnabled(true);
        }
    }

    @Override
    public void initData() {

    }
}
