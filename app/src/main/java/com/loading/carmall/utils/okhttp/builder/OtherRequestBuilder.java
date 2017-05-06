package com.loading.carmall.utils.okhttp.builder;


import com.loading.carmall.utils.okhttp.request.OtherRequest;
import com.loading.carmall.utils.okhttp.request.RequestCall;

import okhttp3.RequestBody;

/**
 * DELETE、PUT、PATCH等其他方法
 */
public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder>
{
    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method)
    {
        this.method = method;
    }

    @Override
    public RequestCall build()
    {
        return new OtherRequest(requestBody, content, method, url, tag, params, headers,id).build();
    }

    @SuppressWarnings("unused")
    public OtherRequestBuilder requestBody(RequestBody requestBody)
    {
        this.requestBody = requestBody;
        return this;
    }

    @SuppressWarnings("unused")
    public OtherRequestBuilder requestBody(String content)
    {
        this.content = content;
        return this;
    }


}
