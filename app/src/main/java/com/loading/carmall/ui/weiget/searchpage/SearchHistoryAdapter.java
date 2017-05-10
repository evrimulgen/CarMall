package com.loading.carmall.ui.weiget.searchpage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loading.carmall.R;

import java.util.List;

class SearchHistoryAdapter extends RecyclerView.Adapter {
    public interface OnItemClickListener {
        void onItemClick(View view, String tarid, int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    private List<String> mData;

    SearchHistoryAdapter(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_history, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.mTextView.setText(mData.get(position));
        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(viewHolder.mTextView,"test",viewHolder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);

        }
    }
}
