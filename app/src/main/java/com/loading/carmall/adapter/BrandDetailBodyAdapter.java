package com.loading.carmall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.mock.CommonAdapter;
import com.loading.carmall.mock.ViewHolder;
import com.loading.carmall.ui.activity.GoodsDetailActivity;

import java.util.List;

public class BrandDetailBodyAdapter extends CommonAdapter<HomeFrgBodyBean> {
    private Context mContext;

    public BrandDetailBodyAdapter(Context context, int layoutId, List<HomeFrgBodyBean> datas) {
        super(context, layoutId, datas);
        mContext = context;
    }

    @Override
    public void convert(ViewHolder holder, final HomeFrgBodyBean cityBean) {
        holder.setText(R.id.tv_title, cityBean.getCity());
//        holder.setImageUrl(R.id.iv_icon, cityBean.getIcon());
//        Glide.with(mContext).load(cityBean.getIcon()).into((ImageView) holder.getView(R.id.image_view));
        LinearLayout linearLayout = holder.getView(R.id.container);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, GoodsDetailActivity.class));
            }
        });


    }
}