package com.loading.carmall.bean;


import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;

import java.util.List;


public class HomeHeaderBean extends BaseIndexPinyinBean {
    private List<CartGethotbrandBean.DataBean> cityList;
    //悬停ItemDecoration显示的Tag
    private String suspensionTag;

    public HomeHeaderBean() {
    }

    public HomeHeaderBean(List<CartGethotbrandBean.DataBean> cityList, String suspensionTag, String indexBarTag) {
        this.cityList = cityList;
        this.suspensionTag = suspensionTag;
        this.setBaseIndexTag(indexBarTag);
    }

    public List<CartGethotbrandBean.DataBean> getCityList() {
        return cityList;
    }

    public HomeHeaderBean setCityList(List<CartGethotbrandBean.DataBean> cityList) {
        this.cityList = cityList;
        return this;
    }

    public HomeHeaderBean setSuspensionTag(String suspensionTag) {
        this.suspensionTag = suspensionTag;
        return this;
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
