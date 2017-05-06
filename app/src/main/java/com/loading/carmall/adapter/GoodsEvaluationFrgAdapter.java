package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.ui.weiget.GlideCircleTransform;
import com.loading.carmall.ui.weiget.banner.BGABanner;
import com.loading.carmall.ui.weiget.nicegridview.MultiImageViewLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.baidu.location.d.j.n;

public class GoodsEvaluationFrgAdapter extends RecyclerView.Adapter implements BGABanner.Delegate<ImageView, Integer>, BGABanner.Adapter<ImageView, Integer> {
    public static final String[] PHOTOS = {
            "http://img2.askpanda.cc/ask/cnnvxing/5641/5641-bb262016056214639.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/f11f3a292df5e0fecc3e83ef586034a85edf723d.jpg",
            "http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg",
            "http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg",
            "http://pic4.nipic.com/20091203/1295091_123813163959_2.jpg",
            "http://pic2.ooopic.com/11/79/98/31bOOOPICb1_1024.jpg"};


    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, Integer model, int position) {
        Toast.makeText(mActivity, "position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, Integer model, int position) {
        Glide.with(mActivity)
                .load(model)
                .placeholder(R.drawable.test_icon)
                .error(R.drawable.test_schedule_red_500_24dp)
                .into(itemView);
    }

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

    public GoodsEvaluationFrgAdapter(Activity activity) {
        mActivity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_evaluation_frg_header, parent, false);
            return new MyHeaderViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_evaluation_frg, parent, false);
            return new MyViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            MyHeaderViewHolder viewHolder = (MyHeaderViewHolder) holder;
            viewHolder.mTextView.setText("8989");

        } else {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            Glide.with(mActivity).load(R.drawable.test_11)
                    .transform(new GlideCircleTransform(mActivity))
                    .into(viewHolder.mIvAvatar);


            List<String> mStrings = new ArrayList<String>();
            for (int i = 0; i < Math.random()*6; i++) {

                mStrings.add(PHOTOS[i]);
            }
            viewHolder.mNineGridView.setList(mStrings);
            viewHolder.mNineGridView.setOnItemClickListener(new MultiImageViewLayout.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int PressImagePosition, float PressX, float PressY) {
                    System.out.println("view = [" + view + "], PressImagePosition = [" + PressImagePosition + "], PressX = [" + PressX + "], PressY = [" + PressY + "]");
                }

                @Override
                public void onItemLongClick(View view, int PressImagePosition, float PressX, float PressY) {
                    System.out.println("view = [" + view + "], PressImagePosition = [" + PressImagePosition + "], PressX = [" + PressX + "], PressY = [" + PressY + "]");
                }

            });


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
        @Bind(R.id.iv_avatar)
        ImageView mIvAvatar;
        @Bind(R.id.tv_username)
        TextView mTvUsername;
        @Bind(R.id.rb_grade)
        RatingBar mRbGrade;
        @Bind(R.id.tv_model)
        TextView mTvModel;
        @Bind(R.id.tv_model_time)
        TextView mTvModelTime;
        @Bind(R.id.tv_model_color)
        TextView mTvModelColor;
        @Bind(R.id.tv_content)
        TextView mTvContent;
        @Bind(R.id.nine_grid_view)
        MultiImageViewLayout mNineGridView;
        @Bind(R.id.tv_evaluation_time)
        TextView mTvEvaluationTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class MyHeaderViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text_view)
        TextView mTextView;


        public MyHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
