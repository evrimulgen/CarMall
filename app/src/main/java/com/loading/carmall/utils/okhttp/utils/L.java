package com.loading.carmall.utils.okhttp.utils;

import android.util.Log;


@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class L {
    private static boolean debug = false;

    public static void e(String msg) {
        if (debug) {
            Log.e("OkHttp", msg);
        }
    }

}

