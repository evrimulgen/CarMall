package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.decoration.FilterResultsAtyDecoration;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FilterResultsActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_results);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "筛选结果");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new FilterResultsAtyDecoration(this,getResources().getString(R.string.test_text)));
        BaseQuickAdapter<Status, BaseViewHolder> adapter = new
                BaseQuickAdapter<Status, BaseViewHolder>(R.layout.item_filter_results_aty
                , DataServer.getSampleData(30)) {

            @Override
            protected void convert(BaseViewHolder helper, Status item) {
                int position = helper.getAdapterPosition();
                if (position == 0) {
                    View view = helper.getView(R.id.view);
                    view.setVisibility(View.VISIBLE);
                }

            }
        };
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }
}
