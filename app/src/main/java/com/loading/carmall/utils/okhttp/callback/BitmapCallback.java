package com.loading.carmall.utils.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;

/**
    *Created by 马小布 on 2017/4/20.
    *Project : okhttp工具
    *Program Name :  com.zhy.http.okhttp.callback.BitmapCallback.java
    *Author :马庆龙 on 2017/4/20 9:24
    *email:maxiaobu1999@163.com
    *功能：图片回调
    *伪码：
    *待完成：
*/
public abstract class BitmapCallback extends Callback<Bitmap>
{
    @Override
    public Bitmap parseNetworkResponse(Response response , int id) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }

}
