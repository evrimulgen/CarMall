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
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CheckImageAdapter;
import com.loading.carmall.adapter.CheckTextAdapter;
import com.loading.carmall.adapter.LevelTypeAdapter;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.bean.LevelTypeBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.activity.FilterResultsActivity;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceRecyclerView;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceSelectionListener;
import com.loading.carmall.ui.weiget.multislider.MultiSlider;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

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
    @Bind(R.id.rv_structure)
    MultiChoiceRecyclerView mRvStructure;
    @Bind(R.id.rv_company)
    MultiChoiceRecyclerView mRvCompany;
    @Bind(R.id.rv_air)
    MultiChoiceRecyclerView mRvAir;
    @Bind(R.id.rv_drive)
    MultiChoiceRecyclerView mRvDrive;
    @Bind(R.id.rv_setting)
    MultiChoiceRecyclerView mRvSetting;
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

        mTvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvCountry.deselectAll();
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
        mRvLevel.setHasFixedSize(true);
        List<LevelTypeBean> levelDatas = getLevelDatas(Contstant.LEVE_LICONS, Contstant.LEVEL_TITLES);
        LevelTypeAdapter levelAdapter = new LevelTypeAdapter(getActivity(),
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
        //能源
        mRvEnergy.setRecyclerColumnNumber(3);
        mRvEnergy.setSingleClickMode(true);
        CheckTextAdapter energyAdapter = new CheckTextAdapter(Contstant.LEVEL_ENERGY, App.getInstance()
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
        //座位数
        mRvSeat.setRecyclerColumnNumber(4);
        mRvSeat.setSingleClickMode(true);
        CheckTextAdapter seatAdapter = new CheckTextAdapter(Contstant.LEVEL_SEATS, App.getInstance()
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

        //结构 structure
        mRvStructure.setRecyclerColumnNumber(4);
        mRvStructure.setSingleClickMode(true);
        CheckTextAdapter structureAdapter = new CheckTextAdapter(Contstant.LEVEL_STRUCTURES, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvStructure.setAdapter(structureAdapter);
        mRvStructure.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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

        //生产厂商
        mRvCompany.setRecyclerColumnNumber(3);
        mRvCompany.setSingleClickMode(true);
        CheckTextAdapter companyAdapter = new CheckTextAdapter(Contstant.LEVEL_COMPANIES, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvCompany.setAdapter(companyAdapter);
        mRvCompany.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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

        //进气形式
        mRvAir.setRecyclerColumnNumber(3);
        mRvAir.setSingleClickMode(true);
        CheckTextAdapter airAdapter = new CheckTextAdapter(Contstant.LEVEL_AIRS, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvAir.setAdapter(airAdapter);
        mRvAir.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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
        //驱动方式
        mRvDrive.setRecyclerColumnNumber(3);
        mRvDrive.setSingleClickMode(true);
        CheckTextAdapter driveAdapter = new CheckTextAdapter(Contstant.LEVEL_DRIVES, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvDrive.setAdapter(driveAdapter);
        mRvDrive.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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

        //配置
        mRvSetting.setRecyclerColumnNumber(3);
        mRvSetting.setSingleClickMode(true);
        CheckTextAdapter settingAdapter = new CheckTextAdapter(Contstant.LEVEL_SETTINGS, App.getInstance()
                , R.layout.item_find_car_fra_country);
        mRvSetting.setAdapter(settingAdapter);
        mRvSetting.setMultiChoiceSelectionListener(new MultiChoiceSelectionListener() {
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
        //寻车
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("brandid", "1");
        OkHttpUtils
                .post()
                .tag(this)
                .url(UrlPath.CART_FIND_CART)
                .params(map, Contstant.CART_FIND_CART)
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
                        //{"data":{"0":true,"count":15,"list":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]}}
                        Log.d("FindCarFragment", "寻车接口:" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject data = jsonObject.getJSONObject("data");
                            String list = data.getString("list").replace("[", "").replace("]", "");
                            Log.d("FindCarFragment", list);
                            commit(list);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("FindCarFragment", e.toString());
                        Toast.makeText(getActivity(), "接口：CART_FIND_CART————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void commit(String list) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("list", list);
        OkHttpUtils
                .post()
                .tag(this)
                .url(UrlPath.CART_FIND_DETAIL)
                .params(map, Contstant.CART_FIND_DETAIL)
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
                        //{"data":{"0":true,"count":15,"list":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]}}
                        Log.d("FindCarFragment", "寻车列表接口:" + response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("FindCarFragment", e.toString());
                        Toast.makeText(getActivity(), "接口：CART_FIND_DETAIL————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
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
