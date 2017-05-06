package com.loading.carmall.utils.okhttp.callback;



import android.util.Log;
import android.widget.Toast;

import com.loading.carmall.App;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
    *Created by 马小布 on 2017/4/16.
    *Project : okhttp封装
    *Program Name :  com.zhy.http.okhttp.callback.Callback.java
    *Author :马庆龙 on 2017/4/16 下午5:03
    *email:maxiaobu1999@163.com
    *功能：设置回调种类的地方
    *伪码：
    *待完成：
*/
public abstract class Callback<T> {
    public void onNodata() {
    }
    public abstract void onSuccess(T response, int id);

    /**
     * 主线
     */
    public void onBefore(Request request, int id) {
    }

    /**
     * 主线程
     */
    public void onAfter(int id) {
    }

    /**
     * 主线程
     *  加载进度
     */
    public void inProgress(float progress, long total, int id) {

    }

    /**
     * if you parse reponse code in parseNetworkResponse, you should make this method return true.
     */
    public boolean validateReponse(Response response, int id) {
        return response.isSuccessful();
    }

    /**
     * Thread Pool Thread
     */
    public abstract T parseNetworkResponse(Response response, int id) throws Exception;

    public abstract void onError(Call call, Exception e, int id);

    public  void onResponse(T response, int id){

    }


    public static Callback CALLBACK_DEFAULT = new Callback() {

        @Override
        public void onSuccess(Object response, int id) {

        }

        @Override
        public Object parseNetworkResponse(Response response, int id) throws Exception {
            return null;
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            Log.d("ok封装Callback", e.toString());
            Toast.makeText(App.getInstance(), "服务器问题", Toast.LENGTH_LONG).show();

        }


    };

}