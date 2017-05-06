package com.loading.carmall.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loading.carmall.R;
import com.loading.carmall.ui.weiget.banner.BGABanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 马小布 on 2016/8/31.
 * 热门动态
 */
public class GoodsDetailFrgAdapter extends RecyclerView.Adapter implements BGABanner.Delegate<ImageView, Integer>, BGABanner.Adapter<ImageView, Integer> {


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

    public GoodsDetailFrgAdapter(Activity activity) {
        mActivity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_detail_frg_banner, parent, false);
            return new MyHeaderViewHolder(v);
        } else if (viewType == 1) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_detail_frg_info, parent, false);
            return new MyViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_detail_frg_image, parent, false);
            return new ImageViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
             MyHeaderViewHolder viewHolder = (MyHeaderViewHolder) holder;
            List<Integer> mIntegers = new ArrayList<>();
            mIntegers.add(R.drawable.pic_01);
            mIntegers.add(R.drawable.pic_02);
            mIntegers.add(R.drawable.pic_lb);
            viewHolder.mBannerMainDepth.setAdapter(this);
            viewHolder.mBannerMainDepth.setData(mIntegers, null);

        } else if (position == 1) {
//            MyViewHolder myViewHolder = (MyViewHolder) holder;
//            myViewHolder.mItemImage.setBorderWidth(3);
//            myViewHolder.mItemImage.setBorderColor(0xffc4c4c4);
//            myViewHolder.mItemName.setText(mLists.get(position-1).getAuthnickname());
//            Glide.with(mContext)
//                    .load(mLists.get(position-1).getAuthimgsfilename())
//                    .into(myViewHolder.mItemImage);
//            myViewHolder.mItemTime.setText(getFriendlyTimeSpanByNow(mLists.get(position-1).getCreatetime().getTime()));
//            myViewHolder.mItemContentText.setText(mLists.get(position-1).getContent());
//            Picasso.with(mContext).load(mLists.get(position-1).getImgsfilename())
//                    .into(myViewHolder.mItemContentImage);
//            myViewHolder.mItemGoodNum.setText(mLists.get(position-1).getLikecount()+"");
//
//            myViewHolder.mItemCommentNum.setText(mLists.get(position-1).getCommentcount()+"");
//
////        Log.d("mytt", mLists.get(position).getPostId());
////        Log.d("wjn", "num.get(position):" + position + " ----->" + num.get(position) + "----valuse:" + holder.mItemGoodNum.getText().toString());
//
//            myViewHolder.mItemLayout.setOnClickListener(v -> {
//                if (mOnListenItemClick != null) {
//                    mOnListenItemClick.onItemListen(mLists.get(position-1).getPostid(), mLists.get(position-1).getVisiable(), position-1, mLists.get(position-1).getAuthid(),mLists.get(position-1).getLikecount(),mLists.get(position-1).getCommentcount());
//                }
//            });
//            myViewHolder.mItemGoodLayout.setOnClickListener(v -> {
//                if (mOnListenGoodClickLayout != null)
//                    mOnListenGoodClickLayout.onClickGoodListen(myViewHolder.mItemGoodImage, myViewHolder.mItemGoodNum, position-1);
//            });
//            myViewHolder.mItemGoodImage.setOnClickListener(v -> {
//                if (mOnListenGoodClickLayout != null)
//                    mOnListenGoodClickLayout.onClickGoodListen(myViewHolder.mItemGoodImage, myViewHolder.mItemGoodNum, position-1);
//            });
//            myViewHolder.mItemCommentLayout.setOnTouchListener((v, event) -> {
//
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    if (mOnListenCommentClickLayout != null)
//                        mOnListenCommentClickLayout.onClickCommentListenDown(myViewHolder.mItemCommentImage);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (mOnListenCommentClickLayout != null)
//                        mOnListenCommentClickLayout.onClickCommentListenUp(myViewHolder.mItemCommentImage, position-1, mLists.get(position-1).getPostid(), mLists.get(position-1).getVisiable(), mLists.get(position-1).getAuthid(),mLists.get(position-1).getLikecount(),mLists.get(position-1).getCommentcount());
//                }
//                return true;
//            });
//            myViewHolder.mItemCommentImage.setOnClickListener(v -> {
//                if (mOnListenCommentClickLayout != null)
//                    mOnListenCommentClickLayout.onClickCommentListenUp(myViewHolder.mItemCommentImage, position-1, mLists.get(position-1).getPostid(), mLists.get(position-1).getVisiable(), mLists.get(position-1).getAuthid(),mLists.get(position-1).getLikecount(),mLists.get(position-1).getCommentcount());
//            });
//
//            myViewHolder.mItemShare.setOnClickListener(v -> {
//                if (mOnListenShareClickLayout != null) {
//
//                    mOnListenShareClickLayout.onClickShareListenUp(myViewHolder.mItemShare, position-1);
//                }
//            });
//
//            myViewHolder.mItemMore.setOnClickListener(v -> {
//                if (mOnListenMoreClickLayout != null) {
//
//                    mOnListenMoreClickLayout.onClickMoreListenUp(myViewHolder.mItemMore, position-1 , mLists.get(position-1).getAuthid() , mLists.get(position-1).getPostid());
//                }
//            });
//            myViewHolder.mItemContentImage.setOnClickListener(v -> {
//                mOnListenItemImageClick.onImageClick(v, myViewHolder.mItemContentImage, position-1, mLists.get(position-1).getImgpfilename());
//            });
//            myViewHolder.mItemImage.setOnClickListener(view -> mOnListenHeadImage.onListenClick(position-1,mLists.get(position-1).getAuthid(),mLists.get(position-1).getMemrole()));
//
//            if (mLists.get(position-1).getIslike() == 0) {
//                myViewHolder.mItemGoodImage.setBackgroundResource(R.mipmap.ic_dynamic_good_df);
//            } else {
//                myViewHolder.mItemGoodImage.setBackgroundResource(R.mipmap.ic_dynamic_good_dw);
//            }

        } else {
            ImageViewHolder viewHolder = (ImageViewHolder) holder;
            Glide.with(mActivity).load("http://lorempixel.com/400/200/").into(viewHolder.mImageView);
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
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class MyHeaderViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.banner)
        BGABanner mBannerMainDepth;


        public MyHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image_view)
        ImageView mImageView;


        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
