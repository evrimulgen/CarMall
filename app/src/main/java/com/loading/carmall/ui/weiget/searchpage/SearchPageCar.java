package com.loading.carmall.ui.weiget.searchpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.bean.SearchAtyHotBean;
import com.loading.carmall.bean.SearchAtyResultBean;
import com.loading.carmall.ui.weiget.InnerRecyclerView;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseQuickAdapter;
import com.loading.carmall.ui.weiget.reacyclerviewhelper.BaseViewHolder;
import com.loading.carmall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马小布 on 2017/5/9.
 * Project : recycler adapter封装
 * Program Name :  com.loading.carmall.ui.weiget.searchpage.SearchPageCar.java
 * Author :马庆龙 on 2017/5/9 11:58
 * email:maxiaobu1999@163.com
 * 功能：搜索控件
 * 伪码：
 * 待完成：
 */
public class SearchPageCar extends LinearLayout {

    private String msearch_hint;
    private int msearch_baground;
    Context context;
    private ImageView ib_searchtext_delete;
    private EditText et_searchtext_search;
    private Button bt_text_search_back;
    private TextView tvclearolddata;


    //历史搜索
    private InnerRecyclerView mRvHistorySearch;
    private SearchHistoryAdapter mSearchHistoryAdapter;
    private ArrayList<String> OldDataList = new ArrayList<>();
    //热门搜索
//    FlowLayout hotflowLayout;
    RecyclerView mRvHotSearch;

    private String backtitle = "取消", searchtitle = "搜索";
    public OnClickListener TextViewItemListener;
    @SuppressWarnings("FieldCanBeLocal")
    private int countOldDataSize = 15;//默认搜索记录的条数， 正确的是传入进来的条数
    private RecyclerView mRvResult;
    private BaseQuickAdapter<SearchAtyResultBean.DataBean, BaseViewHolder> mResultAdapter;


    public SearchPageCar(Context context) {
        super(context);
        this.context = context;
        InitView();
    }

    public SearchPageCar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.searchmlist);
        msearch_hint = ta.getString(R.styleable.searchmlist_search_hint);
        msearch_baground = ta.getResourceId(R.styleable.searchmlist_search_baground, R.color.transparent);
        ta.recycle();


        InitView();
    }

    public SearchPageCar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        InitView();
    }


    private void InitView() {
        backtitle = getResources().getString(R.string.search_cancel);
        searchtitle = getResources().getString(R.string.search_verify);

        @SuppressLint("InflateParams") LinearLayout searchview =
                (LinearLayout) LayoutInflater.from(context)
                        .inflate(R.layout.search_page_car, null);
        searchview.setLayoutParams(new LinearLayoutCompat
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT));
        //把获得的view加载到这个控件中
        addView(searchview);
        //把两个按钮从布局文件中找到
        ib_searchtext_delete = (ImageView) searchview.findViewById(R.id.ib_searchtext_delete);
        et_searchtext_search = (EditText) searchview.findViewById(R.id.et_searchtext_search);
        et_searchtext_search.setBackgroundResource(msearch_baground);
        et_searchtext_search.setHint(msearch_hint);
        //搜索返回时一个按钮
        bt_text_search_back = (Button) searchview.findViewById(R.id.buttonback);
        //清除历史记录
        tvclearolddata = (TextView) searchview.findViewById(R.id.tvclearolddata);

        mRvHistorySearch = (InnerRecyclerView) searchview.findViewById(R.id.Rv_history_search);
        mRvHotSearch = (RecyclerView) searchview.findViewById(R.id.rv_hot_search);

        mRvResult = (RecyclerView) searchview.findViewById(R.id.rv_result);
        mRvResult.setLayoutManager(new LinearLayoutManager(context));
        mRvResult.setHasFixedSize(true);
        mResultAdapter = new BaseQuickAdapter<SearchAtyResultBean.DataBean,
                BaseViewHolder>(R.layout.item_search_aty_result) {
            @Override
            protected void convert(BaseViewHolder helper, SearchAtyResultBean.DataBean item) {

            }
        };
        mResultAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        View notDataView = LayoutInflater.from(context)
                .inflate(R.layout.empty_view,
                        (ViewGroup) mRvResult.getParent(), false);
        LinearLayout container = (LinearLayout) notDataView.findViewById(R.id.container);
        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
        layoutParams.height = ScreenUtils.getScreenHeight(context) - 200;

        mRvResult.setAdapter(mResultAdapter);

        mResultAdapter.setEmptyView(notDataView);

        setLinstener();

    }


    //文本观察者
    private class MyTextWatcher implements TextWatcher {

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        //当文本改变时候的操作
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            //如果编辑框中文本的长度大于0就显示删除按钮否则不显示
            if (s.length() > 0) {
                ib_searchtext_delete.setVisibility(View.VISIBLE);
                bt_text_search_back.setText(searchtitle);
            } else {
                ib_searchtext_delete.setVisibility(View.GONE);
                bt_text_search_back.setText(backtitle);
            }
        }

    }

    private void setLinstener() {
        //给删除按钮添加点击事件
        ib_searchtext_delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                et_searchtext_search.setText("");
            }
        });
        //给编辑框添加文本改变事件
        et_searchtext_search.addTextChangedListener(new MyTextWatcher());


        et_searchtext_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    String searchtext = et_searchtext_search.getText().toString().trim();
                    //dosoming
//                    Toast.makeText(context, "搜索" +searchtext, Toast.LENGTH_SHORT).show();

                    executeSearch_and_NotifyDataSetChanged(searchtext);

                    return true;
                }
                return false;
            }
        });


        bt_text_search_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchtext = et_searchtext_search.getText().toString().trim();
                if (bt_text_search_back.getText().toString().equals(searchtitle)) {
//                    Toast.makeText(context, "点击button搜索" + searchtext, Toast.LENGTH_SHORT).show();
                    executeSearch_and_NotifyDataSetChanged(searchtext);
                } else {
//                    Toast.makeText(context, "点击button  返回", Toast.LENGTH_SHORT).show();
                    if (sCBlistener != null)
                        if (mRvResult.getVisibility() == VISIBLE) {
                            mRvResult.setVisibility(GONE);
                        } else {
                            sCBlistener.Back();
                        }
                }
            }
        });


        tvclearolddata.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "清除历史搜索记录", Toast.LENGTH_SHORT).show();
                if (sCBlistener != null) {
                    OldDataList.clear();
                    mSearchHistoryAdapter.notifyDataSetChanged();
                    sCBlistener.ClearOldData();
                }
            }
        });


        TextViewItemListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = ((TextView) v).getText().toString();

//                Toast.makeText(context, "Item点击"+string, Toast.LENGTH_SHORT).show();

                executeSearch_and_NotifyDataSetChanged(string);

            }
        };


    }


    /**
     * @param olddatalist 历史搜索数据集合
     * @param hotdata     热门搜索数据集合
     * @param sCb         事件处理监听
     */
    public void initData(List<String> olddatalist,
                         List<SearchAtyHotBean.DataBean> hotdata,
                         setSearchCallBackListener sCb) {

        SetCallBackListener(sCb);
//        hotflowLayout.removeAllViews();
        OldDataList.clear();
        if (olddatalist != null)
            OldDataList.addAll(olddatalist);

//        countOldDataSize = OldDataList.size();
        mRvHistorySearch.setLayoutManager(new LinearLayoutManager(context));
//        mRvHistorySearch.setNestedScrollingEnabled(false);
        mRvHistorySearch.setNestedScrollingEnabled(false);
        mSearchHistoryAdapter = new SearchHistoryAdapter( OldDataList);
        mRvHistorySearch.setAdapter(mSearchHistoryAdapter);


        mRvHotSearch.setLayoutManager(new GridLayoutManager(context, 3));
        SearchHotAdapter hotAdapter = new SearchHotAdapter(context, hotdata, this);
        mRvHotSearch.setAdapter(hotAdapter);
        mSearchHistoryAdapter.setOnItemClickListener(new SearchHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String tarid, int position) {
                if (sCBlistener != null) {
                    sCBlistener.Search(OldDataList.get(position).trim());
                }
            }
        });


    }


    private void executeSearch_and_NotifyDataSetChanged(String str) {
        if (sCBlistener != null && (!str.equals(""))) {
            if (OldDataList.size() > 0 && OldDataList.get(0).equals(str)) {
            } else {
                if (OldDataList.size() == countOldDataSize && OldDataList.size() > 0)
                    OldDataList.remove(OldDataList.size() - 1);
                OldDataList.add(0, str);//把最新的添加到前面
                mSearchHistoryAdapter.notifyDataSetChanged();
                sCBlistener.SaveOldData(OldDataList);
            }
            sCBlistener.Search(str);
        }
    }

    //对外开发的接口
//--------------------------------------------------------------------------------------

    public void showResult(List<SearchAtyResultBean.DataBean> resultDatas) {
        mRvResult.setVisibility(VISIBLE);
        mResultAdapter.setNewData(resultDatas);
    }

    public void hideResult() {
        mRvResult.setVisibility(GONE);
    }
    public boolean isResultShow(){
        return mRvResult.getVisibility()==VISIBLE;
    }

    /**
     * @author liuyunming
     */
    public interface setSearchCallBackListener {

        /**
         * @param str 搜索关键字
         */
        void Search(String str);

        /**
         * 后退
         */
        void Back();

        /**
         * 清除历史搜索记录
         */
        void ClearOldData();

        /**
         * 保存搜索记录
         */
        void SaveOldData(ArrayList<String> allHistoryDataList);

    }

    private setSearchCallBackListener sCBlistener;

    /**
     * 设置接口回调
     *
     * @param sCb setCallBackListener接口
     */
    private void SetCallBackListener(setSearchCallBackListener sCb) {
        sCBlistener = sCb;
    }

}
