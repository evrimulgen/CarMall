package com.loading.carmall.ui.weiget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by liuyunming on 2016/7/4.
 */
public class InnerRecyclerView extends RecyclerView {

    public InnerRecyclerView(Context context) {
        super(context);
    }

    public InnerRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InnerRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec;
        if(getLayoutParams().height== ViewGroup.LayoutParams.WRAP_CONTENT)
        {
            heightSpec = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            //Integer.MAX_VALUE >> 2 == 2的31次方-1 表示的int的最大值
        }
        else {
            // Any other height should be respected as is.
            heightSpec = heightMeasureSpec;
        }
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
