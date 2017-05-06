package com.loading.carmall.bean;


import com.loading.carmall.ui.weiget.indexbar.bean.BaseIndexPinyinBean;

/**
 * 介绍：美团里的城市bean
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/11/28.
 */

public class HomeFrgBodyBean extends BaseIndexPinyinBean {
    private String city;//城市名字
    private String icon;//汽车图标

    public HomeFrgBodyBean() {
    }

    public HomeFrgBodyBean(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public HomeFrgBodyBean setCity(String city) {
        this.city = city;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getTarget() {
        return city;
    }
}
