package com.loading.carmall.ui.weiget.reacyclerviewhelper;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;

//public class PullToRefreshAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
//
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
//
//    ClickableSpan clickableSpan = new ClickableSpan() {
//        @Override
//        public void onClick(View widget) {
//            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
//        }
//
//        @Override
//        public void updateDrawState(TextPaint ds) {
//            //noinspection deprecation
//            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
//            ds.setUnderlineText(true);
//        }
//    };
//
//
//}
