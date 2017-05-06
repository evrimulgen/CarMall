package com.loading.carmall.adapter;

import android.content.Context;

import com.loading.carmall.R;
import com.loading.carmall.mock.CommonAdapter;
import com.loading.carmall.mock.MeiTuanBean;
import com.loading.carmall.mock.ViewHolder;

import java.util.List;


/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class LocationSelectedAdapter extends CommonAdapter<MeiTuanBean> {
    public LocationSelectedAdapter(Context context, int layoutId, List<MeiTuanBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
        holder.setText(R.id.tvCity, cityBean.getCity());
    }
}