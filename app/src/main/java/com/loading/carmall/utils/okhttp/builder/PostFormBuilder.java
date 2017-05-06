package com.loading.carmall.utils.okhttp.builder;


import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.loading.carmall.utils.EncryptUtils;
import com.loading.carmall.utils.okhttp.request.PostFormRequest;
import com.loading.carmall.utils.okhttp.request.RequestCall;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PostFormBuilder extends OkHttpRequestBuilder<PostFormBuilder> implements HasParamsable {
    private List<FileInput> files = new ArrayList<>();

    @Override
    public RequestCall build() {
        return new PostFormRequest(url, tag, params, headers, files, id).build();
    }

    @SuppressWarnings("unused")
    public PostFormBuilder files(String key, Map<String, File> files) {
        for (String filename : files.keySet()) {
            this.files.add(new FileInput(key, filename, files.get(filename)));
        }
        return this;
    }

    public PostFormBuilder addFile(String name, String filename, File file) {
        files.add(new FileInput(name, filename, file));
        return this;
    }

    public static class FileInput {
        public String key;
        public String filename;
        public File file;

        @SuppressWarnings("WeakerAccess")
        public FileInput(String name, String filename, File file) {
            this.key = name;
            this.filename = filename;
            this.file = file;
        }

        @Override
        public String toString() {
            return "FileInput{" +
                    "key='" + key + '\'' +
                    ", filename='" + filename + '\'' +
                    ", file=" + file +
                    '}';
        }
    }


    @Override
    public PostFormBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }


    public PostFormBuilder params(Map<String, String> params,String urlEnd) {
        if (null == params) {
            params=new LinkedHashMap<>();
        }
        Map<String, String> params1 = new HashMap<String, String>();
        Gson gson = new Gson();
        //转json
        String json = gson.toJson(params).trim();
        //转base64
        String base64Token = Base64.encodeToString(json.getBytes(), Base64.DEFAULT).trim();
        try {
            String urlEncode = URLEncoder.encode(base64Token, "UTF-8").trim();
//            urlEncode="";
//            Log.d("MainActivity", urlEncode);
            String s = urlEnd;
            String request_time = String.valueOf(System.currentTimeMillis());
//            Log.d("MainActivity", request_time);
            String signKey = "A03137B2DC3DF13063EFB406151E81D3";
            String sign = "s=" + s + "&request_time=" + request_time + "&data=" + urlEncode + "||" + signKey;
//            Log.d("MainActivity+++++++", sign);
            String md5 = EncryptUtils.encryptMD5ToString(sign.trim()).toLowerCase();
            params1.put("request_time", request_time);
            params1.put("data", urlEncode);
            params1.put("sign", md5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.params = params1;
        return this;
    }

    @Override
    public PostFormBuilder addParams(String key, String val) {
        if (this.params == null) {
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }


}
