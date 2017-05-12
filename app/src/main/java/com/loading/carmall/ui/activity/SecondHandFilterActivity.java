package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CheckTextAdapter;
import com.loading.carmall.adapter.LevelTypeAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.LevelTypeBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceRecyclerView;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceSelectionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondHandFilterActivity extends BaseAty {
    @Bind(R.id.tv_cancel)
    TextView mTvCancel;
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    FrameLayout mToolbarCommon;
    @Bind(R.id.rv_level)
    MultiChoiceRecyclerView mRvLevel;
    @Bind(R.id.rv_gearbox)
    MultiChoiceRecyclerView mRvGearbox;
    @Bind(R.id.rv_age)
    MultiChoiceRecyclerView mRvAge;
    @Bind(R.id.rv_distance)
    MultiChoiceRecyclerView mRvDistance;
    @Bind(R.id.rv_displacement)
    MultiChoiceRecyclerView mRvDisplacement;
    @Bind(R.id.rv_country)
    MultiChoiceRecyclerView mRvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_filter);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    @Override
    public void initView() {
        //级别
        mRvLevel.setRecyclerColumnNumber(3);
        mRvLevel.setSingleClickMode(true);
        mRvLevel.setHasFixedSize(true);
        List<LevelTypeBean> levelDatas = getLevelDatas(Contstant.LEVE_LICONS, Contstant.LEVEL_TITLES);
        LevelTypeAdapter levelAdapter = new LevelTypeAdapter(mActivity,
                R.layout.item_find_car_fra_level, levelDatas);
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

        //变速箱
        mRvGearbox.setRecyclerColumnNumber(4);
        mRvGearbox.setSingleClickMode(true);
        CheckTextAdapter gearboxAdapter = new CheckTextAdapter(Contstant.LEVEL_GEARBOX, App.getInstance()
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

        //车龄
        mRvAge.setRecyclerColumnNumber(4);
        mRvAge.setSingleClickMode(true);
        CheckTextAdapter ageboxAdapter = new CheckTextAdapter(Contstant.LEVEL_AGES, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvAge.setAdapter(ageboxAdapter);
        mRvAge.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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

        //公里数
        mRvDistance.setRecyclerColumnNumber(4);
        mRvDistance.setSingleClickMode(true);
        CheckTextAdapter distanceAdapter = new CheckTextAdapter(Contstant.LEVEL_DISTANCE, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvDistance.setAdapter(distanceAdapter);
        mRvDistance.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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
        CheckTextAdapter displacementAdapter = new CheckTextAdapter(Contstant.LEVEL_DISPLACEMENT, App.getInstance()
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

        //国别
        mRvCountry.setRecyclerColumnNumber(4);
        mRvCountry.setSingleClickMode(true);
        CheckTextAdapter countryAdapter = new CheckTextAdapter(Contstant.LEVEL_COUNTRIES, App.getInstance()
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
    }

    @Override
    public void initData() {

    }

    /**
     * 汽车级别数据
     *
     * @param icons  图标
     * @param titles 标题
     * @return bean
     */
    public List<LevelTypeBean> getLevelDatas(int[] icons, String[] titles) {
        ArrayList<LevelTypeBean> levelTypeBeens = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            LevelTypeBean levelTypeBean = new LevelTypeBean();
            levelTypeBean.setIcon(icons[i]);
            levelTypeBean.setTitle(titles[i]);
            levelTypeBean.setChecked(false);
            levelTypeBeens.add(levelTypeBean);
        }
        return levelTypeBeens;
    }
}
