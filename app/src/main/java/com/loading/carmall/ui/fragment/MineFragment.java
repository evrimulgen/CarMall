package com.loading.carmall.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.ui.activity.CommonProblemActivity;
import com.loading.carmall.ui.activity.FeedbackActivity;
import com.loading.carmall.ui.activity.LoginActivity;
import com.loading.carmall.ui.activity.MineMessageActivity;
import com.loading.carmall.ui.activity.MineOrderActivity;
import com.loading.carmall.ui.activity.ProfileActivity;
import com.loading.carmall.ui.activity.SellScheduleActivity;
import com.loading.carmall.ui.activity.SettingActivity;
import com.loading.carmall.ui.weiget.GlideCircleTransform;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.baidu.location.d.j.r;
/**
    *Created by 马小布 on 2017/5/16.
    *Project : 易购汽车
    *Program Name :  com.loading.carmall.ui.fragment.MineFragment.java
    *Author :马庆龙 on 2017/5/16 8:53
    *email:maxiaobu1999@163.com
    *功能：个人中心
    *伪码：
    *待完成：
*/
public class MineFragment extends BaseFrg implements View.OnClickListener {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.iv_share)
    ImageView mIvShare;
    @Bind(R.id.toolbar_common)
    FrameLayout mToolbarCommon;
    @Bind(R.id.iv_avatar)
    ImageView mIvAvatar;
    @Bind(R.id.tv_nickname)
    TextView mTvNickname;
    @Bind(R.id.ly_mine_message)
    LinearLayout mLyMineMessage;
    @Bind(R.id.ly_common_problem)
    LinearLayout mLyCommonProblem;
    @Bind(R.id.ly_schedule)
    LinearLayout mLySchedule;
    @Bind(R.id.ly_order)
    LinearLayout mLyOrder;
    @Bind(R.id.ly_feedback)
    LinearLayout mLyFeedback;
    @Bind(R.id.ly_setting)
    LinearLayout mLySetting;

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MineFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void initView() {
        Glide.with(getActivity()).load(R.drawable.test_11)
                .transform(new GlideCircleTransform(getActivity())).into(mIvAvatar);

    }

    @Override
    public void initData() {

    }

    public MineFragment() {

    }
    @OnClick({R.id.ly_mine_message, R.id.ly_common_problem, R.id.ly_schedule,
            R.id.ly_order, R.id.ly_feedback, R.id.ly_setting,R.id.iv_avatar,R.id.iv_share})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //我的消息
            case R.id.ly_mine_message:
                startActivity(new Intent(getActivity(), MineMessageActivity.class));
                break;
            //常见问题
            case R.id.ly_common_problem:
                startActivity(new Intent(getActivity(), CommonProblemActivity.class));
                break;
            //卖车日程
            case R.id.ly_schedule:
                startActivity(new Intent(getActivity(), SellScheduleActivity.class));
                break;
            //我的订单
            case R.id.ly_order:
                startActivity(new Intent(getActivity(), MineOrderActivity.class));
                break;
            //意见反馈
            case R.id.ly_feedback:

                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;
            //设置
            case R.id.ly_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            //点击头像
            case R.id.iv_avatar:
                startActivity(new Intent(getActivity(), ProfileActivity.class));
                break;
            //分享
            case R.id.iv_share:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            default:
                break;
        }

    }
}
