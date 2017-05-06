package com.loading.carmall.utils.okhttp.builder;


import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.request.OtherRequest;
import com.loading.carmall.utils.okhttp.request.RequestCall;

public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
