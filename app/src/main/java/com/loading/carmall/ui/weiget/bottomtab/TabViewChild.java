package com.loading.carmall.ui.weiget.bottomtab;

import android.support.v4.app.Fragment;

/**
    *Created by 马小布 on 2017/4/20.
    *Project : 首页底部导航栏
    *Program Name :  com.loading.carmall.ui.weiget.bottomtab.TabViewChild.java
    *Author :马庆龙 on 2017/4/20 13:55
    *email:maxiaobu1999@163.com
    *功能：子布局item
    *伪码：
    *待完成：
*/
public class TabViewChild {
    private int imageViewSelIcon;
    private int imageViewUnSelIcon;
    private String textViewText;
    private Fragment mFragment;


    private TabViewChild(){

    }
    public TabViewChild(int imageViewSelIcon,int imageViewUnSelIcon,String textViewText,Fragment mFragment) {
        this.imageViewSelIcon = imageViewSelIcon;
        this.imageViewUnSelIcon=imageViewUnSelIcon;
        this.textViewText = textViewText;
        this.mFragment=mFragment;
    }


    public int getImageViewSelIcon() {
        return imageViewSelIcon;
    }


    public void setImageViewSelIcon(int imageViewSelIcon) {
        this.imageViewSelIcon = imageViewSelIcon;
    }


    public int getImageViewUnSelIcon() {
        return imageViewUnSelIcon;
    }


    public void setImageViewUnSelIcon(int imageViewUnSelIcon) {
        this.imageViewUnSelIcon = imageViewUnSelIcon;
    }


    public String getTextViewText() {
        return textViewText;
    }


    public void setTextViewText(String textViewText) {
        this.textViewText = textViewText;
    }


    public Fragment getmFragment() {
        return mFragment;
    }

    public void setmFragment(Fragment mFragment) {
        this.mFragment = mFragment;
    }
}
