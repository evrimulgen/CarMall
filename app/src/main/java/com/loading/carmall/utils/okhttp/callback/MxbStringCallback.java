package com.loading.carmall.utils.okhttp.callback;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.loading.carmall.App;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
public abstract class MxbStringCallback extends Callback<String> {

    public abstract void onResultFalse(String result);

    @Override
    public void onResponse(String response, int id) {
        super.onResponse(response, id);
        Log.d("MxbStringCallback","一手返回结果为："+ response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean result = jsonObject.getBoolean("result");
            String message = jsonObject.getString("msg");
            String data = jsonObject.getString("data");
            if (result) {
                //成功
                String urlDecoder = URLDecoder.decode(data, "UTF-8").trim();
                byte[] decode = Base64.decode(urlDecoder.getBytes(), Base64.DEFAULT);
                String json = new String(decode);
                if ("[]".equals(json)) {
                    onNodata();
                    Log.d("MxbStringCallback", "请求到的数据为null需要处理");
                } else {
                    String formatJson = "{\"data\":" +
                            json +
                            "}";
                    onSuccess(formatJson, id);
                }


            } else {
                onResultFalse(message);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(App.getInstance(), "返回的数据没有result或message字段", Toast.LENGTH_SHORT).show();
        } catch (UnsupportedEncodingException e) {
            //设备不支持解析编码
            Toast.makeText(App.getInstance(), "设备不支持后台订的解析编码格式", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        //  处理网络异常&code status   response.body().string()
//        Log.d("MxbStringCallback", response.body().string());
//        String json = null;
//        try {
//            JSONObject jsonObject = new JSONObject(response.body().string());
//            boolean result = jsonObject.getBoolean("result");
//            String message = jsonObject.getString("msg");
//            String data = jsonObject.getString("data");
//            if (result) {
//                //成功
//                String urlDecoder = URLDecoder.decode(data, "UTF-8").trim();
//                byte[] decode = Base64.decode(urlDecoder.getBytes(), Base64.DEFAULT);
//                json = new String(decode);
//
//            } else {
//                onResultFalse(message);
//                return null;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Toast.makeText(App.getInstance(), "返回的数据没有result或message字段", Toast.LENGTH_SHORT).show();
//        } catch (UnsupportedEncodingException e) {
//            //设备不支持解析编码
//            Toast.makeText(App.getInstance(), "设备不支持后台订的解析编码格式", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }
        return response.body().string();

    }
}
