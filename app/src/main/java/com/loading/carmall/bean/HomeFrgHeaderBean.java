package com.loading.carmall.bean;

import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFrgHeaderBean extends BaseIndexPinyinBean {
    private List<ArticlegetbannnerBean.DataBean> bannerDatas;
    private List<CartGethotbrandBean.DataBean> hotBrandDatas;



    List<ArticleGetheadlinesBean.DataBean> headLinesDatas;
    //悬停ItemDecoration显示的Tag
    private String suspensionTag;

    public HomeFrgHeaderBean(String suspensionTag, String indexBarTag) {
        this.suspensionTag = suspensionTag;
        this.setBaseIndexTag(indexBarTag);
    }
    public List<ArticleGetheadlinesBean.DataBean> getHeadLinesDatas() {
        if (null==headLinesDatas)
            headLinesDatas = new ArrayList<>();
        return headLinesDatas;
    }

    public void setHeadLinesDatas(List<ArticleGetheadlinesBean.DataBean> headLinesDatas) {
        this.headLinesDatas = headLinesDatas;
    }
    public List<ArticlegetbannnerBean.DataBean> getBannerDatas() {
        if (null == bannerDatas)
            bannerDatas = new ArrayList<>();
        return bannerDatas;
    }

    public void setBannerDatas(List<ArticlegetbannnerBean.DataBean> bannerDatas) {
        this.bannerDatas = bannerDatas;
    }

    public List<CartGethotbrandBean.DataBean> getHotBrandDatas() {
        if (null == hotBrandDatas)
            hotBrandDatas = new ArrayList<>();
        return hotBrandDatas;
    }

    public void setHotBrandDatas(List<CartGethotbrandBean.DataBean> hotBrandDatas) {
        this.hotBrandDatas = hotBrandDatas;
    }


    @Override
    public String getTarget() {
        return null;
    }

    @Override
    public boolean isNeedToPinyin() {
        return false;
    }

    @Override
    public String getSuspensionTag() {
        return suspensionTag;
    }
}
