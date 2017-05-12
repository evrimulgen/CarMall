package com.loading.carmall.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.bean.LevelTypeBean;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceAdapter;

import java.util.List;


public class LevelTypeAdapter extends MultiChoiceAdapter<LevelTypeAdapter.MySampleToolbarViewHolder> {
    private Context mContext;
    private int mLayoutRes;
    List<LevelTypeBean> mDatas;

    public LevelTypeAdapter(
            Context context, @LayoutRes int layout
            , List<LevelTypeBean> datas) {
        mContext = context;
        mLayoutRes = layout;
        mDatas = datas;
    }

    @Override
    public MySampleToolbarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySampleToolbarViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(mLayoutRes, parent, false));
    }


    @Override
    public void onBindViewHolder(final MySampleToolbarViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        final LevelTypeBean levelTypeBean = mDatas.get(position);
        View itemView = holder.itemView;
        holder.mTextView.setText(levelTypeBean.getTitle());
        holder.mImageView.setImageDrawable(ContextCompat.getDrawable(
                mContext, levelTypeBean.getIcon()));
    }


    /**
     * 处理选中/未选中状态
     */
    @Override
    public void setActive(View view, boolean state) {

        FrameLayout relativeLayout = (FrameLayout) view.findViewById(R.id.container);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        if (relativeLayout != null) {
            if (state) {
                textView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextOrange));
                imageView.setColorFilter(ContextCompat.getColor(mContext,R.color.backgroundOrange));
            } else {
                textView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextSecondary));
                imageView.setColorFilter(null);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MySampleToolbarViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        ImageView mImageView;

        MySampleToolbarViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
