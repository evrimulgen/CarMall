package com.loading.carmall.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.ui.activity.DiscountNoticeActivity;
import com.loading.carmall.ui.activity.UsedBargainActivity;
import com.loading.carmall.ui.weiget.banner.BGABanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UsedDetailAtyAdapter extends RecyclerView.Adapter
        implements BGABanner.Delegate<ImageView, Integer>, BGABanner.Adapter<ImageView, Integer> {

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, Integer model, int position) {
        Toast.makeText(mActivity, "position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, Integer model, int position) {
        Glide.with(mActivity)
                .load(model)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.test_schedule_red_500_24dp)
                .into(itemView);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, String tarid);
    }


    public OnItemClickListener mListener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    private Activity mActivity;

    public UsedDetailAtyAdapter(Activity activity) {
        mActivity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_detail_frg_banner, parent, false);
            return new MyHeaderViewHolder(v);
        } else if (viewType == 1) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_used_detail_aty_info, parent, false);
            return new InfoViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_detail_frg_image, parent, false);
            return new ImageViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            MyHeaderViewHolder viewHolder = (MyHeaderViewHolder) holder;
            List<Integer> mIntegers = new ArrayList<>();
            mIntegers.add(R.drawable.pic_01);
            mIntegers.add(R.drawable.pic_02);
            mIntegers.add(R.drawable.pic_lb);
            viewHolder.mBannerMainDepth.setAdapter(this);
            viewHolder.mBannerMainDepth.setData(mIntegers, null);

        } else if (holder instanceof InfoViewHolder) {
            InfoViewHolder infoViewHolder = (InfoViewHolder) holder;
            infoViewHolder.mLyBargain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.startActivity(new Intent(mActivity, UsedBargainActivity.class));
                }
            });
            infoViewHolder.mLyNotify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.startActivity(new Intent(mActivity, DiscountNoticeActivity.class));
                }
            });

        } else {
            ImageViewHolder viewHolder = (ImageViewHolder) holder;
            Glide.with(mActivity).load("http://lorempixel.com/400/200/").into(viewHolder.mImageView);
        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        if (position == 1)
            return 1;

        return 2;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class MyHeaderViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.banner)
        BGABanner mBannerMainDepth;


        public MyHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image_view)
        ImageView mImageView;


        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class InfoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView mTvTitle;
        @Bind(R.id.textView8)
        TextView mTextView8;
        @Bind(R.id.ly_bargain)
        LinearLayout mLyBargain;
        @Bind(R.id.ly_notify)
        LinearLayout mLyNotify;
        @Bind(R.id.ly_parameter)
        LinearLayout mLyParameter;
        @Bind(R.id.iv_sale_header)
        ImageView mIvSaleHeader;
        @Bind(R.id.tv_nickname)
        TextView mTvNickname;

        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
