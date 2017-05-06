package com.loading.carmall.ui.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.R;
import com.loading.carmall.adapter.InformationCarFrgAdapter;
import com.loading.carmall.mock.MultipleItem;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;

import java.util.List;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationCarFragment extends LazyBaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private int mCurrentCounter = 0;
    private static final int PAGE_SIZE = 6;
    private static final int TOTAL_COUNTER = 18;
    private boolean mLoadMoreEndGone = false;//true is gone,false is visible
    private boolean isErr;


    private InformationCarFrgAdapter mAdapter;
    private List<MultipleItem> mData;

    public static InformationCarFragment newInstance() {

        Bundle args = new Bundle();

        InformationCarFragment fragment = new InformationCarFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public InformationCarFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        Log.d("InformationCarFragment", "onCreate");
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_information_car, container, false);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("InformationCarFragment", "onCreate");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("InformationCarFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("InformationCarFragment", "onCreate");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("InformationCarFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("InformationCarFragment", "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("InformationCarFragment", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("InformationCarFragment", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("InformationCarFragment", "onDestroyView");
        mAdapter=null;
        super.onDestroyView();
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_information_car;
    }

    @Override
    protected void lazyLoad() {
        if (null == mAdapter) {
            mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            mSwipeRefreshLayout.setOnRefreshListener(this);
            mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            mData = DataServer.getMultipleItemData();
            mAdapter = new InformationCarFrgAdapter(getActivity(), mData);
            mAdapter.setOnLoadMoreListener(this, mRecyclerView);
            mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
            mRecyclerView.setAdapter(mAdapter);
        }
        mCurrentCounter = mAdapter.getData().size();
    }

    @Override
    public void onDestroy() {
        Log.d("InformationCarFragment", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("InformationCarFragment", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.d("InformationCarFragment", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setNewData(mData);
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);
            }
        }, 200);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        if (mAdapter.getData().size() < PAGE_SIZE) {
            mAdapter.loadMoreEnd(true);
        } else {
            if (mCurrentCounter >= TOTAL_COUNTER) {
//                    pullToRefreshAdapter.loadMoreEnd();//default visible
                mAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
            } else {
                if (isErr) {
                    mAdapter.addData(mData);
                    mCurrentCounter = mAdapter.getData().size();
                    mAdapter.loadMoreComplete();
                } else {
                    isErr = true;
                    Toast.makeText(getActivity(), R.string.network_err, Toast.LENGTH_LONG).show();
                    mAdapter.loadMoreFail();

                }
            }
            mSwipeRefreshLayout.setEnabled(true);
        }
    }
}
