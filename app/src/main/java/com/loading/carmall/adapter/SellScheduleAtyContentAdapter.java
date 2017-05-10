package com.loading.carmall.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.mock.model.OrderStatus;
import com.loading.carmall.mock.model.Orientation;
import com.loading.carmall.mock.model.TimeLineModel;
import com.loading.carmall.ui.weiget.timelineview.TimelineView;
import com.loading.carmall.ui.weiget.timelineview.VectorDrawableUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SellScheduleAtyContentAdapter extends RecyclerView.Adapter<SellScheduleAtyContentAdapter.TimeLineViewHolder> {

    private List<TimeLineModel> mFeedList;
    private Context mContext;
    private Orientation mOrientation;
    private boolean mWithLinePadding;
    private LayoutInflater mLayoutInflater;

    public SellScheduleAtyContentAdapter(List<TimeLineModel> feedList, Orientation orientation, boolean withLinePadding) {
        mFeedList = feedList;
        mOrientation = orientation;
        mWithLinePadding = withLinePadding;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

            view = mLayoutInflater.inflate( R.layout.item_timeline, parent, false);

        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        TimeLineModel timeLineModel = mFeedList.get(position);

        if(timeLineModel.getStatus() == OrderStatus.INACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_inactive, android.R.color.darker_gray));
        } else if(timeLineModel.getStatus() == OrderStatus.ACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_active, R.color.colorPrimary));
        } else {
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker), ContextCompat.getColor(mContext, R.color.colorPrimary));
        }

//        if(!timeLineModel.getDate().isEmpty()) {
//            holder.mDate.setVisibility(View.VISIBLE);
//            holder.mDate.setText(DateTimeUtils.parseDateTime(timeLineModel.getDate(), "yyyy-MM-dd HH:mm", "hh:mm a, dd-MMM-yyyy"));
//        }
//        else
//            holder.mDate.setVisibility(View.GONE);
//
//        holder.mMessage.setText(timeLineModel.getMessage());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }
    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text_timeline_date)
        TextView mDate;
        @Bind(R.id.text_timeline_title)
        TextView mMessage;
        @Bind(R.id.time_marker)
        TimelineView mTimelineView;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mTimelineView.initLine(viewType);
        }
    }
}
