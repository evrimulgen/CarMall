package com.loading.carmall.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CommonProblemFrgAdapter;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.LinkedHashMap;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class CommonProblemFragment extends LazyBaseFragment
        implements BaseQuickAdapter.RequestLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private CommonProblemFrgAdapter mAdapter;

    private int mCurrentCounter = 0;
    private static final int PAGE_SIZE = 6;
    private static final int TOTAL_COUNTER = 18;
    private boolean mLoadMoreEndGone = false;//true is gone,false is visible
    private boolean isErr;

    public static CommonProblemFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id", id);
        CommonProblemFragment fragment = new CommonProblemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CommonProblemFragment() {
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_common_problem;
    }

    @Override
    protected void lazyLoad() {
        ButterKnife.bind(this, view);
        initView();
        initData();
    }

    private void initData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("classid", String.valueOf(getArguments().get("id")));
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
                        Log.d("CommonProblemFragment", "USER_GETFAQLIST" + response);


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：USER_GETFAQLIST————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void initView() {
        if (mAdapter == null) {
            mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            mSwipeRefreshLayout.setOnRefreshListener(this);
            mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            mAdapter = new CommonProblemFrgAdapter();
            mAdapter.setOnLoadMoreListener(this, mRecyclerView);
            mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
            mRecyclerView.setAdapter(mAdapter);
        }

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
                    Toast.makeText(getActivity(), R.string.network_err, Toast.LENGTH_SHORT).show();
                    mAdapter.loadMoreFail();

                }
            }
            mSwipeRefreshLayout.setEnabled(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mAdapter = null;
        ButterKnife.unbind(this);
    }

}
