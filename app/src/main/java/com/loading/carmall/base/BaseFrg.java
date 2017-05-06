package com.loading.carmall.base;

import android.content.Intent;

/**
 *
 *                         _oo0oo_
 *                        o8888888o
 *                        88" . "88
 *                        (| -_- |)
 *                        0\  =  /0
 *                      ___/`---'\___
 *                    .' \\|     |# '.
 *                   / \\|||  :  |||# \
 *                  / _||||| -:- |||||- \
 *                 |   | \\\  -  #/ |   |
 *                 | \_|  ''\---/''  |_/ |
 *                 \  .-\__  '-'  ___/-. /
 *               ___'. .'  /--.--\  `. .'___
 *            ."" '<  `.___\_<|>_/___.' >' "".
 *           | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *           \  \ `_.   \_ __\ /__ _/   .-` /  /
 *       =====`-.____`.___ \_____/___.-`___.-'=====
 *                         `=---='
 *
 *
 *       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 *                 佛祖保佑         永无BUG
 *
 *
 *
 */
public abstract class BaseFrg extends android.support.v4.app.Fragment {
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    abstract public void initView();

    abstract public void initData();
}
