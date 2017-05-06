package com.loading.carmall;

import android.app.Application;

import com.loading.carmall.service.LocationService;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

public class App extends Application {

    private static App instance;

    /**
     * 定位service
     */
    public LocationService locationService;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

          /* Bugly SDK初始化
        * 参数1：上下文对象
        * 参数2：APPID，平台注册时得到,注意替换成你的appId
        * 参数3：是否开启调试模式，调试模式下会输出'CrashReport'tag的日志
        */
//        CrashReport.initCrashReport(getApplicationContext(), "64b134fb11", true);
        /**
         * 参数解析：
         * 参数1：上下文对象
         * 参数2：注册时申请的APPID
         * 参数3：是否开启debug模式，true表示打开debug模式，false表示关闭调试模式
         * 提示：已经接入Bugly用户改用上面的初始化方法,不影响原有的crash上报功能; init方法会自动检测更新，不需要再手动调用Beta.checkUpgrade(), 如需增加自动检查时机可以使用Beta.checkUpgrade(false,false);
         * 参数1：isManual 用户手动点击检查，非用户点击操作请传false
         * 参数2：isSilence 是否显示弹窗等交互，[true:没有弹窗和toast] [false:有弹窗或toast]
         */
        Bugly.init(getApplicationContext(), "64b134fb11", false);

        instance = this;
        // 初始化百度定位服务，建议在Application中创建
        locationService = new LocationService(getApplicationContext());
//        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this);     		// 初始化 JPush

    }
}
