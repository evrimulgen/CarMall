package com.loading.carmall.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.weiget.multislider.MultiSlider;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FindCarFragment extends BaseFrg {


    @Bind(R.id.iv_search)
    ImageView mIvSearch;
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.tv_reset)
    TextView mTvReset;
    @Bind(R.id.toolbar_common)
    FrameLayout mToolbarCommon;
    @Bind(R.id.tv_all_brand)
    TextView mTvAllBrand;
    @Bind(R.id.rv_brand)
    RecyclerView mRvBrand;
    @Bind(R.id.tv_price_range)
    TextView mTvPriceRange;
    @Bind(R.id.range_slider)
    MultiSlider mRangeSlider;

    public FindCarFragment() {
    }

    public static FindCarFragment newInstance() {

        Bundle args = new Bundle();

        FindCarFragment fragment = new FindCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_car, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void initView() {
        //品牌
        mRvBrand.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        BaseQuickAdapter<Status, BaseViewHolder> brandAdapter
                = new BaseQuickAdapter<Status, BaseViewHolder>
                (R.layout.item_find_car_fra_brand, DataServer.getSampleData(10)) {
            @Override
            protected void convert(BaseViewHolder helper, Status item) {


            }
        };
        brandAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRvBrand.setAdapter(brandAdapter);

        //价格范围
        mTvPriceRange.setText(mRangeSlider.getThumb(0).getValue() + "-"
                + mRangeSlider.getThumb(1).getValue() + "万");
        mRangeSlider.setOnThumbValueChangeListener(new MultiSlider.SimpleChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb,
                                       int thumbIndex, int value) {
                if (thumbIndex == 0) {
                    //动左面的
                    mTvPriceRange.setText(String.valueOf(value) + "-" +
                            mRangeSlider.getThumb(1).getValue() + "万");
                } else {
                    mTvPriceRange.setText(mRangeSlider.getThumb(0).getValue() + "-"
                            + String.valueOf(value) + "万");
                }
            }
        });
    }

    @Override
    public void initData() {

    }
}
