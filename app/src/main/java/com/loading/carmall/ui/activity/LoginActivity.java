package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.UserLoginBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.LoadingButton;
import com.loading.carmall.ui.weiget.PasswordEditText;
import com.loading.carmall.utils.NoDoubleClickListener;
import com.loading.carmall.utils.RegularUtils;
import com.loading.carmall.utils.SPUtils;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.LinkedHashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by 马小布 on 2017/4/27.
 * Project : 首页底部导航栏
 * Program Name :  com.loading.carmall.ui.activity.LoginActivity.java
 * Author :马庆龙 on 2017/4/27 16:57
 * email:maxiaobu1999@163.com
 * 功能：xdloadingbuttom
 * 伪码：
 * 待完成：
 */
public class LoginActivity extends BaseAty implements View.OnClickListener {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.btn_login)
    LoadingButton mBtnLogin;

    @Bind(R.id.et_phone_num)
    AppCompatEditText mEtPhoneNum;
    @Bind(R.id.et_password)
    PasswordEditText mEtPassword;
    @Bind(R.id.tv_find_password)
    TextView mTvFindPassword;
    @Bind(R.id.tv_register)
    TextView mTvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!"-1".equals(SPUtils.getString(Contstant.USE_PHONE, "-1")))
            mEtPhoneNum.setText(SPUtils.getString(Contstant.USE_PHONE, "-1"));
    }

    @Override
    protected void onStop() {
        OkHttpUtils.getInstance().cancelTag(this);
        super.onStop();
    }

    @Override
    public void initView() {
        mBtnLogin.setTypeface(Typeface.SERIF);
        mBtnLogin.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                login();
            }
        });
        mBtnLogin.setOnSuccessEndListener(new LoadingButton.OnSuccessEndListener() {
            @Override
            public void onSuccessEnd() {
                mEtPhoneNum.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mActivity.finish();
//                        startActivity(new Intent(mActivity, HomeActivity.class));
                    }
                }, 500);

            }
        });
    }

    private void login() {
        if (!RegularUtils.isMobile(mEtPhoneNum.getText().toString().trim())) {
            Toast.makeText(mActivity, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mEtPassword.getText().toString().trim())) {
            Toast.makeText(mActivity, "请填写密码", Toast.LENGTH_SHORT).show();
            return;
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("user_name", mEtPhoneNum.getText().toString().trim());
        map.put("password", mEtPassword.getText().toString().trim());
        String url = UrlPath.USER_LOGIN;
        OkHttpUtils//
                .post()
                .url(url)
                .params(map, "User-login")
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        mBtnLogin.startLoading();

                    }

                    @Override
                    public void onResultFalse(String result) {
                        Log.d("LoginActivity", "USER_LOGIN" + result);
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT) .show();
                        mBtnLogin.loadingFailed();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
//                        {"data":{"id":212067,"nickname":"马小布"}}
                        Log.d("LoginActivity:onSuccess", response);
                        Gson gson = new Gson();
                        UserLoginBean bean = gson.fromJson(response, UserLoginBean.class);
                        UserLoginBean.DataBean data = bean.getData();
                        int useId = data.getId();
                        String nickname = data.getNickname();
                        SPUtils.putString(Contstant.USER_ID, String.valueOf(useId));
                        SPUtils.putString(Contstant.USE_NICKNAME, nickname);
                        SPUtils.putString(Contstant.USE_PHONE, mEtPhoneNum.getText().toString().trim());
                        mBtnLogin.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mBtnLogin.loadingSuccessful();
                            }
                        }, 200);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "服务器问题", Toast.LENGTH_SHORT).show();
                        mBtnLogin.loadingFailed();
                    }
                });


    }


    @Override
    public void initData() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mBtnLogin.cancelLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.tv_find_password, R.id.tv_register})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_find_password:
                startActivity(new Intent(mActivity, FindPasswordActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(mActivity, RegisterActivity.class));
                break;
            default:
                break;
        }

    }


}
