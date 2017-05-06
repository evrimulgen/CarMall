package com.loading.carmall.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.loading.carmall.ui.activity.GoodsDetailActivity;

/**
    *Created by 马小布 on 2017/4/22.
    *Project : 首页底部导航栏
    *Program Name :  com.loading.carmall.utils.ShortcutUtils.java
    *Author :马庆龙 on 2017/4/22 14:03
    *email:maxiaobu1999@163.com
    *功能：快捷方式管理类
    *伪码：
    *待完成：
*/
@SuppressWarnings("unused")
public class ShortcutUtils {
    private static final String ACTION_ADD_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final String ACTION_REMOVE_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";

    /**
     * 添加快捷方式
     * @param context   上下文
     * @param name      快捷方式 显示的名字，然而并没有毛用，还是显示appname
     */
    public static void addShortcut(Context context, String name) {
//        Toast.makeText(this,"添加快捷方式成功",Toast.LENGTH_SHORT);
        Intent addShortcutIntent = new Intent(ACTION_ADD_SHORTCUT);

        // 不允许重复创建
        addShortcutIntent.putExtra("duplicate", false);// 经测试不是根据快捷方式的名字判断重复的
        // 名字
        addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        // 图标
        addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context,
                        android.R.drawable.sym_call_outgoing));
        // 设置关联程序
        Intent launcherIntent = new Intent(Intent.ACTION_MAIN);
        launcherIntent.setClass(context, GoodsDetailActivity.class);
        launcherIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, launcherIntent);
        // 发送广播
        context.sendBroadcast(addShortcutIntent);
    }

    public static void removeShortcut(Context context, String name) {
        // remove shortcut的方法在小米系统上不管用，在三星上可以移除
        Intent intent = new Intent(ACTION_REMOVE_SHORTCUT);

        // 名字
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);

        // 设置关联程序
        Intent launcherIntent = new Intent(context, GoodsDetailActivity.class)
                .setAction(Intent.ACTION_MAIN);

        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, launcherIntent);

        // 发送广播
        context.sendBroadcast(intent);
//        Toast.makeText(context, "删除快捷方式成功", Toast.LENGTH_SHORT);
    }

    /**
     * 删除快捷方式
     */
    public void deleteShortCut(Activity activity, String shortcutName) {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        Intent intent = new Intent();
        intent.setClass(activity, activity.getClass());
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        activity.sendBroadcast(shortcut);
    }
}
