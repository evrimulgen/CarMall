package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.CartGethotbrandBean;
import com.loading.carmall.bean.HomeFrgBodyBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 马小布 on 2017/4/8.
 */

public class HomeFrgHotBrandAdapter extends RecyclerView.Adapter {


    private LayoutInflater mInflater;
    private List<CartGethotbrandBean.DataBean>  mData;
    private Activity mActivity;

    public HomeFrgHotBrandAdapter(Activity activity, List<CartGethotbrandBean.DataBean>  data) {
        mInflater = LayoutInflater.from(activity);
        mActivity = activity;
        mData=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_home_fra_hot_brand, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        CartGethotbrandBean.DataBean dataBean = mData.get(position);
        viewHolder.mTvBrand.setText(dataBean.getName());
        Log.d("HomeFrgHotBrandAdapter", dataBean.getLogo());
        Glide.with(mActivity).load(dataBean.getLogo()).into(viewHolder.mIvBrand);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_brand)
        ImageView mIvBrand;
        @Bind(R.id.tv_brand)
        TextView mTvBrand;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
