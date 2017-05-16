package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.ArticlegetbannnerBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by 马小布 on 2017/5/16.
 * Project : 易购汽车
 * Program Name :  com.loading.carmall.ui.activity.FeedbackActivity.java
 * Author :马庆龙 on 2017/5/16 7:55
 * email:maxiaobu1999@163.com
 * 功能：意见反馈
 * 伪码：
 * 待完成：
 */
public class FeedbackActivity extends BaseAty {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.button1)
    AppCompatRadioButton mButton1;
    @Bind(R.id.button2)
    AppCompatRadioButton mButton2;
    @Bind(R.id.button3)
    AppCompatRadioButton mButton3;
    @Bind(R.id.button4)
    AppCompatRadioButton mButton4;
    @Bind(R.id.radio_group)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "意见反馈");
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.d("FeedbackActivity", "checkedId:" + checkedId);
            }
        });
    }

    @Override
    public void initData() {
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.USER_GETFEEDBACKCLASS)
                .params(null, Contstant.USER_GETFEEDBACKCLASS)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        Log.d("FeedbackActivity", "USER_GETFEEDBACKCLASS");
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        //{"data":[{"id":12,"title":"首页banner1","url":"","image":"http:\/\/47.92.30.24:8080\/uploads\/images\/20170509\/67773784644856781de7194b008cca10.jpg"},{"id":13,"title":"首页banner2","url":"","image":"http:\/\/47.92.30.24:8080\/uploads\/images\/20170509\/2f1026f4f7b02326645780815ef2b727.jpg"},{"id":14,"title":"首页banner3","url":"","image":"http:\/\/47.92.30.24:8080\/uploads\/images\/20170509\/178fcdf9cc476444a56f414d3c0d75b6.jpg"}]}
                        Log.d("FeedbackActivity", "USER_GETFEEDBACKCLASS" + response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("FeedbackActivity", e.toString());
                        Toast.makeText(mActivity, "接口：USER_GETFEEDBACKCLASS————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
