package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.ArticlegetbannnerBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.StateTextView;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class SecondHandSaleActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.commit)
    StateTextView mCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_sale);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    private void initClick() {
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit();
                startActivity(new Intent(mActivity, SecondHandSaleSuccessActivity.class));
            }
        });
    }

    private void commit() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        map.put("brandid", );//品牌id
//        map.put("modelid", );//车系id
//        map.put("baseid", );//车型id
//        map.put("userid", );//用户id
//        map.put("dqlc", );//当前里程
//        map.put("clszd", );//车辆所在地
//        map.put("ddcp", );//是否为当地车牌
//        map.put("ghcs", );//过户次数
//        map.put("ccspsj", );//初次上牌时间
//        map.put("ck", );//车况
//        map.put("hxjh", );//后续计划
//        map.put("content", );//内容
//        map.put("price", );//价格
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.CARTUSED_RELEASE)
                .params(null, Contstant.CARTUSED_RELEASE)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        Log.d("SecondHandSaleActivity", "CARTUSED_RELEASE接口没返数据");
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        //{"data":[true,"发布成功","3"]}
                        Log.d("SecondHandSaleActivity", "提交卖车接口" + response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：CARTUSED_RELEASE————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
