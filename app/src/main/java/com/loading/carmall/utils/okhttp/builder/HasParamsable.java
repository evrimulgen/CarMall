package com.loading.carmall.utils.okhttp.builder;

import java.util.Map;


interface HasParamsable {
    OkHttpRequestBuilder params(Map<String, String> params);

    OkHttpRequestBuilder addParams(String key, String val);
}
