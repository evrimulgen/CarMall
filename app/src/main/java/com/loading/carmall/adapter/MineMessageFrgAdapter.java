package com.loading.carmall.adapter;

import com.loading.carmall.R;
import com.loading.carmall.mock.newcars.DataServer;
import com.loading.carmall.mock.newcars.Status;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;

/**
    *Created by 马小布 on 2017/4/25.
    *Project : 首页底部导航栏
    *Program Name :  com.loading.carmall.adapter.MineMessageFrgAdapter.java
    *Author :马庆龙 on 2017/4/25 16:01
    *email:maxiaobu1999@163.com
    *功能：我的消息
    *伪码：
    *待完成：
*/
public class MineMessageFrgAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public MineMessageFrgAdapter() {
        super( R.layout.item_mine_message_aty, DataServer.getSampleData(10));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
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
    }

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
