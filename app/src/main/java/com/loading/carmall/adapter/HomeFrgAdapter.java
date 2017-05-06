package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.mock.CityBean;
import com.loading.carmall.ui.weiget.banner.BGABanner;
import com.loading.carmall.ui.weiget.marquee.ComplexItemEntity;
import com.loading.carmall.ui.weiget.marquee.ComplexViewMF;
import com.loading.carmall.ui.weiget.marquee.MarqueeFactory;
import com.loading.carmall.ui.weiget.marquee.MarqueeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 马小布 on 2017/4/5.
 */

public class HomeFrgAdapter extends RecyclerView.Adapter implements  BGABanner.Adapter<ImageView, String>, BGABanner.Delegate<ImageView, String> {
    private final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
    private static final String NAME_FORMAT = "%s %s";
    protected List<CityBean> mDatas;
    protected LayoutInflater mInflater;

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
        Toast.makeText(mActivity, "position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
        Glide.with(mActivity)
                .load(model)
                .placeholder(R.drawable.test_icon)
                .error(R.drawable.test_schedule_red_500_24dp)
                .into( itemView);
    }

//    @Override
//    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
//        Glide.with(mActivity)
//                .load(model)
//                .placeholder(R.drawable.test_icon)
//                .error(R.drawable.test_schedule_red_500_24dp)
//                .into((ImageView) view);
//    }
//
//    @Override
//    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
//
//    }

    public interface OnCancelItemClickListener {
        void onItemClick(View view, String what);
    }

    public OnCancelItemClickListener mListener;

    /**
     * 取消订单
     *
     * @param listener
     */
    public void setOnCancelItemClickListener(OnCancelItemClickListener listener) {
        mListener = listener;
    }

    private Activity mActivity;

    public HomeFrgAdapter(Activity activity, List<CityBean> mDatas) {
        mActivity = activity;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(activity);
    }

    public List<CityBean> getDatas() {
        return mDatas;
    }

//    public HomeFrgAdapter setDatas(List<CityBean> datas) {
//        mDatas = datas;
//        return this;
//    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = mInflater.inflate(R.layout.item_home_header, parent, false);

            return new MyViewHolder(view);
        } else {
            View view = mInflater.inflate(R.layout.item_city, parent, false);
            return new ContactViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            List<Integer> mIntegers = new ArrayList<>();
            mIntegers.add(R.drawable.pic_01);
            mIntegers.add(R.drawable.pic_02);
            mIntegers.add(R.drawable.pic_lb);
            viewHolder.mBanner.setAdapter(this);
            viewHolder.mBanner.setData(mIntegers, null);


//            final MarqueeFactory<TextView, String> marqueeFactory6 = new NoticeMF(mActivity);
//            marqueeFactory6.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
//                @Override
//                public void onItemClickListener(MarqueeFactory.ViewHolder<TextView, String> holder) {
//                    Toast.makeText(mActivity, holder.data, Toast.LENGTH_SHORT).show();
//                }
//            });
//            marqueeFactory6.setData(datas);
//            viewHolder.mMarqueeView.setMarqueeFactory(marqueeFactory6);
//            viewHolder.mMarqueeView.startFlipping();

            List<ComplexItemEntity> complexDatas = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                complexDatas.add(new ComplexItemEntity("标题 " + i, "副标题 " + i, "时间 " + i));
            }
            MarqueeFactory<RelativeLayout, ComplexItemEntity> marqueeFactory7 = new ComplexViewMF(mActivity);
            viewHolder.mMarqueeView.setAnimInAndOut(R.anim.top_in, R.anim.bottom_out);
            viewHolder.mMarqueeView.setMarqueeFactory(marqueeFactory7);
            viewHolder.mMarqueeView.startFlipping();
            marqueeFactory7.resetData(complexDatas);
        } else {

            ContactViewHolder viewHolder = (ContactViewHolder) holder;
            final CityBean cityBean = mDatas.get(position-1);
            viewHolder.mTvCity.setText(cityBean.getCity());
            viewHolder.mContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, "pos:" + position, Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.mIvAvatar.setImageResource(R.drawable.friend);
        }

    }


    @Override
    public int getItemCount() {
        return mDatas.size() + 1;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.banner)
        BGABanner mBanner;
        @Bind(R.id.marqueeView)
        MarqueeView mMarqueeView;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_avatar)
        ImageView mIvAvatar;
        @Bind(R.id.tvCity)
        TextView mTvCity;
        @Bind(R.id.content)
        LinearLayout mContent;
        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
