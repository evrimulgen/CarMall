package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.adapter.SellScheduleAtyAdapter;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SellScheduleActivity extends BaseAty {
    List<Status> list;
    SellScheduleAtyAdapter adapter;
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.iv_record)
    ImageView mIvRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_schedule);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "卖车日程");
        mIvRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,SellRecordActivity.class));
            }
        });


        list = DataServer.getSampleData(10);
        adapter = new SellScheduleAtyAdapter(this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }
}
