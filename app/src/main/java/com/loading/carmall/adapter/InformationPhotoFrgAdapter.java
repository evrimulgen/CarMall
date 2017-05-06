package com.loading.carmall.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.loading.carmall.R;
import com.loading.carmall.mock.Item;
import com.loading.carmall.mock.MultipleItem;
import com.loading.carmall.mock.Shop;
import com.loading.carmall.ui.weiget.discretescrollview.DiscreteScrollView;
import com.loading.carmall.ui.weiget.discretescrollview.Orientation;
import com.loading.carmall.ui.weiget.discretescrollview.transform.ScaleTransformer;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseMultiItemQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by 马小布 on 2017/4/22.
 */

public class InformationPhotoFrgAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>
        implements DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder> {
//    public InformationCarFrgAdapter() {
//        super( R.layout.item_info_car_frg, DataServer.getSampleData(10));
//    }
private Activity mActivity;
    public InformationPhotoFrgAdapter(Activity activity, List data) {
        super(data);
        mActivity=activity;
        addItemType(MultipleItem.TEXT, R.layout.item_info_photo_frg);
        addItemType(MultipleItem.IMG, R.layout.item_info_photo_frg_multi);
//        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }
    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
//                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG:
                Shop shop = Shop.get();
                List<Item> shopData = shop.getData();

                final DiscreteScrollView discreteScrollView = helper.getView(R.id.discrete_scroll_view);
                discreteScrollView.setOrientation(Orientation.HORIZONTAL);
                discreteScrollView.setOnItemChangedListener(this);
                discreteScrollView.setAdapter(new InformationPhotoFrgMultiAdapter(shopData));
                discreteScrollView.setItemTransitionTimeMillis(150);
                discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                        .setMinScale(0.74f)
                        .build());
                discreteScrollView.scrollToPosition(1);
//                discreteScrollView.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        Log.d(TAG, "discreteScrollView.getCurrentItem():" + discreteScrollView.getCurrentItem());
//                        Log.d(TAG, "discreteScrollView.getChildCount():" + discreteScrollView.getAdapter().getItemCount());
//                        float startX=0;
//                        switch (event.getAction()) {
//                            case MotionEvent.ACTION_DOWN:
//                                startX=event.getX();
//                                Log.d(TAG, "ACTION_DOWN:" + startX);
//                                break;
//                            case MotionEvent.ACTION_MOVE:
//                                Log.d(TAG, "startX:" + startX);
//                                Log.d(TAG, "event.getX():" + event.getX());
//
//
//                                if (discreteScrollView.getCurrentItem() != 0&&event.getX()>startX) {
//
//                                } else if (discreteScrollView.getCurrentItem() !=
//                                        (discreteScrollView.getAdapter().getItemCount() - 1)
//                                        &&event.getX()<startX) {
//
//                                } else {
//                                    v.getParent().requestDisallowInterceptTouchEvent(true);
//                                }
//                                break;
//                        }
//                        return false;
//                    }
//                });

                break;
        }
    }

    @Override
    public void onCurrentItemChanged(@NonNull RecyclerView.ViewHolder viewHolder, int adapterPosition) {

    }

//    @Override
//    protected void convert(BaseViewHolder helper, Status item) {
//        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetText).addOnClickListener(R.id.tweetName);
//        switch (helper.getLayoutPosition()%
//                3){
//            case 0:
//                helper.setImageResource(R.id.img,R.mipmap.animation_img1);
//                break;
//            case 1:
//                helper.setImageResource(R.id.img,R.mipmap.animation_img2);
//                break;
//            case 2:
//                helper.setImageResource(R.id.img,R.mipmap.animation_img3);
//                break;
//        }
//        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
//        String msg="\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
//        ( (TextView)helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
//        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
//    }

//    ClickableSpan clickableSpan = new ClickableSpan() {
//        @Override
//        public void onClick(View widget) {
//            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
//        }
//
//        @Override
//        public void updateDrawState(TextPaint ds) {
//            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
//            ds.setUnderlineText(true);
//        }
//    };
}
