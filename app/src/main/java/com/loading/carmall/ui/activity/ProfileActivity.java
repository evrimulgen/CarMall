package com.loading.carmall.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loading.carmall.MainActivity;
import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.ui.weiget.GlideCircleTransform;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.path;

/**
 * Created by 马小布 on 2017/4/27.
 * Project : 首页底部导航栏
 * Program Name :  com.loading.carmall.ui.activity.ProfileActivity.java
 * Author :马庆龙 on 2017/4/27 9:18
 * email:maxiaobu1999@163.com
 * 功能：个人资料
 * 伪码：
 * 待完成：
 */
public class ProfileActivity extends BaseAty implements View.OnClickListener {
    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.iv_avatar)
    ImageView mIvAvatar;
    @Bind(R.id.ly_avatar)
    LinearLayout mLyAvatar;
    @Bind(R.id.tv_nickname)
    TextView mTvNickname;
    @Bind(R.id.ly_nickname)
    LinearLayout mLyNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "个人信息");
        Glide.with(this).load(R.drawable.test_11).transform(new GlideCircleTransform(this))
                .into(mIvAvatar);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ly_avatar, R.id.ly_nickname, R.id.ly_gender, R.id.ly_phone_num, R.id.ly_email})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_avatar:
                // 进入相册
                FunctionOptions options = new FunctionOptions.Builder()
                        .setType(FunctionConfig.TYPE_IMAGE) // 图片or视频 FunctionConfig.TYPE_IMAGE  TYPE_VIDEO
                        .setCropMode(FunctionConfig.CROP_MODEL_1_1) // 裁剪模式 默认、1:1、3:4、3:2、16:9
                        .setCompress(true) //是否压缩
                        .setEnablePixelCompress(true) //是否启用像素压缩
                        .setEnableQualityCompress(true) //是否启质量压缩
                        .setMaxSelectNum(1) // 可选择图片的数量
                        .setSelectMode(FunctionConfig.MODE_SINGLE) // 单选 or 多选
                        .setShowCamera(true) //是否显示拍照选项 这里自动根据type 启动拍照或录视频
                        .setEnablePreview(true) // 是否打开预览选项
                        .setEnableCrop(true) // 是否打开剪切选项
                        .setPreviewVideo(false) // 是否预览视频(播放) mode or 多选有效
                        .setCheckedBoxDrawable(R.drawable.select_cb)//图片勾选样式
                        .setRecordVideoDefinition(FunctionConfig.HIGH) // 视频清晰度
                        .setRecordVideoSecond(60) // 视频秒数
                        .setGif(false)// 是否显示gif图片，默认不显示
                        .setCropW(200) // cropW-->裁剪宽度 值不能小于100  如果值大于图片原始宽高 将返回原图大小
                        .setCropH(300) // cropH-->裁剪高度 值不能小于100 如果值大于图片原始宽高 将返回原图大小
                        .setMaxB(200) // 压缩最大值 例如:200kb  就设置202400，202400 / 1024 = 200kb左右
//                        .setPreviewColor(previewColor) //预览字体颜色
//                        .setCompleteColor(completeColor) //已完成字体颜色
//                        .setPreviewBottomBgColor(previewBottomBgColor) //预览底部背景色
//                        .setBottomBgColor(bottomBgColor) //图片列表底部背景色
                        .setGrade(Luban.THIRD_GEAR) // 压缩档次 默认三档
//                        .setCheckNumMode(true)//是否显示QQ选择风格(带数字效果)
                        .setCompressQuality(100) // 图片裁剪质量,默认无损
                        .setImageSpanCount(4) // 每行个数
//                        .setSelectMedia(selectMedia) // 已选图片，传入在次进去可选中，不能传入网络图片
                        .setCompressFlag(2) // 1 系统自带压缩 2 luban压缩
                        .setCompressW(0) // 压缩宽 如果值大于图片原始宽高无效
                        .setCompressH(0) // 压缩高 如果值大于图片原始宽高无效
//                        .setThemeStyle(themeStyle) // 设置主题样式
                        .create();
                // 先初始化参数配置，在启动相册
                PictureConfig.getPictureConfig().init(options).openPhoto(mActivity, resultCallback);

                break;
            //修改昵称
            case R.id.ly_nickname:
                startActivity(new Intent(this, ModifyNickActivity.class));
                break;
            case R.id.ly_gender:
                break;
            case R.id.ly_phone_num:
                break;
            case R.id.ly_email:
                break;
            default:
                break;
        }
    }

    private List<LocalMedia> selectMedia = new ArrayList<>();//图片地址列表
    /**
     * 图片回调方法
     */
    private PictureConfig.OnSelectResultCallback resultCallback = new PictureConfig.OnSelectResultCallback() {
        @Override
        public void onSelectSuccess(List<LocalMedia> resultList) {
            selectMedia = resultList;
            Log.i("callBack_result", selectMedia.size() + "");
            LocalMedia media = resultList.get(0);
            String path;
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                 path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                 path = media.getCompressPath();
            } else {
                // 原图地址
                 path = media.getPath();
            }
            if (selectMedia != null) {
                Glide.with(mActivity).load(path).transform(new GlideCircleTransform(mActivity))
                        .into(mIvAvatar);
            }
        }
    };
}
