package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.SearchAtyHotBean;
import com.loading.carmall.bean.SearchAtyResultBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.searchpage.SearchPageCar;
import com.loading.carmall.utils.SPUtils;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;import static com.loading.carmall.utils.okhttp.OkHttpUtils.post;

public class SearchActivity extends BaseAty {
    @Bind(R.id.searchlayout)
    SearchPageCar msearchlayout;
    private List<String> mHistorySearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    @Override
    public void onBackPressed() {
        if (msearchlayout.isResultShow()) {
            msearchlayout.hideResult();
        } else {
            super.onBackPressed();
        }
    }

    private void initClick() {

    }

    @Override
    public void initView() {
        //搜索历史
        String historyString = SPUtils.getString(Contstant.SEARCH_HISTORY);
        mHistorySearchList = new ArrayList<>();
        if (!TextUtils.isEmpty(historyString) && historyString.contains(",")) {
            mHistorySearchList = Arrays.asList(historyString.split(","));
        }
    }

    @Override
    public void initData() {
        //首页汽车头条接口
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("userid", SPUtils.getString(Contstant.USER_ID));
        //
                post()
                .tag(this)
                .url(UrlPath.ARTICLE_GETSEARCH)
                .params(map, Contstant.ARTICLE_GETSEARCH)
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
                        Log.d("SearchActivity", "首页热门搜索，搜索记录接口:" + response);
                        //{"data":[{"keyword":"奥拓","hot":1},{"keyword":"尼桑","hot":1},{"keyword":"宝马","hot":1},{"keyword":"奔驰","hot":1},{"keyword":"红旗","hot":1},{"keyword":"国产","hot":1},{"keyword":"进口","hot":1},{"keyword":"本田","hot":1}]}
                        SearchAtyHotBean bean = new Gson().fromJson(response,
                                SearchAtyHotBean.class);
                        List<SearchAtyHotBean.DataBean> hotDatas = bean.getData();
                        msearchlayout.initData(mHistorySearchList, hotDatas,
                                new SearchPageCar.setSearchCallBackListener() {
                                    @Override
                                    public void Search(String str) {
                                        //进行或联网搜索
                                        search(str);
                                    }

                                    @Override
                                    public void Back() {
                                        Log.d("MainActivity", "Back()");
                                        finish();
                                    }

                                    @Override
                                    public void ClearOldData() {
                                        SPUtils.putString(Contstant.SEARCH_HISTORY, "");
                                        Log.d("SearchActivity", "ClearOldData()");
                                        //清除历史搜索记录  更新记录原始数据
                                    }

                                    @Override
                                    public void SaveOldData(ArrayList<String> allHistoryDataList) {
                                        StringBuilder historyData = new StringBuilder();
                                        for (int i = 0; i < allHistoryDataList.size(); i++) {
                                            if (i != allHistoryDataList.size() - 1) {
                                                historyData.append(allHistoryDataList.get(i))
                                                        .append(",");
                                            } else {
                                                historyData.append(allHistoryDataList.get(i));
                                            }
                                        }
                                        SPUtils.putString(Contstant.SEARCH_HISTORY, historyData.toString());
                                        Log.d("SearchActivity", "SaveOldData(ArrayList<String> AlloldDataList)");
                                        //保存所有的搜索记录
                                    }
                                });
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Toast.makeText(mActivity, "接口：ARTICLE_GETSEARCH————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void search(String keyword) {
        Log.e("SearchActivity", keyword.trim());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("keyword", keyword);
        OkHttpUtils//
                .post()
                .tag(this)
                .url(UrlPath.ARTICLE_SEARCH)
                .params(map, Contstant.ARTICLE_SEARCH)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        msearchlayout.showResult(null);
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("SearchActivity", "首页搜索结果接口:" + response);
                        //{"data":[{"id":1,"name":"本田8965号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg","comment":"小型车 1.0T 2.0T"},{"id":2,"name":"本田89号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":3,"name":"本田2号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":5,"name":"本田2号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":6,"name":"本田9号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":7,"name":"本田135号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":8,"name":"本田56号","pricd":"80-36万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/5cb8e3a670453579dc0a1806693bcd48.jpg","comment":"小型车 1.0T 2.0T"},{"id":9,"name":"本田58sw号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/e2f1808aeabf7b6165ddd377df49b7e7.jpg","comment":"小型车 1.0T 2.0T"},{"id":10,"name":"本田ww号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/ad1e43518e77d5e18b826a246a0a48dc.jpg","comment":"小型车 1.0T 2.0T"},{"id":11,"name":"本田1wd号","pricd":"80-36万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/74cffefac003782ae4816ffac2fb9260.jpg","comment":"小型车 1.0T 2.0T"},{"id":12,"name":"本田213号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/c32429d783a75897c185324ee893baa3.jpg","comment":"小型车 1.0T 2.0T"},{"id":13,"name":"本田213号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/c32429d783a75897c185324ee893baa3.jpg","comment":"小型车 1.0T 2.0T"},{"id":14,"name":"咋咋","pricd":"38.5-22.5","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170421\/282f309b295a613387b6888fe80ab3a4.jpg","comment":"小型车 1.0T 2.0T"},{"id":15,"name":"小马丁","pricd":"39.8-22.5","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170426\/0eea36d3d3a2e8b00818a74039d5e082.jpg","comment":"小型车 1.0T 2.0T"},{"id":26,"name":"就是这个","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/560da4fef81f78892fff3f9565770dd2.jpg","comment":"小型车 1.0T 2.0T"}]}
                        List<SearchAtyResultBean.DataBean> resultDatas =
                                new Gson().fromJson(response, SearchAtyResultBean.class).getData();
                        msearchlayout.showResult(resultDatas);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("SearchActivity", e.toString());
                        Toast.makeText(mActivity, "接口：ARTICLE_SEARCH————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
