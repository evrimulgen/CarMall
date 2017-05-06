package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.MineMessageFrgAdapter;
import com.loading.carmall.adapter.MineOrderAtyAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.LinkedHashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class MineOrderActivity extends BaseAty
        implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

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
    private MineOrderAtyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "我的订单");

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MineOrderAtyAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mRecyclerView.setAdapter(mAdapter);
        mCurrentCounter = mAdapter.getData().size();

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener<Status>() {
            @Override
            public void onItemClick(BaseQuickAdapter<Status, ? extends BaseViewHolder> adapter, View view, int position) {
                Toast.makeText(App.getInstance(), "position:" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mActivity,OrderDetailActivity.class));

            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener<Status>() {
            @Override
            public void onItemChildClick(BaseQuickAdapter<Status, ? extends BaseViewHolder> adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_confirm:
                        startActivity(new Intent(mActivity,EvaluationActivity.class));

                        break;
                }
            }
        });
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
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("classid", "");
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.USER_GETFAQLIST)
                .params(map, Contstant.USER_GETFAQLIST)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("MineOrderActivity", "USER_GETFAQLIST" + response);


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：USER_GETFAQLIST————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
