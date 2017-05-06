package com.loading.carmall.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.GroupBuyAtyHeaderAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.CartGethotbrandBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.listener.OnItemClickListener;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;
import com.loading.carmall.utils.recyclerviewanimators.adapters.AlphaInAnimationAdapter;
import com.loading.carmall.utils.recyclerviewanimators.animators.FadeInDownAnimator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;
/**
 *　　　　　　　　┏┓　　　┏┓+ +
 *　　　　　　　┏┛┻━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　　┃ 　
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 ████━████ ┃+
 *　　　　　　　┃　　　　　　　┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　　┃ + +
 *　　　　　　　┗━┓　　　┏━┛
 *　　　　　　　　　┃　　　┃　　　　　　　　　　　
 *　　　　　　　　　┃　　　┃ + + + +
 *　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting　　　　　　　
 *　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug　　
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+　　　　　　　　　
 *　　　　　　　　　┃　 　　┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 *　　　　　　　　　　┃┫┫　┃┫┫
 *　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */
public class GroupBuyActivity extends BaseAty implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private List<CartGethotbrandBean.DataBean> mDatas;
    private BaseQuickAdapter<CartGethotbrandBean.DataBean, BaseViewHolder> mAdapter;
        private GroupBuyAtyHeaderAdapter mHeaderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_buy);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "团购");

//        Gson gson = new Gson();
//        IndexCarFind indexCarFind = new IndexCarFind();
//        IndexCarFindBean indexCarFindBean = gson.fromJson(indexCarFind.getIndexCarFind(), IndexCarFindBean.class);
//        mDatas = new ArrayList<>();
//        mHeaderAdapter = new GroupBuyAtyHeaderAdapter(this, mDatas);
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == mDatas.size() || (position == 5 && !mHeaderAdapter.isExpanded()))
//                    return 5;
//                return 1;
//            }
//        });
//        recyclerView.setItemAnimator(new FadeInDownAnimator());
//        recyclerView.setLayoutManager(gridLayoutManager);
//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mHeaderAdapter);
////        alphaAdapter.setFirstOnly(true);
//        alphaAdapter.setDuration(500);
//        alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
//
//        recyclerView.setAdapter(mHeaderAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseQuickAdapter<CartGethotbrandBean.DataBean, BaseViewHolder>(R.layout.item_home_fra_hot_brand,mDatas) {
            @Override
            protected void convert(BaseViewHolder helper, CartGethotbrandBean.DataBean item) {
                TextView textView = helper.getView(R.id.tv_brand);
                textView.setText(item.getName());

            }
        };

        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        pullToRefreshAdapter.setAutoLoadMoreSize(3);
        mRecyclerView.setAdapter(mAdapter);
      int  mCurrentCounter = mAdapter.getData().size();

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(mActivity, Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });

        //add header
        View headerView = getLayoutInflater().inflate(R.layout.view_group_buy_aty_header, (ViewGroup) mRecyclerView.getParent(), false);
        RecyclerView headerRecyclerView = (RecyclerView) headerView.findViewById(R.id.recycler_view);
        mDatas = new ArrayList<>();
        mHeaderAdapter = new GroupBuyAtyHeaderAdapter(this, mDatas);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == mDatas.size() || (position == 5 && !mHeaderAdapter.isExpanded()))
                    return 5;
                return 1;
            }
        });
        headerRecyclerView.setItemAnimator(new FadeInDownAnimator());
        headerRecyclerView.setLayoutManager(gridLayoutManager);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mHeaderAdapter);
//        alphaAdapter.setFirstOnly(true);
        alphaAdapter.setDuration(500);
        alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
        headerRecyclerView.setAdapter(mHeaderAdapter);
        mAdapter.addHeaderView(headerView);
    }

    @Override
    public void initData() {
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CART_GETHOTBRAND)
                .params(null, Contstant.CART_GETHOTBRAND)
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

                        Log.d("GroupBuyActivity", "处理热门品牌" + response);
                        Gson gson = new Gson();
                        List<CartGethotbrandBean.DataBean> hotBrandBean
                                = gson.fromJson(response, CartGethotbrandBean.class).getData();
                        mDatas.clear();
                        mDatas.addAll(hotBrandBean);

                        mHeaderAdapter.notifyDataSetChanged();
                        mAdapter.setNewData(mDatas);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：CART_GETBRAND————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

        //列表数据、
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("brandid","");
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.PURCHASE_GROUP_BRANDLIST)
                .params(map, Contstant.PURCHASE_GROUP_BRANDLIST)
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

                        Log.d("GroupBuyActivity", "PURCHASE_GROUP_BRANDLIST" + response);


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：PURCHASE_GROUP_BRANDLIST————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
