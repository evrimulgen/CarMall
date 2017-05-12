package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loading.carmall.R;
import com.loading.carmall.adapter.HomeFrgAdapter;
import com.loading.carmall.adapter.SecondHandBrandAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.bean.IndexCarFindBean;
import com.loading.carmall.mock.HeaderRecyclerAndFooterWrapperAdapter;
import com.loading.carmall.mock.ViewHolder;
import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;
import com.loading.carmall.ui.weiget.indexbar.suspension.SecondHandSuspensionDecoration;
import com.loading.carmall.ui.weiget.indexbar.widget.HomeIndexBar;
import com.loading.carmall.utils.IndexCarFind;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondHandBrandActivity extends BaseAty {

    @Bind(R.id.tv_cancel)
    TextView mTvCancel;
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    FrameLayout mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.indexBar)
    HomeIndexBar mIndexBar;
    @Bind(R.id.tvSideBarHint)
    TextView mTvSideBarHint;
    @Bind(R.id.ly_bottom)
    LinearLayout mLyBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_brand);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    private void initClick() {
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });


    }

    /**
     * 设置给InexBar、ItemDecoration的完整数据集
     */
    private List<BaseIndexPinyinBean> mDatas;
    /**
     * 主体部分数据源（汽车品牌数据）
     */
    private List<HomeFrgBodyBean> mBodyDatas;
    //内部的的普通Adapter
    private SecondHandBrandAdapter mBodyAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private SecondHandSuspensionDecoration mDecoration;

    @Override
    public void initView() {
        mDatas = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //处理身布局
        mBodyAdapter = new SecondHandBrandAdapter(mActivity, R.layout.item_second_hand_brand_aty, mBodyDatas);
        mAdapter = new HomeFrgAdapter(mActivity, mBodyAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos
                    , int layoutId, Object o) {
            }
        };
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(mDecoration = new SecondHandSuspensionDecoration(mActivity, mDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 26, getResources().getDisplayMetrics()))//设置abc标题高度
                .setColorTitleBg(getResources().getColor(R.color.backgroundGray))
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()))
                .setHeaderViewCount(mAdapter.getHeaderViewCount()));
        //使用indexBar
        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mLayoutManager)//设置RecyclerView的LayoutManager
                .setHeaderViewCount(mAdapter.getHeaderViewCount());
        initDatas();
    }

    @Override
    public void initData() {

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
            mBodyDatas.add(cityBean);
        }
        //先排序
        mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);
//
        mBodyAdapter.setDatas(mBodyDatas);
        mAdapter.notifyDataSetChanged();
        mDatas.addAll(mBodyDatas);

        mIndexBar.setmSourceDatas(mDatas)//设置数据
                .invalidate();
        mDecoration.setmDatas(mDatas);

    }
}
