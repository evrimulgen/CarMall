package com.loading.carmall.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.GoodsDetailFrgAdapter;
import com.loading.carmall.bean.CartNewcartBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.utils.MqlUtils;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class GoodsDetailFragment extends LazyBaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private GoodsDetailFrgAdapter mAdapter;

    public static GoodsDetailFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putString("id",id);

        GoodsDetailFragment fragment = new GoodsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public GoodsDetailFragment() {
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_goods_detail;
    }

    @Override
    protected void lazyLoad() {
        ButterKnife.bind(this, view);
        initView();
        initData();
    }

    private void initData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("cartid", getArguments().getString("id"));
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CART_CART_DETAIL)
                .params(map, Contstant.CART_CART_DETAIL)
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

                        Log.d("GoodsDetailFragment", "CART_CART_DETAIL" + response);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：CART_CART_DETAIL————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }


    public void initView() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GoodsDetailFrgAdapter(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
