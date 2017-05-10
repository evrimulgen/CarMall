package com.loading.carmall.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CheckImageAdapter;
import com.loading.carmall.adapter.CheckTextAdapter;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.ui.activity.FilterResultsActivity;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceRecyclerView;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceSelectionListener;
import com.loading.carmall.ui.weiget.multislider.MultiSlider;

import java.util.ArrayList;

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
    MultiChoiceRecyclerView mRvBrand;
    @Bind(R.id.tv_price_range)
    TextView mTvPriceRange;
    @Bind(R.id.range_slider)
    MultiSlider mRangeSlider;
    @Bind(R.id.rv_level)
    MultiChoiceRecyclerView mRvLevel;
    @Bind(R.id.rv_country)
    MultiChoiceRecyclerView mRvCountry;
    @Bind(R.id.rv_gearbox)
    MultiChoiceRecyclerView mRvGearbox;
    @Bind(R.id.rv_energy)
    MultiChoiceRecyclerView mRvEnergy;
    @Bind(R.id.rv_displacement)
    MultiChoiceRecyclerView mRvDisplacement;
    @Bind(R.id.rv_seat)
    MultiChoiceRecyclerView mRvSeat;
    @Bind(R.id.commit)
    RelativeLayout mCommit;
    private LayoutInflater mLayoutInflater;

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
        mLayoutInflater = inflater;
        View view = inflater.inflate(R.layout.fragment_find_car, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        initClick();
        return view;
    }

    private void initClick() {
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FilterResultsActivity.class));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private String[] mBrands = new String[]
            {"深赤色", "深橙色", "深红色 ", "深绿色", "深青色", "深蓝色", "a", "s", "w", "sad", "sdf"};

    @Override
    public void initView() {
        //品牌
        mRvBrand.setRecyclerColumnNumber(5);
        mRvBrand.setSingleClickMode(true);
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList.add(mBrands[i]);
        }
        CheckImageAdapter brandAdapter = new CheckImageAdapter(stringList, App.getInstance()
                , R.layout.item_find_car_fra_brand);
        mRvBrand.setAdapter(brandAdapter);
        mRvBrand.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });

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

        //级别
        mRvLevel.setRecyclerColumnNumber(3);
        mRvLevel.setSingleClickMode(true);
        ArrayList<String> stringList1 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList1.add(mBrands[i]);
        }
        CheckImageAdapter levelAdapter = new CheckImageAdapter(stringList1
                , App.getInstance(), R.layout.item_find_car_fra_level);
        mRvLevel.setAdapter(levelAdapter);
        mRvLevel.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:"
                        + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });

        //国别
        mRvCountry.setRecyclerColumnNumber(4);
        mRvCountry.setSingleClickMode(true);
        ArrayList<String> stringList2 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList2.add(mBrands[i]);
        }
        CheckTextAdapter countryAdapter = new CheckTextAdapter(stringList2, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvCountry.setAdapter(countryAdapter);
        mRvCountry.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });

        //变速箱
        mRvGearbox.setRecyclerColumnNumber(4);
        mRvGearbox.setSingleClickMode(true);
        ArrayList<String> stringList3 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList3.add(mBrands[i]);
        }
        CheckTextAdapter gearboxAdapter = new CheckTextAdapter(stringList3, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvGearbox.setAdapter(gearboxAdapter);
        mRvGearbox.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });
        //能源
        mRvEnergy.setRecyclerColumnNumber(4);
        mRvEnergy.setSingleClickMode(true);
        ArrayList<String> stringList4 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList4.add(mBrands[i]);
        }
        CheckTextAdapter energyAdapter = new CheckTextAdapter(stringList4, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvEnergy.setAdapter(energyAdapter);
        mRvEnergy.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });

        //排量
        mRvDisplacement.setRecyclerColumnNumber(4);
        mRvDisplacement.setSingleClickMode(true);
        ArrayList<String> stringList5 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList5.add(mBrands[i]);
        }
        CheckTextAdapter displacementAdapter = new CheckTextAdapter(stringList5, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvDisplacement.setAdapter(displacementAdapter);
        mRvDisplacement.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });
        //座位数
        mRvSeat.setRecyclerColumnNumber(4);
        mRvSeat.setSingleClickMode(true);
        ArrayList<String> stringList6 = new ArrayList<>();
        for (int i = 0; i < mBrands.length; i++) {
            stringList6.add(mBrands[i]);
        }
        CheckTextAdapter seatAdapter = new CheckTextAdapter(stringList6, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvSeat.setAdapter(seatAdapter);
        mRvSeat.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
            @Override
            public void OnItemSelected(int selectedPosition, int itemSelectedCount,
                                       int allItemCount) {
                Log.d("FindCarFragment", "selectedPosition:" + selectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnItemDeselected(int deselectedPosition, int itemSelectedCount,
                                         int allItemCount) {
                Log.d("FindCarFragment", "deselectedPosition:" + deselectedPosition
                        + "itemSelectedCount:" + itemSelectedCount + "allItemCount:" + allItemCount);
            }

            @Override
            public void OnSelectAll(int itemSelectedCount, int allItemCount) {

            }

            @Override
            public void OnDeselectAll(int itemSelectedCount, int allItemCount) {

            }
        });
    }

    @Override
    public void initData() {

    }
}
