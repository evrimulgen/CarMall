package com.loading.carmall.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.loading.carmall.R;
import com.loading.carmall.adapter.GoodsEvaluationFrgAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GoodsEvaluationFragment extends LazyBaseFragment {


    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private GoodsEvaluationFrgAdapter mAdapter;
    public GoodsEvaluationFragment() {
    }
    @Override
    protected int setContentView() {
        return R.layout.fragment_goods_evaluation;
    }

    @Override
    protected void lazyLoad() {
        ButterKnife.bind(this, view);
        initView();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GoodsEvaluationFrgAdapter(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initData() {

    }
}
