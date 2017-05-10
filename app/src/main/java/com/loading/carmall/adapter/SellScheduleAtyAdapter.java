package com.loading.carmall.adapter;


import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.mock.model.OrderStatus;
import com.loading.carmall.mock.model.Orientation;
import com.loading.carmall.mock.model.TimeLineModel;
import com.loading.carmall.mock.newcars.Status;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 马小布 on 2016/8/31.
 * 数据录入右侧列表
 */
public class SellScheduleAtyAdapter extends RecyclerView.Adapter {
    private Activity mActivity;
    private   List<Status> mData;
    private int selectPosition = -1;

    public SellScheduleAtyAdapter(Activity activity,   List<Status> mData) {
        mActivity = activity;
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_data_entry_right, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        Status data = mData.get(position);
        viewHolder.setIsRecyclable(false);
        if (position != selectPosition) {
            //未打开
            viewHolder.mTvTitle.setText(data.getText());
            viewHolder.mLyRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        selectPosition = holder.getAdapterPosition();
                        SellScheduleAtyAdapter.this.notifyDataSetChanged();
                }
            });
        } else {
            //打开
            viewHolder.mTvTitle.setText(data.getText());
            viewHolder.mLyRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        selectPosition = 999999;
                        SellScheduleAtyAdapter.this.notifyDataSetChanged();
                }
            });
            LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
            viewHolder.mRvContent.setLayoutManager(layoutManager);
            List<TimeLineModel> mDataList = new ArrayList<>();
            mDataList.add(new TimeLineModel("Item successfully delivered", "", OrderStatus.INACTIVE));
            mDataList.add(new TimeLineModel("Courier is out to delivery your order", "2017-02-12 08:00", OrderStatus.ACTIVE));
            mDataList.add(new TimeLineModel("Item has reached courier facility at New Delhi", "2017-02-11 21:00", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Item has been given to the courier", "2017-02-11 18:00", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Item is packed and will dispatch soon", "2017-02-11 09:30", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Order is being readied for dispatch", "2017-02-11 08:00", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Order processing initiated", "2017-02-10 15:00", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Order confirmed by seller", "2017-02-10 14:30", OrderStatus.COMPLETED));
            mDataList.add(new TimeLineModel("Order placed successfully", "2017-02-10 14:00", OrderStatus.COMPLETED));
            Orientation mOrientation=Orientation.VERTICAL;
            SellScheduleAtyContentAdapter mAdapter = new SellScheduleAtyContentAdapter(mDataList,mOrientation,false);
            viewHolder.mRvContent.setAdapter(mAdapter);

//            viewHolder.mRvContent.setAdapter(mAdapter);
//            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
//            mItemTouchHelper = new ItemTouchHelper(callback);
//            mItemTouchHelper.attachToRecyclerView(viewHolder.mRvContent);
//            mAdapter.setOnItemClickListener(new AdapterDataEntryContentListAty.OnItemClickListener() {
//                @Override
//                public void onItemClick(View view, int position, List<List<String>> mData) {
//                    if (mModifyListener != null) {
//                        mModifyListener.onItemClick(view, position, mData);
//                    }
//                }
//            });
//            mAdapter.setOnItemAddClickListener(new AdapterDataEntryContentListAty.OnItemAddClickListener() {
//                @Override
//                public void onItemClick(View view, int position, List<List<String>> mData) {
//                    mAddListener.onItemClick(view, position, mData);
//                }
//            });
////            mAdapter.seti
//            mAdapter.setOnItemLongClickListener(new AdapterDataEntryContentListAty.OnItemLongClickListener() {
//                @Override
//                public void onItemClick(View view, int position, List<List<String>> mData) {
//                    mModifyLongListener.onItemClick(view, position, mData);
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView mTvTitle;
        @Bind(R.id.tv_content)
        TextView mTvContent;
        @Bind(R.id.iv_right)
        ImageView mIvRight;
        @Bind(R.id.rv_content)
        RecyclerView mRvContent;
        @Bind(R.id.ly_root)
        LinearLayout mLyRoot;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
