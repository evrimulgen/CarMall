package com.loading.carmall.mock;


import com.loading.carmall.adapter.GoodsParameterAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.AbstractExpandableItem;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.MultiItemEntity;

/**
 * Created by luoxw on 2016/8/10.
 */

public class Level1Item implements MultiItemEntity {
    public String title;
    public String subTitle;

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    private int postion;

    public Level1Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return GoodsParameterAdapter.TYPE_LEVEL_1;
    }

}