package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CommonViewpageAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.bean.CartGethotbrandBean;
import com.loading.carmall.bean.UserGetfaqclasslistBean;
import com.loading.carmall.common.Contstant;
import com.loading.carmall.common.UrlPath;
import com.loading.carmall.ui.fragment.CommonProblemFragment;
import com.loading.carmall.ui.fragment.GoodsDetailFragment;
import com.loading.carmall.ui.fragment.GoodsEvaluationFragment;
import com.loading.carmall.ui.fragment.GoodsParameterFragment;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.MxbStringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

public class CommonProblemActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_problem);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "常见问题");

    }
    private void setupViewPager(ViewPager viewPager,List<UserGetfaqclasslistBean.DataBean> datas ) {
        CommonViewpageAdapter adapter = new CommonViewpageAdapter(getSupportFragmentManager());
        for (int i = 0; i < datas.size(); i++) {
            UserGetfaqclasslistBean.DataBean dataBean = datas.get(i);
            adapter.addFragment(CommonProblemFragment.newInstance(dataBean.getId()),dataBean.getName());
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    public void initData() {
        OkHttpUtils.post()
                .tag(this)
                .url(UrlPath.USER_GETFAQCLASSLIST)
                .params(null, Contstant.USER_GETFAQCLASSLIST)
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
//                        {"data":[{"id":1,"name":"账号问题","status":1,"sort":50},{"id":2,"name":"订单问题","status":1,"sort":50}]}
                        Log.d("CommonProblemActivity", "USER_GETFAQCLASSLIST" + response);
                        Gson gson = new Gson();
                        UserGetfaqclasslistBean bean = gson.fromJson(response, UserGetfaqclasslistBean.class);
                        List<UserGetfaqclasslistBean.DataBean> datas = bean.getData();
                        if (mViewPager != null) {
                            setupViewPager(mViewPager,datas);
                            mViewPager.setOffscreenPageLimit(2);
                            mTabLayout.setupWithViewPager(mViewPager);
                        }

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mActivity, "接口：USER_GETFAQCLASSLIST————服务器问题", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
