package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayDepositActivity extends BaseAty implements View.OnClickListener {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.imageView)
    ImageView mImageView;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_model)
    TextView mTvModel;
    @Bind(R.id.tv_discount_one)
    TextView mTvDiscountOne;
    @Bind(R.id.tv_discount_two)
    TextView mTvDiscountTwo;
    @Bind(R.id.tv_discount_three)
    TextView mTvDiscountThree;
    @Bind(R.id.textView)
    TextView mTextView;
    @Bind(R.id.iv_weixin)
    ImageView mIvWeixin;
    @Bind(R.id.cb_weixin)
    CheckBox mCbWeixin;
    @Bind(R.id.ly_weixin)
    RelativeLayout mLyWeixin;
    @Bind(R.id.iv_alipay)
    ImageView mIvAlipay;
    @Bind(R.id.tv_alipay)
    TextView mTvAlipay;
    @Bind(R.id.cb_alipay)
    CheckBox mCbAlipay;
    @Bind(R.id.ly_alipay)
    RelativeLayout mLyAlipay;
    @Bind(R.id.iv_unionpay)
    ImageView mIvUnionpay;
    @Bind(R.id.cb_unionpay)
    CheckBox mCbUnionpay;
    @Bind(R.id.ly_unionpay)
    RelativeLayout mLyUnionpay;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.tv_submit)
    TextView mTvSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_deposit);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "提交订单");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_submit})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                startActivity(new Intent(this, PaySuccessActivity.class));
                break;
            default:
                break;
        }
    }
}
