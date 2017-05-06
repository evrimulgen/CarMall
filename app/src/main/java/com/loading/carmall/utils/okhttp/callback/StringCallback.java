package com.loading.carmall.utils.okhttp.callback;

import java.io.IOException;

import okhttp3.Response;


/**
 * Created by 马小布 on 2017/4/16.
 * Project : okhttp封装
 * Program Name :  com.zhy.http.okhttp.callback.StringCallback.java
 * Author :马庆龙 on 2017/4/16 下午5:01
 * email:maxiaobu1999@163.com
 * 功能：返回类型为string的回调
 * 伪码：
 * 待完成：
 */
public abstract class StringCallback extends Callback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        //  处理网络异常&code status
        return response.body().string();
    }
}
