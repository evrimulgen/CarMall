package com.loading.carmall.adapter;

import android.content.Context;

import com.loading.carmall.R;
import com.loading.carmall.mock.MultipleItem;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseMultiItemQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;

import java.util.List;

/**
 * Created by 马小布 on 2017/4/22.
 */

public class InformationCarFrgAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
//    public InformationCarFrgAdapter() {
//        super( R.layout.item_info_car_frg, DataServer.getSampleData(10));
//    }

    public InformationCarFrgAdapter(Context context, List data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_info_car_frg);
        addItemType(MultipleItem.IMG, R.layout.item_info_car_frg_multi);
//        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }
    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
//                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG_TEXT:
                switch (helper.getLayoutPosition() %
                        2) {
                    case 0:
//                        helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                        break;
                    case 1:
//                        helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                        break;

                }
                break;
        }
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
