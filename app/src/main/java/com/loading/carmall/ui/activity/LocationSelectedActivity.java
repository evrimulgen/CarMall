package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.LocationSelectedAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.LocationSelectedHeaderBean;
import com.loading.carmall.mock.CommonAdapter;
import com.loading.carmall.mock.HeaderRecyclerAndFooterWrapperAdapter;
import com.loading.carmall.mock.MeiTuanBean;
import com.loading.carmall.mock.MeituanHeaderBean;
import com.loading.carmall.mock.ViewHolder;
import com.loading.carmall.service.LocationService;
import com.loading.carmall.ui.weiget.indexbar.DividerItemDecoration;
import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;
import com.loading.carmall.ui.weiget.indexbar.suspension.SuspensionDecoration;
import com.loading.carmall.ui.weiget.indexbar.widget.IndexBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LocationSelectedActivity extends BaseAty {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.indexBar)
    IndexBar mIndexBar;
    @Bind(R.id.tvSideBarHint)
    TextView mTvSideBarHint;


    private LocationSelectedAdapter mAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mHeaderAdapter;
    private LinearLayoutManager mManager;

    //设置给InexBar、ItemDecoration的完整数据集
    private List<BaseIndexPinyinBean> mSourceDatas;
    //头部数据源
    private List<LocationSelectedHeaderBean> mHeaderDatas;
    //主体部分数据源（城市数据）
    private List<MeiTuanBean> mBodyDatas;

    private SuspensionDecoration mDecoration;

    /**
     * 定位服务
     */
    private LocationService locationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selected);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //处理定位
        locationService = App.getInstance().locationService;
        locationService.registerListener(mListener);
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        locationService.start();
    }

    @Override
    protected void onStop() {
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(mManager = new LinearLayoutManager(this));

        mSourceDatas = new ArrayList<>();
        mHeaderDatas = new ArrayList<>();
        List<String> locationCity = new ArrayList<>();
        locationCity.add("定位中");
        mHeaderDatas.add(new LocationSelectedHeaderBean(locationCity, "你所在的地区", "定"));
        List<String> hotCitys = new ArrayList<>();
        mHeaderDatas.add(new LocationSelectedHeaderBean(hotCitys, "国内热门城市", "热"));
        mSourceDatas.addAll(mHeaderDatas);

        mAdapter = new LocationSelectedAdapter(this, R.layout.item_location_selected, mBodyDatas);
        mHeaderAdapter = new HeaderRecyclerAndFooterWrapperAdapter(mAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
                switch (layoutId) {
                    case R.layout.meituan_item_header:
                        final LocationSelectedHeaderBean meituanHeaderBean = (LocationSelectedHeaderBean) o;
                        //网格
                        RecyclerView recyclerView = holder.getView(R.id.rvCity);
                        recyclerView.setAdapter(
                                new CommonAdapter<String>(mActivity, R.layout.meituan_item_header_item, meituanHeaderBean.getCityList()) {
                                    @Override
                                    public void convert(ViewHolder holder, final String cityName) {
                                        holder.setText(R.id.tvName, cityName);
                                        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Toast.makeText(mContext, "cityName:" + cityName, Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                        recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
                        break;
                    default:
                        break;
                }
            }
        };
        mHeaderAdapter.setHeaderView(1, R.layout.meituan_item_header, mHeaderDatas.get(0));
        mHeaderAdapter.setHeaderView(2, R.layout.meituan_item_header, mHeaderDatas.get(1));


        mRecyclerView.setAdapter(mHeaderAdapter);
        mRecyclerView.addItemDecoration(mDecoration = new SuspensionDecoration(this, mSourceDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 22, getResources().getDisplayMetrics()))//设置abc标题高度
                .setColorTitleBg(getResources().getColor(R.color.backgroundGray))
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics()))//设置abc标题字体大小
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size()));

        //使用indexBar
        mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar

        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size());
        initDatas(getResources().getStringArray(R.array.provinces));


    }

    @Override
    public void initData() {

    }

    /**
     * 组织数据源
     *
     * @param data
     * @return
     */
    private void initDatas(final String[] data) {
        //延迟两秒 模拟加载数据中....
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBodyDatas = new ArrayList<>();
                for (int i = 0; i < data.length; i++) {
                    MeiTuanBean cityBean = new MeiTuanBean();
                    cityBean.setCity(data[i]);//设置城市名称
                    mBodyDatas.add(cityBean);
                }
                //先排序
                mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);

                mAdapter.setDatas(mBodyDatas);
                mHeaderAdapter.notifyDataSetChanged();
                mSourceDatas.addAll(mBodyDatas);

                mIndexBar.setmSourceDatas(mSourceDatas)//设置数据
                        .invalidate();
                mDecoration.setmDatas(mSourceDatas);
            }
        }, 1000);

        //延迟两秒加载头部
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                LocationSelectedHeaderBean header1 = mHeaderDatas.get(0);
//                header1.getCityList().clear();
//                header1.getCityList().add("上海");

//                LocationSelectedHeaderBean header3 = mHeaderDatas.get(1);
//                List<String> hotCitys = new ArrayList<>();
//                hotCitys.add("上海");
//                hotCitys.add("北京");
//                hotCitys.add("杭州");
//                hotCitys.add("广州");
//                header3.setCityList(hotCitys);
//
//                mHeaderAdapter.notifyItemRangeChanged(1, 3);
//
//            }
//        }, 2000);
    }

    /*****
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Log.d("LocationSelectedActivit", "+++++++++++++++++++++");
            if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
                StringBuilder sb = new StringBuilder(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(bdLocation.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(bdLocation.getLocType());
                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
                sb.append(bdLocation.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(bdLocation.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(bdLocation.getLongitude());
                sb.append("\nradius : ");// 半径
                sb.append(bdLocation.getRadius());
                sb.append("\nCountryCode : ");// 国家码
                sb.append(bdLocation.getCountryCode());
                sb.append("\nCountry : ");// 国家名称
                sb.append(bdLocation.getCountry());
                sb.append("\ncitycode : ");// 城市编码
                sb.append(bdLocation.getCityCode());
                sb.append("\ncity : ");// 城市
                sb.append(bdLocation.getCity());
                sb.append("\nDistrict : ");// 区
                sb.append(bdLocation.getDistrict());
                sb.append("\nStreet : ");// 街道
                sb.append(bdLocation.getStreet());
                sb.append("\naddr : ");// 地址信息
                sb.append(bdLocation.getAddrStr());
                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
                sb.append(bdLocation.getUserIndoorState());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(bdLocation.getDirection());// 方向
                sb.append("\nbdLocationdescribe: ");
                sb.append(bdLocation.getLocationDescribe());// 位置语义化信息
                sb.append("\nPoi: ");// POI信息
                if (bdLocation.getPoiList() != null && !bdLocation.getPoiList().isEmpty()) {
                    for (int i = 0; i < bdLocation.getPoiList().size(); i++) {
                        Poi poi = (Poi) bdLocation.getPoiList().get(i);
                        sb.append(poi.getName() + ";");
                    }
                }
                if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    sb.append("\nspeed : ");
                    sb.append(bdLocation.getSpeed());// 速度 单位：km/h
                    sb.append("\nsatellite : ");
                    sb.append(bdLocation.getSatelliteNumber());// 卫星数目
                    sb.append("\nheight : ");
                    sb.append(bdLocation.getAltitude());// 海拔高度 单位：米
                    sb.append("\ngps status : ");
                    sb.append(bdLocation.getGpsAccuracyStatus());// *****gps质量判断*****
                    sb.append("\ndescribe : ");
                    sb.append("gps定位成功");
                } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    // 运营商信息
                    if (bdLocation.hasAltitude()) {// *****如果有海拔高度*****
                        sb.append("\nheight : ");
                        sb.append(bdLocation.getAltitude());// 单位：米
                    }
                    sb.append("\noperationers : ");// 运营商信息
                    sb.append(bdLocation.getOperators());
                    sb.append("\ndescribe : ");
                    sb.append("网络定位成功");
                } else if (bdLocation.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    sb.append("\ndescribe : ");
                    sb.append("离线定位成功，离线定位结果也是有效的");
                } else if (bdLocation.getLocType() == BDLocation.TypeServerError) {
                    sb.append("\ndescribe : ");
                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkException) {
                    sb.append("\ndescribe : ");
                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
                } else if (bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
                    sb.append("\ndescribe : ");
                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }
                Log.d("LocationSelectedActivit", bdLocation.getCity());
                Log.d("LocationSelectedActivit", sb.toString());
            }
        }

        public void onConnectHotSpotMessage(String s, int i) {
        }
    };
}
