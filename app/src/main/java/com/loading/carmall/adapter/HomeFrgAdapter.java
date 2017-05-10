package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.ArticlegetbannnerBean;
import com.loading.carmall.mock.HeaderRecyclerAndFooterWrapperAdapter;
import com.loading.carmall.mock.ViewHolder;
import com.loading.carmall.ui.weiget.banner.BGABanner;

//HeaderRecyclerAndFooterWrapperAdapter
public class HomeFrgAdapter extends HeaderRecyclerAndFooterWrapperAdapter
        implements BGABanner.Delegate<ImageView, ArticlegetbannnerBean.DataBean>,
        BGABanner.Adapter<ImageView, ArticlegetbannnerBean.DataBean> {
    private Activity mActivity;

    protected HomeFrgAdapter(Activity activity, RecyclerView.Adapter mInnerAdapter) {
        this(mInnerAdapter);
        mActivity = activity;
    }

    private HomeFrgAdapter(RecyclerView.Adapter mInnerAdapter) {
        super(mInnerAdapter);
    }

    @Override
    protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {

    }

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, ArticlegetbannnerBean.DataBean model, int position) {
        Toast.makeText(mActivity, model.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, ArticlegetbannnerBean.DataBean model, int position) {
        Log.d("HomeFrgAdapter", "fillBannerItem");
        Glide.with(mActivity)
                .load(model.getImage())
                .placeholder(R.drawable.test_icon)
                .error(R.drawable.test_schedule_red_500_24dp)
                .into(itemView);
    }
}
