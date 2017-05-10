package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.App;
import com.loading.carmall.R;
import com.loading.carmall.adapter.CheckImageAdapter;
import com.loading.carmall.adapter.CheckTextAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.weiget.InnerRecyclerView;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceRecyclerView;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceSelectionListener;
import com.loading.carmall.ui.weiget.StateTextView;
import com.loading.carmall.ui.weiget.flowlayout.FlowLayout;
import com.loading.carmall.ui.weiget.flowlayout.TagAdapter;
import com.loading.carmall.ui.weiget.flowlayout.TagFlowLayout;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondHandActivity extends BaseAty implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    @Override
    public void initView() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.backgroundOrange));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        BaseQuickAdapter<Status, BaseViewHolder> adapter = new BaseQuickAdapter<Status,
                BaseViewHolder>(R.layout.item_second_hand_aty, DataServer.getSampleData(30)) {
            @Override
            protected void convert(BaseViewHolder helper, Status item) {
                int position = helper.getLayoutPosition();


            }
        };
        adapter.setOnLoadMoreListener(this, mRecyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(mActivity, Integer.toString(position),
                        Toast.LENGTH_LONG).show();
            }
        });

        View headView = getLayoutInflater().inflate(R.layout.item_second_hand_aty_header,
                (ViewGroup) mRecyclerView.getParent(), false);
        LinearLayout lyBuy = (LinearLayout) headView.findViewById(R.id.ly_buy);
        LinearLayout lySale = (LinearLayout) headView.findViewById(R.id.ly_sale);
        lyBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, SecondHandBuyActivity.class));
            }
        });
        lySale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,SecondHandSaleActivity.class));
            }
        });

        final TagFlowLayout flowLayout = (TagFlowLayout) headView.findViewById(R.id.flow_layout);
        final String[] mVals = new String[]
                {"深赤色", "深橙色", "深红色 ", "深绿色", "深青色", "深蓝色", "深青色", "深蓝色"};
        flowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mActivity)
                        .inflate(R.layout.item_second_hand_aty_head_filter,
                                flowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(mActivity, mVals[position], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        headView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mLoadMoreEndGone = true;
//                pullToRefreshAdapter.setLoadMoreView(new CustomLoadMoreView());
//                mRecyclerView.setAdapter(pullToRefreshAdapter);
//                Toast.makeText(PullToRefreshUseActivity.this, "change complete", Toast.LENGTH_LONG).show();
//            }
//        });
        adapter.addHeaderView(headView);
    }

    @Override
    public void initData() {

    }

    private void initClick() {
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onRefresh() {

    }
}
