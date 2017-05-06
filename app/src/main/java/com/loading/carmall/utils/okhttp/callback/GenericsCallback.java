package com.loading.carmall.utils.okhttp.callback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Response;


/**
    *Created by 马小布 on 2017/4/20.
    *Project : okhttp工具
    *Program Name :  com.zhy.http.okhttp.callback.GenericsCallback.java
    *Author :马庆龙 on 2017/4/20 9:54
    *email:maxiaobu1999@163.com
    *功能：泛型回调
    *伪码：
    *待完成：
*/
@SuppressWarnings("WeakerAccess")
public abstract class GenericsCallback<T> extends Callback<T> {
    private IGenericsSerializator mGenericsSerializator;

    public GenericsCallback(IGenericsSerializator serializator) {
        mGenericsSerializator = serializator;
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public T parseNetworkResponse(Response response, int id) throws IOException {
        String string = response.body().string();

        @SuppressWarnings("unchecked")
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            //noinspection unchecked
            return (T) string;
        }
        T bean = mGenericsSerializator.transform(string, entityClass);
        return bean;
    }

}
