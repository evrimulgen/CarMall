package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.ui.weiget.flowlayout.FlowLayout;
import com.loading.carmall.ui.weiget.flowlayout.TagAdapter;
import com.loading.carmall.ui.weiget.flowlayout.TagFlowLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



/**
 * Created by 马小布 on 2017/4/17.
 * Project : 润付通汽车商城
 * Program Name :  com.loading.carmall.ui.activity.SubmitOrderActivity.java
 * Author :马庆龙 on 2017/4/17 11:17
 * email:maxiaobu1999@163.com
 * 功能：提交订单
 * 伪码：
 * 待完成：
 */
public class SubmitOrderActivity extends BaseAty implements View.OnClickListener {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_model)
    TextView mTvModel;
    @Bind(R.id.tv_discount)
    TextView mTvDiscount;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.iv_appearance_color)
    ImageView mIvAppearanceColor;
    @Bind(R.id.iv_appearance_arrow)
    ImageView mIvAppearanceArrow;
    @Bind(R.id.tv_appearance_content)
    TextView mTvAppearanceContent;
    @Bind(R.id.ly_appearance_color)
    RelativeLayout mLyAppearanceColor;
    @Bind(R.id.iv_interior_appearance_color)
    ImageView mIvInteriorAppearanceColor;
    @Bind(R.id.iv_interior_appearance_arrow)
    ImageView mIvInteriorAppearanceArrow;
    @Bind(R.id.tv_interior_appearance_content)
    TextView mTvInteriorAppearanceContent;
    @Bind(R.id.ly_interior_color)
    RelativeLayout mLyInteriorColor;
    @Bind(R.id.iv_car_city_color)
    ImageView mIvCarCityColor;
    @Bind(R.id.iv_car_city_arrow)
    ImageView mIvCarCityArrow;
    @Bind(R.id.tv_car_city_content)
    TextView mTvCarCityContent;
    @Bind(R.id.ly_car_city_color)
    RelativeLayout mLyCarCityColor;
    @Bind(R.id.iv_brand_city_color)
    ImageView mIvBrandCityColor;
    @Bind(R.id.iv_brand_city_arrow)
    ImageView mIvBrandCityArrow;
    @Bind(R.id.tv_city_content)
    TextView mTvCityContent;
    @Bind(R.id.ly_brand_city_color)
    RelativeLayout mLyBrandCityColor;
    @Bind(R.id.tv_submit)
    TextView mTvSubmit;
    @Bind(R.id.tv_price_title)
    TextView mTvPriceTitle;
    @Bind(R.id.iv_price_title)
    ImageView mIvPriceTitle;
    @Bind(R.id.tv_model_price)
    TextView mTvModelPrice;
    @Bind(R.id.tv_price_describe)
    TextView mTvPriceDescribe;
    @Bind(R.id.tv_describe)
    TextView mTvDescribe;
    @Bind(R.id.iv_delete)
    ImageView mIvDelete;
    @Bind(R.id.tv_model_type)
    TextView mTvModelType;
    @Bind(R.id.flow_layout)
    TagFlowLayout mFlowLayout;
    @Bind(R.id.iv_model_goods)
    ImageView mIvModelGoods;
    @Bind(R.id.tv_complete)
    TextView mTvComplete;
    @Bind(R.id.ly_model)
    FrameLayout mLyModel;
    @Bind(R.id.ly_background)
    FrameLayout mLyBackground;
    @Bind(R.id.container)
    FrameLayout mContainer;
    @Bind(R.id.imageView)
    ImageView mImageView;
    @Bind(R.id.tv_prompt_one)
    TextView mTvPromptOne;
    @Bind(R.id.ly_prompt_one)
    LinearLayout mLyPromptOne;
    @Bind(R.id.tv_prompt_two)
    TextView mTvPromptTwo;
    @Bind(R.id.ly_prompt_two)
    LinearLayout mLyPromptTwo;
    @Bind(R.id.tv_eposit)
    TextView mTvEposit;
    private String[] mVals = new String[]
            {"深赤色", "深橙色", "深红色 ", "深绿色", "深青色", "深蓝色"};
    private boolean mIsModelShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "提交订单");
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mActivity)
                        .inflate(R.layout.item_submit_order_model,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
//        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
//            @Override
//            public void onSelected(Set<Integer> selectPosSet) {
//
//            }
//        });
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(mActivity   , mVals[position], Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_complete, R.id.ly_appearance_color, R.id.iv_delete, R.id.ly_background
    ,R.id.tv_submit})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_complete:
                //规格弹窗完成
                break;
            case R.id.ly_appearance_color:
                showModel();
                break;
            case R.id.iv_delete:
            case R.id.ly_background:
                hideModel();
                break;
            //提交
            case R.id.tv_submit:
                startActivity(new Intent(this,PayDepositActivity.class));
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if (mIsModelShow) {
            hideModel();
        } else {
            super.onBackPressed();
        }

    }

    /**
     * 隐藏规格弹窗
     */
    private void hideModel() {
        mLyBackground.setVisibility(View.GONE);
        mLyModel.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_menu_out));
        mLyBackground.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_mask_out));
        mIsModelShow = false;

    }

    /**
     * 显示规格弹窗
     */
    private void showModel() {
        mLyBackground.setVisibility(View.VISIBLE);
        mLyModel.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_menu_in));
        mLyBackground.setAnimation(AnimationUtils.loadAnimation(this, R.anim.dd_mask_in));
        mIsModelShow = true;
    }
}
