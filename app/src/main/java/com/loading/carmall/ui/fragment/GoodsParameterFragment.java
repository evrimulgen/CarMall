package com.loading.carmall.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.GoodsParameterAdapter;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.mock.Level0Item;
import com.loading.carmall.mock.Level1Item;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.MultiItemEntity;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class GoodsParameterFragment extends LazyBaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    GoodsParameterAdapter adapter;
    ArrayList<MultiItemEntity> list;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static GoodsParameterFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        GoodsParameterFragment fragment = new GoodsParameterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public GoodsParameterFragment() {
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_goods_parameter;
    }

    @Override
    protected void lazyLoad() {
        ButterKnife.bind(this, view);
        initView();
        initData();
    }

    public void initView() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));

        list = generateData();
        adapter = new GoodsParameterAdapter(list);

        final GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return manager.getSpanCount();
            }
        });

        mRecyclerView.setAdapter(adapter);
        // important! setLayoutManager should be called after setAdapter
        mRecyclerView.setLayoutManager(manager);
//        adapter.expandAll();
    }

    public void initData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("cartid", getArguments().getString("id"));
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CART_CART_CONF)
                .params(map, Contstant.CART_CART_CONF)
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

                        Log.d("GoodsParameterFragment", "CART_CART_CONF" + response);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：CART_CART_CONF————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int lv1Count = 13;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("基本设置" + i + "项", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("似的发射点" + j, "岁的法国大使馆分公司发给对方公司股份");
                lv1.setPostion(j);
//                for (int k = 0; k < personCount; k++) {
//                    lv1.addSubItem(new Person(nameList[k], random.nextInt(40)));
//                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
