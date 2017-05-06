package com.loading.carmall.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.CartGethotbrandBean;
import com.loading.carmall.bean.CartNewcartBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.utils.ConvertUtils;
import com.loading.carmall.utils.MqlUtils;
import com.loading.carmall.utils.ScreenUtils;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class NewCarsActivity extends BaseAty implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private List<List<CartNewcartBean.DataBean>> mDatas;
    private BaseQuickAdapter<List<CartNewcartBean.DataBean>, BaseViewHolder> mAdapter;

    //    NewCarAtyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cars);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onStop() {
        OkHttpUtils.getInstance().cancelTag(this);
        super.onStop();
    }

    private void startDetailActivity(String id) {
        Intent intent = new Intent(mActivity, GoodsDetailActivity.class)
                .putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "最新车源");

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseQuickAdapter<List<CartNewcartBean.DataBean>, BaseViewHolder>(R.layout.item_new_cars_aty, mDatas) {
            @Override
            protected void convert(BaseViewHolder helper, final List<CartNewcartBean.DataBean> item) {
                if (item.size() >= 1) {
                    //起码有一项
                    ImageView ivFirst = helper.getView(R.id.iv_first);
                    Glide.with(mActivity).load(item.get(0).getLogo()).into(ivFirst);
                    ivFirst.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startDetailActivity(String.valueOf(item.get(0).getModelid()));
                        }
                    });
                }
                if (item.size() >= 2) {
                    //起码有两项
                    ImageView ivSecond = helper.getView(R.id.iv_second);
                    Glide.with(mActivity).load(item.get(1).getLogo()).into(ivSecond);
                    ivSecond.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startDetailActivity(String.valueOf(item.get(1).getModelid()));
                        }
                    });

                }
                if (item.size() >= 3) {
                    //起码有三项
                    ImageView ivThird = helper.getView(R.id.iv_third);
                    Glide.with(mActivity).load(item.get(2).getLogo()).into(ivThird);
                    ivThird.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startDetailActivity(String.valueOf(item.get(2).getModelid()));
                        }
                    });
                }
            }
        };

        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        pullToRefreshAdapter.setAutoLoadMoreSize(3);
        mRecyclerView.setAdapter(mAdapter);
//

    }

    @Override
    public void initData() {
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CART_NEWCART)
                .params(null, Contstant.CART_NEWCART)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onAfter(int id) {
                        super.onAfter(id);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        mSwipeRefreshLayout.setRefreshing(true);
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {

                        Log.d("NewCarsActivity", "CART_NEWCART" + response);
                        Gson gson = new Gson();
                        List<CartNewcartBean.DataBean> beans = gson.fromJson(response, CartNewcartBean.class).getData();
//                        List<List<CartNewcartBean.DataBean>> datas= new ArrayList<>();
                        mAdapter.setNewData(MqlUtils.groupListByQuantity(beans, 3));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：CART_NEWCART————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onRefresh() {
        initData();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
