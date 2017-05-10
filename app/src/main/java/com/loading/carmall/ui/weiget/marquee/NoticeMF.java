package com.loading.carmall.ui.weiget.marquee;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.bean.ArticleGetheadlinesBean;

import java.util.List;

public class NoticeMF extends MarqueeFactory<TextView, ArticleGetheadlinesBean.DataBean> {
    private LayoutInflater inflater;

    public NoticeMF(Context mContext) {
        super(mContext);
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TextView generateMarqueeItemView(ArticleGetheadlinesBean.DataBean data) {
        TextView mView = (TextView) inflater.inflate(R.layout.notice_item, null);
        mView.setText(data.getTitle());
        return mView;
    }
}
