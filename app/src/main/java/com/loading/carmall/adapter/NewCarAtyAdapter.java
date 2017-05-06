package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.utils.ConvertUtils;
import com.loading.carmall.utils.ScreenUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 马小布 on 2016/8/31.
 * 热门动态
 */
public class NewCarAtyAdapter extends RecyclerView.Adapter {


    private final int mImageWidth;
    private final int mScreenWidth;

    public interface OnItemClickListener {
        void onItemClick(View view, String tarid);
    }

    public interface OnItemClickWebLinstener {
        void onItemWeb();
    }

    public OnItemClickListener mListener;
    private OnItemClickWebLinstener mWebLinstener;

    public void setWebLinstener(OnItemClickWebLinstener webLinstener) {
        mWebLinstener = webLinstener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    private Activity mActivity;

    public NewCarAtyAdapter(Activity activity) {
        mActivity = activity;
        mImageWidth = ConvertUtils.dp2px(200);
        mScreenWidth = ScreenUtils.getScreenWidth();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_cars, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        //手动更改高度，不同位置的高度有所不同
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, (position % 3 == 0) ? mImageWidth : mImageWidth / 2);
        if (position % 3 == 0)
            //第一项
            params.topMargin = 20;
        params.width = mScreenWidth /7* 4;
        params.rightMargin = 10;
        if (position % 3 == 1) {
            //第二项
            params.width = mScreenWidth  /7*3;
            params.bottomMargin = 5;
            params.topMargin = 20;
        } else if (position % 3 == 2) {
            //第三项
            params.width = mScreenWidth /7*  3;
            params.topMargin = 5;
        }
        viewHolder.mContainer.setLayoutParams(params);
//                .setHeight(100 + (position % 3) * 30);
        Glide.with(mActivity).load("http://lorempixel.com/400/200/").placeholder(R.drawable.test_icon).into(viewHolder.mImageView);
        viewHolder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "position:" + position % 3, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.image_view)
        ImageView mImageView;
        @Bind(R.id.container)
        FrameLayout mContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}


