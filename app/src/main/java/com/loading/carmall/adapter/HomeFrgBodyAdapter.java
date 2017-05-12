package com.loading.carmall.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.mock.CommonAdapter;
import com.loading.carmall.mock.ViewHolder;

import java.util.List;


/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class HomeFrgBodyAdapter extends CommonAdapter<HomeFrgBodyBean> {
    private Context mContext;

    public HomeFrgBodyAdapter(Context context, int layoutId, List<HomeFrgBodyBean> datas) {
        super(context, layoutId, datas);
        mContext = context;
    }

    @Override
    public void convert(ViewHolder holder, final HomeFrgBodyBean cityBean) {
        holder.setText(R.id.tvCity, cityBean.getCity());
//        holder.setImageUrl(R.id.iv_icon, cityBean.getIcon());
        Glide.with(mContext).load(cityBean.getIcon()).into((ImageView) holder.getView(R.id.iv_icon));
    }
}