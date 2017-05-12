package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.listener.OnItemClickListener;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondHandBuyActivity extends BaseAty implements
        BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.iv_sequence_arrow)
    ImageView mIvSequenceArrow;
    @Bind(R.id.iv_brand_arrow)
    ImageView mIvBrandArrow;
    @Bind(R.id.iv_price_arrow)
    ImageView mIvPriceArrow;
    @Bind(R.id.iv_filter_arrow)
    ImageView mIvFilterArrow;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.ly_sequence)
    LinearLayout mLySequence;
    @Bind(R.id.ly_brand)
    LinearLayout mLyBrand;
    @Bind(R.id.ly_price)
    LinearLayout mLyPrice;
    @Bind(R.id.ly_filter)
    LinearLayout mLyFilter;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.rv_select)
    RecyclerView mRvSelect;
    @Bind(R.id.fl_select)
    FrameLayout mFlSelect;

    public enum MenuType {
        HIDE,
        SEQUENCE,
        PRICE

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_buy);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.backgroundOrange));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        BaseQuickAdapter<Status, BaseViewHolder> adapter = new BaseQuickAdapter<Status,
                BaseViewHolder>(R.layout.item_second_hand_aty, DataServer.getSampleData(30)) {
            @Override
            protected void convert(BaseViewHolder helper, Status item) {
                int position = helper.getLayoutPosition();
            }
        };
        adapter.setOnLoadMoreListener(this, mRecyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(mActivity, Integer.toString(position),
                        Toast.LENGTH_LONG).show();
            }
        });

        mFlSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(MenuType.HIDE);
            }
        });
        mLySequence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(MenuType.SEQUENCE);
            }
        });
        mLyPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(MenuType.PRICE);
            }
        });
        mLyBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(MenuType.HIDE);
                startActivityForResult(new Intent(mActivity, SecondHandBrandActivity.class), 0x001);
            }
        });
        mLyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(MenuType.HIDE);
                startActivityForResult(new Intent(mActivity, SecondHandFilterActivity.class), 0x002);
            }
        });

    }


    // 0刷新  1加载
    private int mDataType;
    private int[] menuIcons;
    private String[] menuTitles;
    // 0隐藏；1排序；2价格
    private MenuType mMenuType;
    /**
     * 请求参数：排序
     * sorttype: 按好评(evascore)、按热度(coursetimes), 不排序不传值
     */
    private String mSortType;
    /**
     * 请求参数：筛选
     * 1男；2女；3不限
     */
    private int mFilterType = -1;

    /**
     * 显示/隐藏筛选列表
     *
     * @param menuType 0隐藏   1排序  2价格
     */
    private void switchMenu(final MenuType menuType) {
        if (menuType == MenuType.HIDE) {
            //隐藏
            mMenuType = menuType;
            setMenuBackgroud();
            mRvSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_menu_up_out));
            mFlSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_mask_out));
            mFlSelect.setVisibility(View.GONE);
        } else if (menuType == mMenuType) {
            //再次点击
            mMenuType = MenuType.HIDE;
            setMenuBackgroud();
            mRvSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_menu_up_out));
            mFlSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_mask_out));
            mFlSelect.setVisibility(View.GONE);
        } else {
            //显示
            mFlSelect.setVisibility(View.VISIBLE);
            mRvSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_menu_up_in));
            mFlSelect.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_mask_in));
            mRvSelect.setLayoutManager(new LinearLayoutManager(mActivity));
            if (menuType == MenuType.SEQUENCE) {//排序
                mMenuType = menuType;
                setMenuBackgroud();
//                menuIcons = new int[]{R.mipmap.icon_juli, R.mipmap.icon_haoping, R.mipmap.icon_redu, R.mipmap.icon_buxian};
                menuTitles = new String[]{"默认排序", "价格从高到低", "价格从低到高", "最新发布", "最短里程", "车龄最短"};
                BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter
                        = new BaseQuickAdapter<String, BaseViewHolder>(
                        R.layout.item_second_hand_aty_fliter, Arrays.asList(menuTitles)) {
                    @Override
                    protected void convert(BaseViewHolder helper, String item) {
                        int position = helper.getAdapterPosition();
                        TextView textView = helper.getView(R.id.text_view);
                        textView.setText(item);
                        if (position == mFilterType) {
                            ImageView ivRight = helper.getView(R.id.iv_right);
                            ivRight.setVisibility(View.VISIBLE);
                        }
                    }
                };
                baseQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener<String>() {
                    @Override
                    public void onItemClick(BaseQuickAdapter<String, ? extends BaseViewHolder> adapter
                            , View view, int position) {
                        mFilterType = position;
                        switchMenu(MenuType.HIDE);

                    }
                });
                mRvSelect.setAdapter(baseQuickAdapter);
            } else if (menuType == MenuType.PRICE) {//筛选
                mMenuType = menuType;
                setMenuBackgroud();
//                menuIcons = new int[]{R.mipmap.icon_juli, R.mipmap.icon_haoping, R.mipmap.icon_redu, R.mipmap.icon_buxian};
                menuTitles = new String[]{"默认排序", "价格从高到低", "价格从低到高", "最新发布", "最短里程", "车龄最短"};
                BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter
                        = new BaseQuickAdapter<String, BaseViewHolder>(
                        R.layout.item_second_hand_aty_fliter, Arrays.asList(menuTitles)) {
                    @Override
                    protected void convert(BaseViewHolder helper, String item) {
                        int position = helper.getAdapterPosition();
                        TextView textView = helper.getView(R.id.text_view);
                        textView.setText(item);
                        if (position == mFilterType) {
                            ImageView ivRight = helper.getView(R.id.iv_right);
                            ivRight.setVisibility(View.VISIBLE);
                        }
                    }
                };
                View headView = getLayoutInflater().inflate(R.layout.item_second_hand_aty_fliter_header,
                        (ViewGroup) mRecyclerView.getParent(), false);
                baseQuickAdapter.addHeaderView(headView);
                baseQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener<String>() {
                    @Override
                    public void onItemClick(BaseQuickAdapter<String, ? extends BaseViewHolder> adapter
                            , View view, int position) {
                        mFilterType = position;
                        switchMenu(MenuType.HIDE);

                    }
                });
                mRvSelect.setAdapter(baseQuickAdapter);
            }
        }
    }

    public void setMenuBackgroud() {
        if (mMenuType == MenuType.SEQUENCE) {
            //排序
            mIvSequenceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_up));
            mIvPriceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_down));
        } else if (mMenuType == MenuType.PRICE) {
            mIvPriceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_up));
            mIvSequenceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_down));
        } else {
            mIvPriceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_down));
            mIvSequenceArrow.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.ic_triangle_down));
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onRefresh() {

    }
    @Override
    public void onBackPressed() {
        if (mFlSelect.getVisibility() == View.VISIBLE) {
            switchMenu(MenuType.HIDE);
        } else {
            super.onBackPressed();
        }
    }
}
