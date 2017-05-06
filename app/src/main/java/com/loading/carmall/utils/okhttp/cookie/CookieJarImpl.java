package com.loading.carmall.utils.okhttp.cookie;

import com.loading.carmall.utils.okhttp.cookie.store.CookieStore;
import com.loading.carmall.utils.okhttp.utils.Exceptions;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
    *Created by 马小布 on 2017/4/16.
    *Project : okhttp封装
    *Program Name :  com.zhy.http.okhttp.cookie.CookieJarImpl.java
    *Author :马庆龙 on 2017/4/16 下午4:44
    *email:maxiaobu1999@163.com
    *功能：自己实现CookieJar接口，编写cookie管理相关代码，处理cookie
    *伪码：
    *待完成：
*/
public class CookieJarImpl implements CookieJar
{
    private CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore)
    {
        if (cookieStore == null) Exceptions.illegalArgument("cookieStore can not be null.");
        this.cookieStore = cookieStore;
    }

    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies)
    {
        cookieStore.add(url, cookies);
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl url)
    {
        return cookieStore.get(url);
    }

    public CookieStore getCookieStore()
    {
        return cookieStore;
    }
}
