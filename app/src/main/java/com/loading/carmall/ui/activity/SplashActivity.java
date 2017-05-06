package com.loading.carmall.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loading.carmall.R;
import com.loading.carmall.utils.ShortcutUtils;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class SplashActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //添加快捷方式
        ShortcutUtils.addShortcut(this,"3213216531651321321631");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0版本
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission
                    .ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //没有定位权限
                getPersimmions();
            } else {
                //有权限
                goHomeActivity();
            }
        } else {
            //6.0以下
         goHomeActivity();
        }
    }

    private void goHomeActivity(){
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            /*
             * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
//            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
//            }
            // 读取电话状态权限
//            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
//                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
//            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions   将结果转发给EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);


    }
    /**
     * 用户给权限了   如果是定位权限 则进入主界面
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        goHomeActivity();
    }
    /**
     * 权限被拒绝胃
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this, "不给我定位权限不让进，帮我想个词怎么说", R.string.setting, R.string.cancel, perms);

    }
}
