package com.loading.carmall.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.BrandDetailBodyAdapter;
import com.loading.carmall.adapter.HomeFrgAdapter;
import com.loading.carmall.adapter.HomeFrgBodyAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.bean.IndexCarFindBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.indexbar.DividerItemDecoration;
import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;
import com.loading.carmall.ui.weiget.indexbar.suspension.BrandDetailDecoration;
import com.loading.carmall.utils.IndexCarFind;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;


public class BrandDetailActivity extends BaseAty implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private List<BaseIndexPinyinBean> mDatas;
    //主体部分数据源（汽车品牌数据）
    private List<HomeFrgBodyBean> mBodyDatas;
    private BrandDetailBodyAdapter mBodyAdapter;
    HomeFrgAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private BrandDetailDecoration mDecoration;

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "奥迪");

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mActivity, R.color.backgroundOrange));

        mDatas = new ArrayList<>();
        mBodyDatas = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mBodyAdapter = new BrandDetailBodyAdapter(mActivity, R.layout.item_brand_detail_aty, mBodyDatas);
        mAdapter = new HomeFrgAdapter(mActivity, mBodyAdapter);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(mDecoration = new BrandDetailDecoration(mActivity, mDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        36, getResources().getDisplayMetrics()))//设置abc标题高度
                .setColorTitleBg(Color.parseColor("#efeef3"))
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                        16, getResources().getDisplayMetrics()))
                .setHeaderViewCount(mAdapter.getHeaderViewCount()));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));

        initDatas();
    }

    /**
     * 汽车品牌数据
     */
    void initDatas() {
        Gson gson = new Gson();
        IndexCarFind indexCarFind = new IndexCarFind();
        IndexCarFindBean indexCarFindBean = gson.fromJson(indexCarFind.getIndexCarFind(), IndexCarFindBean.class);
        List<IndexCarFindBean.ResultBean.DetailBean> detail = indexCarFindBean.getResult().getDetail();
        mBodyDatas = new ArrayList<>();
        for (int i = 0; i < detail.size(); i++) {
            IndexCarFindBean.ResultBean.DetailBean detailBean = detail.get(i);
            HomeFrgBodyBean cityBean = new HomeFrgBodyBean();
            cityBean.setIcon(indexCarFind.getBaseImg() + detailBean.getImageSrc());
//                    Log.d("HomeFragment", indexCarFind.getBaseImg() + detailBean.getImageSrc());
            cityBean.setCity(detailBean.getName());//设置汽车名称
//            cityBean.setBaseIndexPinyin(detailBean.getFirstLetter());
            cityBean.setBaseIndexTag(detailBean.getFirstLetter());
            mBodyDatas.add(cityBean);
        }
        //先排序
//
        mBodyAdapter.setDatas(mBodyDatas);

        mDatas.addAll(mBodyDatas);
        mDecoration.setmDatas(mDatas);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
        String url = UrlPath.CART_CART_TYPE;
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("brandid", "1");
        OkHttpUtils//
                .post()
                .tag(this)
                .url(url)
                .params(map, Contstant.CART_CART_TYPE)
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
                        //{"data":{"0":true,"brandname":"修改奥迪","list":{"一汽奥迪":[{"id":1,"name":"本田8965号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg","model_price":"80-90万","car_name":"一汽奥迪"},{"id":6,"name":"本田9号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","model_price":"80-90万","car_name":"一汽奥迪"},{"id":7,"name":"本田135号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170510\/191049110083f8e79295b368de5b0915.jpg","model_price":"80-90万","car_name":"一汽奥迪"},{"id":8,"name":"本田56号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/5cb8e3a670453579dc0a1806693bcd48.jpg","model_price":"80-36万","car_name":"一汽奥迪"},{"id":9,"name":"本田58sw号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/e2f1808aeabf7b6165ddd377df49b7e7.jpg","model_price":"33.3-55.5万","car_name":"一汽奥迪"},{"id":11,"name":"本田1wd号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/74cffefac003782ae4816ffac2fb9260.jpg","model_price":"80-36万","car_name":"一汽奥迪"},{"id":12,"name":"本田213号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/c32429d783a75897c185324ee893baa3.jpg","model_price":"33.3-55.5万","car_name":"一汽奥迪"},{"id":13,"name":"本田213号","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170510\/763ed0ec142450367cc7e274e9c77da3.jpg","model_price":"33.3-55.5万","car_name":"一汽奥迪"},{"id":26,"name":"就是这个","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/560da4fef81f78892fff3f9565770dd2.jpg","model_price":"80-90万","car_name":"一汽奥迪"}],"天津奥迪":[],"北京奥迪":[]}}}
                        Log.d("HomeFragment", "CART_CART_TYPE：" + response);

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：CART_CART_TYPE————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onRefresh() {

    }
}
