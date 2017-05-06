package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.weiget.LoadingButton;
import com.loading.carmall.ui.weiget.PasswordEditText;
import com.loading.carmall.ui.weiget.StateTextView;
import com.loading.carmall.utils.NoDoubleClickListener;
import com.loading.carmall.utils.RegularUtils;
import com.loading.carmall.utils.SPUtils;
import com.loading.carmall.utils.WeakRefHander;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

import static android.R.attr.handle;

/**
 * Created by 马小布 on 2017/5/5.
 * Project : recycler adapter封装
 * Program Name :  com.loading.carmall.ui.activity.RegisterActivity.java
 * Author :马庆龙 on 2017/5/5 10:33
 * email:maxiaobu1999@163.com
 * 功能：注册
 * 伪码：
 * 待完成：
 */
public class RegisterActivity extends BaseAty {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.et_phone_num)
    AppCompatEditText mEtPhoneNum;
    @Bind(R.id.et_yzm)
    AppCompatEditText mEtYzm;
    @Bind(R.id.btn_yzm)
    StateTextView mBtnYzm;
    @Bind(R.id.et_nickname)
    AppCompatEditText mEtNickname;
    @Bind(R.id.et_password)
    PasswordEditText mEtPassword;
    @Bind(R.id.checkbox)
    CheckBox mCheckbox;
    @Bind(R.id.tv_agreement)
    TextView mTvAgreement;
    @Bind(R.id.btn_register)
    LoadingButton mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    @Override
    protected void onStop() {
        OkHttpUtils.getInstance().cancelTag(this);
        super.onStop();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "注册");

        mTvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, AgreementActivity.class));
            }
        });
    }

    @Override
    public void initData() {

    }

    private void initClick() {
        mBtnYzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSmsCaptchaCountDown(mBtnYzm, 60);

            }
        });

        mBtnRegister.setOnSuccessEndListener(new LoadingButton.OnSuccessEndListener() {
            @Override
            public void onSuccessEnd() {
                SPUtils.putString(Contstant.USE_PHONE, mEtPhoneNum.getText().toString().trim());
                mActivity.finish();
            }
        });
        mBtnRegister.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                register();
            }
        });
    }

    private void register() {
        if (!RegularUtils.isMobile(mEtPhoneNum.getText().toString().trim())) {
            Toast.makeText(mActivity, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mEtYzm.getText().toString().trim())) {
            Toast.makeText(mActivity, "请填写验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mEtNickname.getText().toString().trim())) {
            Toast.makeText(mActivity, "请填写用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mEtPassword.getText().toString().trim())) {
            Toast.makeText(mActivity, "请填写密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mCheckbox.isChecked()) {
            Toast.makeText(mActivity, "请勾选用户协议", Toast.LENGTH_SHORT).show();
            return;
        }

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("user_name", mEtPhoneNum.getText().toString().trim());
        map.put("name", mEtNickname.getText().toString().trim());
        map.put("password", mEtPassword.getText().toString().trim());
        map.put("smscode", mEtYzm.getText().toString().trim());
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.USER_REGISTER)
                .params(map, Contstant.USER_REGISTER)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        mBtnRegister.startLoading();
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        Log.d("RegisterActivity", "USER_REGISTER 接口没返数据");
                        mBtnRegister.loadingFailed();
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast toast = Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        mBtnRegister.loadingFailed();

                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("RegisterActivity", "获取验证码" + response);
                        //{"data":{"userid":"212067"}}
                        mBtnRegister.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mBtnRegister.loadingSuccessful();
                            }
                        }, 200);

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mBtnRegister.loadingFailed();
                        Toast.makeText(mActivity, "接口：USER_REGISTER————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * 短信验证码倒计时
     */
    public void tvSmsCaptchaCountDown(final TextView tv, int smsTime) {
        if (!RegularUtils.isMobile(mEtPhoneNum.getText().toString().trim())) {
            Toast.makeText(mActivity, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        getCode(mEtPhoneNum.getText().toString().trim());
        tv.setOnClickListener(null);
        tv.setActivated(false);
        tv.setClickable(false);
        new CountDownTimer(smsTime * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                tv.setText("重新获取(" + millisUntilFinished / 1000 + ")");
            }

            public void onFinish() {
                tv.setClickable(true);
                tv.setText("获取验证码");
                tv.setActivated(true);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (RegularUtils.isMobile(mEtPhoneNum.getText().toString().trim())) {
                            tvSmsCaptchaCountDown(tv, 60);
                            getCode(mEtPhoneNum.getText().toString().trim());
                        } else {
                            Toast.makeText(mActivity, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }.start();
    }

    /**
     * 获取验证码
     */
    private void getCode(String phoneNum) {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("user_name", phoneNum);
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.USER_SENDSMSCODE)
                .params(map, Contstant.USER_SENDSMSCODE)
                .build()
                .execute(new MxbStringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @Override
                    public void onNodata() {
                        super.onNodata();
                        Log.d("RegisterActivity", "USER_SENDSMSCODE接口没返数据");
                    }

                    @Override
                    public void onResultFalse(String result) {
                        Toast.makeText(App.getInstance(), result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        //{"data":[true,"发送成功"]}
                        Log.d("RegisterActivity", "获取验证码" + response);
                        Toast.makeText(App.getInstance(), "验证码发送成功", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：USER_SENDSMSCODE————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
