package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.ui.fragment.FindCarFragment;
import com.loading.carmall.ui.fragment.HomeFragment;
import com.loading.carmall.ui.fragment.InformationFragment;
import com.loading.carmall.ui.fragment.MineFragment;
import com.loading.carmall.ui.weiget.bottomtab.TabView;
import com.loading.carmall.ui.weiget.bottomtab.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseAty {
    @Bind(R.id.bottom_navigation_bar)
    TabView mBottomNavigationBar;
    @Bind(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    /**
     * false：当前为首页 true:当前非首页
     */
    private boolean isHomePage = false;
    /**
     * 是否可以退出应用
     */
    private boolean isExit = true;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d("HomeActivity", "create");
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.btn_home_home, R.drawable.btn_home_home_unsel, "首页", HomeFragment.newInstance());
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.btn_home_wallet, R.drawable.btn_home_wallet_unsel, "寻车", new FindCarFragment());
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.btn_home_order, R.drawable.btn_home_order_unsel, "资讯", InformationFragment.newInstance());
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.btn_home_mine, R.drawable.btn_home_mine_unsel, "我的", new MineFragment());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        mBottomNavigationBar.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        mBottomNavigationBar.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
                isHomePage = position == 0;
            }
        });
        isHomePage = true;

        initView();
        initData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Log.d("HomeActivity", "restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Log.d("HomeActivity", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d("HomeActivity", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Log.d("HomeActivity", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Log.d("HomeActivity", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.d("HomeActivity", "destroy");
        ButterKnife.unbind(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        Log.d("HomeActivity", "onSaveInstanceState2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d("HomeActivity", "onSaveInstanceState");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
    }


    @Override
    public void onBackPressed() {
        if (isHomePage) {
            exit();
        } else {
            mBottomNavigationBar.swichPostion(0);
        }
        isHomePage = true;
    }

    /**
     * 退出应用
     */
    private void exit() {
        if (isExit) {
            isExit = false;
            Toast.makeText(getApplicationContext(), "再按一次退出",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
        }
    }


}
