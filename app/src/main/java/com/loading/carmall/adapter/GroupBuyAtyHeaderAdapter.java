package com.loading.carmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.CartGethotbrandBean;

import java.util.List;

/**
 * Created by 马小布 on 2016/8/31.
 * 俱乐部列表
 */
public class GroupBuyAtyHeaderAdapter extends RecyclerView.Adapter {
    public boolean isExpanded() {
        return isExpanded;
    }

    private boolean isExpanded;
    private GroupBuyAtyHeaderAdapter mAdapter;

    public interface OnItemClickListener {
        void onItemClick(View view, String tarid);
    }

    public OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    private Context mContext;
    private List<CartGethotbrandBean.DataBean> mData;

    public GroupBuyAtyHeaderAdapter(Context context, List<CartGethotbrandBean.DataBean> mData) {
        mContext = context;
        this.mData = mData;
        mAdapter=this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v ;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_buy_aty_header, parent, false);
            return new MyViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_buy_aty_header_more, parent, false);

            return new FooterViewHolder(v);
        }



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {

        if (holder instanceof MyViewHolder) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.mTextView.setText(mData.get(position).getName());
            Glide.with(mContext).load(mData.get(position).getLogo()).into(viewHolder.mImageView);

        } else {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;

            footerViewHolder.mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isExpanded) {
                        isExpanded = !isExpanded;
                        mAdapter.notifyItemRangeInserted(5, 1);
                    } else {
                        isExpanded = !isExpanded;
                        mAdapter.notifyItemRangeRemoved(5, mData.size());
                    }



                }
            });
        }
//        viewHolder.mTextView.setOnClickListener(mSearchPageCar.TextViewItemListener );


    }



    @Override
    public int getItemViewType(int position) {
        if (position == mData.size()||(position==5&&!isExpanded)) {

            return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        if (mData.isEmpty())
            return 0;
        return (isExpanded ? mData.size() : 5) + 1;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTextView;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_brand);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_brand);
        }
    }
    static class FooterViewHolder extends RecyclerView.ViewHolder {


        LinearLayout mContainer;

        public FooterViewHolder(View itemView) {
            super(itemView);
            mContainer = (LinearLayout) itemView.findViewById(R.id.container);
        }
    }
}
