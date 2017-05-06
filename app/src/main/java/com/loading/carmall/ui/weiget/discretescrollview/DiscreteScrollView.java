package com.loading.carmall.ui.weiget.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.loading.carmall.R;
import com.loading.carmall.ui.weiget.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.loading.carmall.ui.weiget.discretescrollview.util.ScrollListenerAdapter;

/**
 * Created by yarolegovich on 18.02.2017.
 */
@SuppressWarnings("unchecked")
public class DiscreteScrollView extends RecyclerView {

    private static final int DEFAULT_ORIENTATION = Orientation.HORIZONTAL.ordinal();

    private DiscreteScrollLayoutManager layoutManager;

    private ScrollStateChangeListener scrollStateChangeListener;
    private OnItemChangedListener onItemChangedListener;

    public DiscreteScrollView(Context context) {
        super(context);
        init(null);
    }

    public DiscreteScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DiscreteScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        int orientation = DEFAULT_ORIENTATION;
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.DiscreteScrollView);
            orientation = ta.getInt(R.styleable.DiscreteScrollView_dsv_orientation, DEFAULT_ORIENTATION);
            ta.recycle();
        }

        layoutManager = new DiscreteScrollLayoutManager(
                getContext(), new ScrollStateListener(),
                Orientation.values()[orientation]);
        setLayoutManager(layoutManager);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        if (layout instanceof DiscreteScrollLayoutManager) {
            super.setLayoutManager(layout);
        } else {
            throw new IllegalArgumentException("You should not set LayoutManager on DiscreteScrollView.class instance. Library uses a special one. Just don\\'t call the method.");
        }
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        boolean isFling = super.fling(velocityX, velocityY);
        if (isFling) {
            layoutManager.onFling(velocityX, velocityY);
        } else {
            layoutManager.returnToCurrentPosition();
        }
        return true;
    }

    @Nullable
    public ViewHolder getViewHolder(int position) {
        View view = layoutManager.findViewByPosition(position);
        return view != null ? getChildViewHolder(view) : null;
    }

    /**
     * @return adapter position of the current item or -1 if nothing is selected
     */
    public int getCurrentItem() {
        return layoutManager.getCurrentPosition();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer transformer) {
        layoutManager.setItemTransformer(transformer);
    }

    public void setItemTransitionTimeMillis(@IntRange(from = 10) int millis) {
        layoutManager.setTimeForItemSettle(millis);
    }

    public void setOrientation(Orientation orientation) {
        layoutManager.setOrientation(orientation);
    }

    public void setOffscreenItems(int items) {
        layoutManager.setOffscreenItems(items);
    }

    public void setScrollStateChangeListener(ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.scrollStateChangeListener = scrollStateChangeListener;
    }

    public void setScrollListener(ScrollListener<?> scrollListener) {
        setScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void setOnItemChangedListener(OnItemChangedListener<?> onItemChangedListener) {
        this.onItemChangedListener = onItemChangedListener;
    }

    private class ScrollStateListener implements DiscreteScrollLayoutManager.ScrollStateListener {

        @Override
        public void onIsBoundReachedFlagChange(boolean isBoundReached) {
            setOverScrollMode(isBoundReached ? OVER_SCROLL_ALWAYS : OVER_SCROLL_NEVER);
        }

        @Override
        public void onScrollStart() {
            if (scrollStateChangeListener != null) {
                int current = layoutManager.getCurrentPosition();
                ViewHolder holder = getViewHolder(current);
                if (holder != null) {
                    scrollStateChangeListener.onScrollStart(holder, current);
                }
            }
        }

        @Override
        public void onScrollEnd() {
            ViewHolder holder = null;
            int current = layoutManager.getCurrentPosition();
            if (scrollStateChangeListener != null) {
                holder = getViewHolder(current);
                if (holder == null) {
                    return;
                }
                scrollStateChangeListener.onScrollEnd(holder, current);
            }
            if (onItemChangedListener != null) {
                if (holder == null) {
                    holder = getViewHolder(current);
                }
                if (holder != null) {
                    onItemChangedListener.onCurrentItemChanged(holder, current);
                }
            }
        }

        @Override
        public void onScroll(float currentViewPosition) {
            if (scrollStateChangeListener != null) {
                int current = getCurrentItem();
                ViewHolder currentHolder = getViewHolder(getCurrentItem());

                int newCurrent = current + (currentViewPosition < 0 ? 1 : -1);
                ViewHolder newCurrentHolder = getViewHolder(newCurrent);

                if (currentHolder != null && newCurrentHolder != null) {
                    scrollStateChangeListener.onScroll(
                            currentViewPosition, currentHolder,
                            newCurrentHolder);
                }
            }
        }

        @Override
        public void onCurrentViewFirstLayout() {
            if (onItemChangedListener != null) {
                int current = layoutManager.getCurrentPosition();
                ViewHolder currentHolder = getViewHolder(current);
                if (currentHolder != null) {
                    onItemChangedListener.onCurrentItemChanged(currentHolder, current);
                }
            }
        }
    }
    //处理滑动冲突
    float startX = 0;
    float startY = 0;
    float xDistance = 0;
    float yDistance = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                startX = ev.getX();
                startY = ev.getY();
                Log.d("++++++++++++", "ACTION_DOWN:" + startX);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        final float curX = ev.getX();
        final float curY = ev.getY();

        xDistance += Math.abs(curX - startX);
        yDistance += Math.abs(curY - startY);
//        startX = curX;
//        startY = curY;
        if (xDistance >= yDistance) {
            //横向滑动
            Log.d("++++++++++++", "startX:" + startX);
            Log.d("++++++++++++", "event.getX():" + ev.getX());
            if (this.getCurrentItem() == 0 && ev.getX() > startX) {
                //第一项&&右划
                this.getParent().requestDisallowInterceptTouchEvent(false);
            } else if (this.getCurrentItem() == (this.getAdapter().getItemCount() - 1)
                    && ev.getX() < startX) {
                //第二项左划
                this.getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else {
            //垂直滑动
            this.getParent().requestDisallowInterceptTouchEvent(false);
        }

        return super.dispatchTouchEvent(ev);
    }


    public interface ScrollStateChangeListener<T extends ViewHolder> {

        void onScrollStart(@NonNull T currentItemHolder, int adapterPosition);

        void onScrollEnd(@NonNull T currentItemHolder, int adapterPosition);

        void onScroll(float scrollPosition, @NonNull T currentHolder, @NonNull T newCurrent);
    }

    public interface ScrollListener<T extends ViewHolder> {

        void onScroll(float scrollPosition, @NonNull T currentHolder, @NonNull T newCurrent);
    }

    public interface OnItemChangedListener<T extends ViewHolder> {
        /*
         * This method will be also triggered when view appears on the screen for the first time.
         */
        void onCurrentItemChanged(@NonNull T viewHolder, int adapterPosition);

    }
}
