package com.loading.carmall.adapter;

import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.bean.HomeFrgBodyBean;
import com.loading.carmall.mock.CommonAdapter;
import com.loading.carmall.mock.ViewHolder;

import java.util.List;

public class SecondHandBrandAdapter extends CommonAdapter<HomeFrgBodyBean> {
    private Context mContext;

    public SecondHandBrandAdapter(Context context, int layoutId,
                                  List<HomeFrgBodyBean> datas) {
        super(context, layoutId, datas);
        mContext = context;
    }

    @Override
    public void convert(ViewHolder holder, final HomeFrgBodyBean cityBean) {
        holder.setText(R.id.tvCity, cityBean.getCity());
//        holder.setImageUrl(R.id.iv_icon, cityBean.getIcon());
        Glide.with(mContext).load(cityBean.getIcon()).into((ImageView) holder.getView(R.id.iv_icon));
        final CheckBox checkBox = holder.getView(R.id.checkbox);
        LinearLayout lyContianer = holder.getView(R.id.container);
        lyContianer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(!checkBox.isChecked());
            }
        });
    }
}