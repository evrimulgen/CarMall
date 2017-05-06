package com.loading.carmall.mock;


import com.loading.carmall.adapter.GoodsParameterAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.AbstractExpandableItem;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.MultiItemEntity;

/**
 * Created by luoxw on 2016/8/10.
 */
public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    public String title;
    public String subTitle;

    public Level0Item( String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return GoodsParameterAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
