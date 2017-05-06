package com.loading.carmall.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.base.BaseAty;
import com.loading.carmall.utils.pictureselector.FullyGridLayoutManager;
import com.loading.carmall.utils.pictureselector.GridImageAdapter;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EvaluationActivity extends BaseAty {

    @Bind(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @Bind(R.id.toolbar_common)
    Toolbar mToolbarCommon;
    @Bind(R.id.image_view)
    ImageView mImageView;
    @Bind(R.id.rb_grade)
    RatingBar mRbGrade;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<LocalMedia> selectMedia = new ArrayList<>();
    private GridImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setCommonBackToolBar(mToolbarCommon, mTvTitleCommon, "评价");

        FullyGridLayoutManager manager = new FullyGridLayoutManager(mActivity, 4, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new GridImageAdapter(mActivity, onAddPicClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
//                switch (selectType) {
//                    case FunctionConfig.TYPE_IMAGE:
                        // 预览图片
                        PictureConfig.getPictureConfig().externalPicturePreview(mActivity, position, selectMedia);
//                        break;
//                    case FunctionConfig.TYPE_VIDEO:
//                        // 预览视频
//                        PictureConfig.getPictureConfig().externalPictureVideo(mContext, selectMedia.get(position).getPath());
//                        break;
//                }

            }
        });
    }

    @Override
    public void initData() {

    }

    /**
     * 删除图片回调接口
     */
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick(int type, int position) {
            switch (type) {
                case 0:
                    // 进入相册

                    FunctionOptions options = new FunctionOptions.Builder()
                            .setType(FunctionConfig.TYPE_IMAGE) // 图片or视频 FunctionConfig.TYPE_IMAGE  TYPE_VIDEO
                            .setCropMode(FunctionConfig.CROP_MODEL_DEFAULT) // 裁剪模式 默认、1:1、3:4、3:2、16:9
                            .setCompress(true) //是否压缩
                            .setEnablePixelCompress(true) //是否启用像素压缩
                            .setEnableQualityCompress(true) //是否启质量压缩
                            .setMaxSelectNum(9) // 可选择图片的数量
                            .setSelectMode(FunctionConfig.MODE_MULTIPLE) // 单选 or 多选
                            .setShowCamera(true) //是否显示拍照选项 这里自动根据type 启动拍照或录视频
//                            .setEnablePreview(true) // 是否打开预览选项
//                            .setEnableCrop(true) // 是否打开剪切选项
                            .setPreviewVideo(false) // 是否预览视频(播放) mode or 多选有效
                            .setCheckedBoxDrawable(R.drawable.select_cb)//图片勾选样式
                            .setRecordVideoDefinition(FunctionConfig.HIGH) // 视频清晰度
                            .setRecordVideoSecond(60) // 视频秒数
                            .setGif(false)// 是否显示gif图片，默认不显示
//                            .setCropW(200) // cropW-->裁剪宽度 值不能小于100  如果值大于图片原始宽高 将返回原图大小
//                            .setCropH(300) // cropH-->裁剪高度 值不能小于100 如果值大于图片原始宽高 将返回原图大小
//                            .setMaxB(200) // 压缩最大值 例如:200kb  就设置202400，202400 / 1024 = 200kb左右
//                        .setPreviewColor(previewColor) //预览字体颜色
//                        .setCompleteColor(completeColor) //已完成字体颜色
//                        .setPreviewBottomBgColor(previewBottomBgColor) //预览底部背景色
//                        .setBottomBgColor(bottomBgColor) //图片列表底部背景色
                            .setGrade(Luban.THIRD_GEAR) // 压缩档次 默认三档
//                        .setCheckNumMode(true)//是否显示QQ选择风格(带数字效果)
                            .setCompressQuality(100) // 图片裁剪质量,默认无损
                            .setImageSpanCount(4) // 每行个数
                        .setSelectMedia(selectMedia) // 已选图片，传入在次进去可选中，不能传入网络图片
                            .setCompressFlag(2) // 1 系统自带压缩 2 luban压缩
                            .setCompressW(0) // 压缩宽 如果值大于图片原始宽高无效
                            .setCompressH(0) // 压缩高 如果值大于图片原始宽高无效
//                        .setThemeStyle(themeStyle) // 设置主题样式
                            .create();

                    // 先初始化参数配置，在启动相册
                    PictureConfig.getPictureConfig().init(options).openPhoto(mActivity, resultCallback);
                    break;
                case 1:
                    // 删除图片
                    selectMedia.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    break;
            }
        }
    };

    /**
     * 图片回调方法
     */
    private PictureConfig.OnSelectResultCallback resultCallback = new PictureConfig.OnSelectResultCallback() {
        @Override
        public void onSelectSuccess(List<LocalMedia> resultList) {
            selectMedia = resultList;
            Log.i("callBack_result", selectMedia.size() + "");
            LocalMedia media = resultList.get(0);
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                String path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                String path = media.getCompressPath();
            } else {
                // 原图地址
                String path = media.getPath();
            }
            if (selectMedia != null) {
                mAdapter.setList(selectMedia);
                mAdapter.notifyDataSetChanged();
            }
        }
    };

}
