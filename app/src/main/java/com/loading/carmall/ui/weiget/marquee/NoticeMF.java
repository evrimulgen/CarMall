package com.loading.carmall.ui.weiget.marquee;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.loading.carmall.R;

/**
 * Created by 马小布 on 2017/4/7.
 */

public class NoticeMF extends MarqueeFactory<TextView, String> {
    private LayoutInflater inflater;

    public NoticeMF(Context mContext) {
        super(mContext);
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TextView generateMarqueeItemView(String data) {
        TextView mView = (TextView) inflater.inflate(R.layout.notice_item, null);
        mView.setText(data);
        return mView;
    }
}
