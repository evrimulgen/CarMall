package com.loading.carmall.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.loading.carmall.R;
import com.loading.carmall.mock.Level0Item;
import com.loading.carmall.mock.Level1Item;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseMultiItemQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by 马小布 on 2017/4/14.
 * Project : 91健康商城
 * Program Name :  com.loading.carmall.adapter.GoodsParameterAdapter.java
 * Author :马庆龙 on 2017/4/14 13:21
 * email:maxiaobu1999@163.com
 * 功能：商品详情 参数页面
 * 伪码：
 * 待完成：
 */
public class GoodsParameterAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = GoodsParameterAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
//    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GoodsParameterAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_goods_parameter_frg_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_goods_parameter_frg_lv1);
    }


    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {

        switch (holder.getItemViewType()) {

            //一级项目
            case TYPE_LEVEL_0:
                holder.setImageResource(R.id.iv_head, R.drawable.test_setting);
                final Level0Item lv0 = (Level0Item) item;
                //expansion
                holder.setText(R.id.title, lv0.title)
                        .setText(R.id.sub_title, lv0.subTitle)
                        .setImageResource(R.id.iv_first, lv0.isExpanded() ? R.drawable.ic_arrow_expansion : R.drawable.ic_arrow_hide);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                            expand(pos);
//                            }
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                //设置二级项目
                final Level1Item lv1 = (Level1Item) item;
                final int postion = lv1.getPostion();
                //隔行设置背景为灰
                if (postion % 2 == 1) {
                    holder.setBackgroundColor(R.id.container,Color.parseColor("#f9f9f9"));
                } else {
                    holder.setBackgroundColor(R.id.container,Color.parseColor("#ffffff"));
                }

                holder.setText(R.id.title, lv1.title)
                        .setText(R.id.content, lv1.subTitle);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + (postion % 2));
                        Toast.makeText(mContext, "holder.getLayoutPosition():" + holder.getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
