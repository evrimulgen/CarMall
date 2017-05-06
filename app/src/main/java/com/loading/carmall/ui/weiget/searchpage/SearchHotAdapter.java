package com.loading.carmall.ui.weiget.searchpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loading.carmall.R;

import java.util.List;

/**
 * Created by 马小布 on 2016/8/31.
 * 俱乐部列表
 */
public class SearchHotAdapter extends RecyclerView.Adapter {
    public interface OnItemClickListener {
        void onItemClick(View view, String tarid);
    }

    public OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    private Context mContext;
    private List<String> mData;
    private SearchPageCar mSearchPageCar;

    public SearchHotAdapter(Context context, List<String> mData, SearchPageCar searchPageCar) {
        mContext = context;
        this.mData = mData;
        mSearchPageCar=searchPageCar;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_hot, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.mTextView.setText(mData.get(position));
        viewHolder.mTextView.setOnClickListener(mSearchPageCar.TextViewItemListener );



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
