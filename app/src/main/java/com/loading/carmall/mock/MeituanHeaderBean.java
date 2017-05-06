package com.loading.carmall.mock;


import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;

import java.util.List;


public class MeituanHeaderBean extends BaseIndexPinyinBean {
    private List<String> cityList;
    //悬停ItemDecoration显示的Tag
    private String suspensionTag;

    public MeituanHeaderBean() {
    }

    public MeituanHeaderBean(List<String> cityList, String suspensionTag, String indexBarTag) {
        this.cityList = cityList;
        this.suspensionTag = suspensionTag;
        this.setBaseIndexTag(indexBarTag);
    }

    public List<String> getCityList() {
        return cityList;
    }

    public MeituanHeaderBean setCityList(List<String> cityList) {
        this.cityList = cityList;
        return this;
    }

    public MeituanHeaderBean setSuspensionTag(String suspensionTag) {
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