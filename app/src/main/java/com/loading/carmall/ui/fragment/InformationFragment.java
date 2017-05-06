package com.loading.carmall.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.adapter.CommonViewpageAdapter;
import com.loading.carmall.base.BaseFrg;
import com.loading.carmall.ui.activity.GoodsDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InformationFragment extends BaseFrg {


    @Bind(R.id.tv_location)
    TextView mTvLocation;
    @Bind(R.id.ly_location)
    LinearLayout mLyLocation;
    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("InformationFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("InformationFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("InformationFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("InformationFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("InformationFragment", "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("InformationFragment", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("InformationFragment", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("InformationFragment", "onDestroyView");
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        Log.d("InformationFragment", "onDestroy");
        super.onDestroy();
    }

    public InformationFragment() {
    }

    public static InformationFragment newInstance() {
        Bundle args = new Bundle();

        InformationFragment fragment = new InformationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initView() {
        if (mViewPager != null) {
            setupViewPager(mViewPager);
            mViewPager.setOffscreenPageLimit(2);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    public void initData() {

    }
    private void setupViewPager(ViewPager viewPager) {
        CommonViewpageAdapter adapter = new CommonViewpageAdapter(getChildFragmentManager());
        adapter.addFragment(InformationCarFragment.newInstance(), "新车速递");
        adapter.addFragment(InformationNewsFragment.newInstance(), "新闻");
        adapter.addFragment(InformationPhotoFragment.newInstance(), "图片");
        adapter.addFragment(InformationActivityFragment.newInstance(), "活动");
        adapter.addFragment(InformationTopicFragment.newInstance(), "话题");
//        viewPager.setOffscreenPageLimit(5);

        viewPager.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("InformationFragment", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.d("InformationFragment", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

}
