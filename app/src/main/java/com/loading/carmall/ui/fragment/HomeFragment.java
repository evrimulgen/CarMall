package com.loading.carmall.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.HomeFrgHotBrandAdapter;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.bean.CartGetbrandBean;
import com.loading.carmall.bean.CartGethotbrandBean;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.bean.HomeHeaderBean;
import com.loading.carmall.bean.IndexCarFindBean;
import com.loading.carmall.bean.ShabiBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.mock.HeaderRecyclerAndFooterWrapperAdapter;
import com.loading.carmall.mock.HomeFrgBodyAdapter;
import com.loading.carmall.mock.Person;
import com.loading.carmall.mock.ViewHolder;
import com.loading.carmall.service.LocationService;
import com.loading.carmall.ui.activity.GoodsDetailActivity;
import com.loading.carmall.ui.activity.GroupBuyActivity;
import com.loading.carmall.ui.activity.LocationSelectedActivity;
import com.loading.carmall.ui.activity.NewCarsActivity;
import com.loading.carmall.ui.activity.SearchActivity;
import com.loading.carmall.ui.weiget.banner.BGABanner;
import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;
import com.loading.carmall.ui.weiget.indexbar.suspension.HomeSuspensionDecoration;
import com.loading.carmall.ui.weiget.indexbar.widget.HomeIndexBar;
import com.loading.carmall.ui.weiget.marquee.MarqueeFactory;
import com.loading.carmall.ui.weiget.marquee.MarqueeView;
import com.loading.carmall.ui.weiget.marquee.NoticeMF;
import com.loading.carmall.utils.IndexCarFind;
import com.loading.carmall.utils.WeakRefHander;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

public class HomeFragment extends BaseFrg implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.indexBar)
    HomeIndexBar mIndexBar;
    @Bind(R.id.tvSideBarHint)
    TextView mTvSideBarHint;
    @Bind(R.id.tv_location)
    TextView mTvLocation;
    @Bind(R.id.ly_location)
    LinearLayout mLyLocation;

    private static final int RECEIVE_LOCATION = 0x001;

    private final List<String> datas = Arrays.asList("《赋得古原草送别kjghksfjdghkjsfdhglkjsfhdgjkshfdkgjhsdflkjghklsfjdghlkjdfshgkjsdfhgjkshdfgjhdsfkljghslfkdhglkjsdfhgkjshfdgjksfhdkjghsfkdjghkfsldhgfdjkshgkjfdhsgkjfsdhgkhfdgkjh》", "六岁，芳华喜欢上了美少年韩启政二十四岁，韩启政跪在她面前发誓：“我想要娶的人只有你。” ", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeLayout;
    @Bind(R.id.ly_search)
    LinearLayout mLySearch;
    //内部的的普通Adapter
    private HomeFrgBodyAdapter mBodyAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private HomeSuspensionDecoration mDecoration;
    /**
     * 定位服务
     */
    private LocationService locationService;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("HomeFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HomeFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("HomeFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("HomeFragment", "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("HomeFragment", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("HomeFragment", "onStop");
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        Log.d("HomeFragment", "onDestroyView");
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(this);

        mHandler.clear();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        Log.d("HomeFragment", "onDestroy");
        super.onDestroy();
    }

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    WeakRefHander mHandler = new WeakRefHander(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
//            Toast.makeText(getActivity(), "msg.what:" + msg.what, Toast.LENGTH_SHORT).show();
            switch (msg.what) {
                case RECEIVE_LOCATION:
                    Bundle data = msg.getData();
                    String city = data.getString("city");
                    if (null != mTvLocation)
                        mTvLocation.setText(city);
                    break;
            }
            return false;
        }
    });

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("HomeFragment", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.d("HomeFragment", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    /**
     * 设置给InexBar、ItemDecoration的完整数据集
     */
    private List<BaseIndexPinyinBean> mDatas;
    /**
     * 头部数据源
     */
    private List<HomeHeaderBean> mHeaderDatas;
    /**
     * 主体部分数据源（汽车品牌数据）
     */
    private List<HomeFrgBodyBean> mBodyDatas;

    /**
     * 热门品牌数据
     */
    private List<CartGethotbrandBean.DataBean> mHotBrandBeans;

    @Override
    public void initView() {
        mDatas = new ArrayList<>();
        mHeaderDatas = new ArrayList<>();

        mHotBrandBeans = new ArrayList<>();
        mHeaderDatas.add(new HomeHeaderBean(mHotBrandBeans, "头部指示器", "#"));
        mDatas.addAll(mHeaderDatas);

        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.backgroundOrange));

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //处理身布局
        mBodyAdapter = new HomeFrgBodyAdapter(getActivity(), R.layout.item_home_frg_body, mBodyDatas);
        //处理头布局
        mAdapter = new HomeFrgAdapter(mBodyAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
                //O为mHeaderDatas第posation项
                switch (layoutId) {
                    case R.layout.item_home_header:
                        //findviewbyid
                        BGABanner mBanner = holder.getView(R.id.banner);
                        MarqueeView mMarqueeView = holder.getView(R.id.marqueeView);
                        RecyclerView mRvHotBrand = holder.getView(R.id.rv_hot_brand);
                        //处理banner
                        List<Integer> mIntegers = new ArrayList<>();
                        mIntegers.add(R.drawable.pic_01);
                        mIntegers.add(R.drawable.pic_02);
                        mIntegers.add(R.drawable.pic_lb);
                        mBanner.setDelegate(this);
                        mBanner.setAdapter(this);
                        mBanner.setData(mIntegers, null);
                        //热门品牌
                        // TODO: 2017/5/2 合并数据

                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
                        mRvHotBrand.setLayoutManager(gridLayoutManager);
                        mRvHotBrand.setItemAnimator(new DefaultItemAnimator());
                        mRvHotBrand.setAdapter(new HomeFrgHotBrandAdapter(getActivity(), mHotBrandBeans));
                        //处理四个分类
                        //最新车源
                        LinearLayout mLyNewCars = holder.getView(R.id.ly_new_cars);
                        mLyNewCars.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getActivity(), NewCarsActivity.class));
                            }
                        });
                        //4s店特价
                        LinearLayout mLy4sShop = holder.getView(R.id.ly_4s_shop);
                        mLy4sShop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getActivity(), GoodsDetailActivity.class));
                            }
                        });
                        //二手车
                        LinearLayout mLySecondHand = holder.getView(R.id.ly_second_hand);
                        mLySecondHand.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getActivity(), GoodsDetailActivity.class));
                            }
                        });
                        //团购
                        LinearLayout mLyGroupBuy = holder.getView(R.id.ly_group);
                        mLyGroupBuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getActivity(), GroupBuyActivity.class));
                            }
                        });

                        //处理垂直滚动公告栏
                        MarqueeFactory<TextView, String> marqueeFactory1 = new NoticeMF(getActivity());
                        mMarqueeView.setMarqueeFactory(marqueeFactory1);
                        mMarqueeView.startFlipping();
                        marqueeFactory1.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
                            @Override
                            public void onItemClickListener(MarqueeFactory.ViewHolder<TextView, String> holder) {
                                Toast.makeText(getActivity(), holder.data, Toast.LENGTH_SHORT).show();
                            }
                        });
                        marqueeFactory1.setData(datas);
                        break;
                    default:
                        break;
                }
            }
        };
        mAdapter.setHeaderView(1, R.layout.item_home_header, mHeaderDatas.get(0));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(mDecoration = new HomeSuspensionDecoration(getActivity(), mDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 26, getResources().getDisplayMetrics()))//设置abc标题高度
                .setColorTitleBg(getResources().getColor(R.color.backgroundGray))
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()))
                .setHeaderViewCount(mAdapter.getHeaderViewCount() - mHeaderDatas.size()));
        //使用indexBar
        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mLayoutManager)//设置RecyclerView的LayoutManager
                .setHeaderViewCount(mAdapter.getHeaderViewCount() - mHeaderDatas.size());

//        initDatas(getResources().getStringArray(R.array.provinces));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                final int firstVisibleItemPosition = mLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (firstVisibleItemPosition <= 1) {
                    mIndexBar.setVisibility(View.GONE);
                } else {
                    mIndexBar.setVisibility(View.VISIBLE);
                }
            }
        });


        //处理定位
        locationService = App.getInstance().locationService;
        locationService.registerListener(mListener);
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        locationService.start();
    }

    @Override
    public void initData() {
        mSwipeLayout.setRefreshing(false);

        //处理热门品牌
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CART_GETHOTBRAND)
                .params(null, Contstant.CART_GETHOTBRAND)
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

                        Log.d("HomeFragment", "处理热门品牌" + response);
                        Gson gson = new Gson();
                        List<CartGethotbrandBean.DataBean> hotBrandBean
                                = gson.fromJson(response, CartGethotbrandBean.class).getData();
                        mHotBrandBeans.clear();
                        mHotBrandBeans.addAll(hotBrandBean);
                        mHeaderDatas.clear();
                        mHeaderDatas.add(new HomeHeaderBean(mHotBrandBeans, "头部指示器", "#"));
                        mDatas.remove(0);
                        mDatas.add(0, mHeaderDatas.get(0));

                        mAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：CART_GETBRAND————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

        //处理品牌列表数据
        String url = UrlPath.CART_GETBRAND;
        OkHttpUtils//
                .post()
                .tag(this)
                .url(url)
                .params(null, Contstant.CART_GETBRAND)
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
                        Log.d("HomeFragment", "处理品牌列表数据" + response);
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONObject data = object.getJSONObject("data");
                            Iterator<String> jsonKeys = data.keys();
                            ArrayList<String> keys = new ArrayList<>();
                            while (jsonKeys.hasNext()) {
                                keys.add(jsonKeys.next());
                                Log.d("HomeFragment", "keys.size():" + keys.size());
                            }

                            List<ShabiBean> shabiBeans = new ArrayList<>();
                            for (int i = 0; i < keys.size(); i++) {
                                String indexArray = data.getString(keys.get(i));
                                Gson gson = new Gson();
                                List<ShabiBean> json = gson.fromJson(indexArray, new TypeToken<List<ShabiBean>>() {
                                }.getType());
                                shabiBeans.addAll(json);
//                                Log.d("HomeFragment", "json.size():" + shabiBeans.size());
                            }
                            setBrandData(shabiBeans);
                            for (int i = 0; i < shabiBeans.size(); i++) {
//                                Log.d("HomeFragment", shabiBeans.get(i).getName());
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//                        Gson gson = new Gson();
//                        CartGetbrandBean cartGetbrandBean = gson.fromJson(response, CartGetbrandBean.class);
//                        setBrandData(cartGetbrandBean);

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：CART_GETBRAND————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

        //处理首页banner
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.ARTICLE_GETBANNER)
                .params(null, Contstant.ARTICLE_GETBANNER)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        Log.d("HomeFragment", "ARTICLE_GETBANNER接口没返数据");
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("HomeFragment", "处理首页banner" + response);
//                        Gson gson = new Gson();
//                        List<CartGethotbrandBean.DataBean> hotBrandBean
//                                = gson.fromJson(response, CartGethotbrandBean.class).getData();
//                        mHotBrandBeans.clear();
//                        mHotBrandBeans.addAll(hotBrandBean);
//                        mHeaderDatas.clear();
//                        mHeaderDatas.add(new HomeHeaderBean(mHotBrandBeans, "头部指示器", "#"));
//                        mDatas.remove(0);
//                        mDatas.add(0, mHeaderDatas.get(0));
//
//                        mAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "接口：ARTICLE_GETBANNER————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * 汽车品牌数据
     */
    private void setBrandData(List<ShabiBean> shabiBeans) {
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


    @OnClick({R.id.ly_location, R.id.ly_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_location:
                startActivity(new Intent(getActivity(), LocationSelectedActivity.class));
                break;
            case R.id.ly_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;

        }
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "refresh", Toast.LENGTH_SHORT).show();
        initData();
    }

    //HeaderRecyclerAndFooterWrapperAdapter
    class HomeFrgAdapter extends HeaderRecyclerAndFooterWrapperAdapter implements BGABanner.Delegate<ImageView, Integer>, BGABanner.Adapter<ImageView, Integer> {

        public HomeFrgAdapter(RecyclerView.Adapter mInnerAdapter) {
            super(mInnerAdapter);
        }

        @Override
        protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {

        }

        @Override
        public void onBannerItemClick(BGABanner banner, ImageView itemView, Integer model, int position) {
            Toast.makeText(getActivity(), "position:" + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fillBannerItem(BGABanner banner, ImageView itemView, Integer model, int position) {
            Glide.with(getActivity())
                    .load(model)
                    .placeholder(R.drawable.test_icon)
                    .error(R.drawable.test_schedule_red_500_24dp)
                    .into(itemView);
        }
    }

    /*****
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
                Log.d("HomeFragment", "onReceiveLocation:" + bdLocation.getCity());
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("city", bdLocation.getCity());
                message.what = RECEIVE_LOCATION;
                message.setData(bundle);
                mHandler.sendMessageDelayed(message, 200);
                locationService.unregisterListener(mListener); //注销掉监听
                locationService.stop(); //停止定位服务
            }
        }

        public void onConnectHotSpotMessage(String s, int i) {
        }
    };

}
