package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.ui.weiget.searchpage.SearchPageCar;
import com.loading.carmall.utils.SPUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchActivity extends BaseAty {

    @Bind(R.id.searchlayout)
    SearchPageCar msearchlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        //搜索历史
        String historyString = SPUtils.getString(Contstant.SEARCH_HISTORY);
        List<String> historySearchList = new ArrayList<>();
        if (!TextUtils.isEmpty(historyString)&&historyString.contains(",")) {
            historySearchList  = Arrays.asList(historyString.split(","));
        }


        //大家都在搜
        String hotSearchData ="阿尔法,宝马x6,北京现代,奥迪,马斯达,一汽大众";
        List<String> hotSearchList = Arrays.asList(hotSearchData.split(","));

        msearchlayout.initData(historySearchList, hotSearchList, new SearchPageCar.setSearchCallBackListener() {
            @Override
            public void Search(String str) {
                //进行或联网搜索
                Log.d("MainActivity", "Search");
                Toast.makeText(App.getInstance(), str, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void Back() {
                Log.d("MainActivity", "Back()");
                finish();
            }

            @Override
            public void ClearOldData() {
                SPUtils.putString(Contstant.SEARCH_HISTORY, "");
                Log.d("MainActivity", "ClearOldData()");
                //清除历史搜索记录  更新记录原始数据
            }
            @Override
            public void SaveOldData(ArrayList<String> allHistoryDataList) {
                StringBuilder historyData=new StringBuilder();
                for (int i = 0; i < allHistoryDataList.size(); i++) {
                    if (i != allHistoryDataList.size() - 1) {
                        historyData.append(allHistoryDataList.get(i))
                        .append(",");
                    } else {
                        historyData.append(allHistoryDataList.get(i));
                    }
                }
                SPUtils.putString(Contstant.SEARCH_HISTORY, historyData.toString());
                Log.d("MainActivity", "SaveOldData(ArrayList<String> AlloldDataList)");
                //保存所有的搜索记录
            }
        });
    }

    @Override
    public void initData() {

    }
}
