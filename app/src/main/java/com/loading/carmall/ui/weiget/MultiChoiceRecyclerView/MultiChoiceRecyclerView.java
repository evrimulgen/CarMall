
package com.loading.carmall.ui.weiget.MultiChoiceRecyclerView;


import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;

import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceAdapterListener;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners.MultiChoiceSelectionListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("all")
public class MultiChoiceRecyclerView extends RecyclerView
        implements MultiChoiceAdapterListener {

    private String EXCEPTION_MESSAGE_ADAPTER = "The adapter of this RecyclerView is not extending the MultiChoiceAdapter class";

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private HashMap<Integer, View> mSelectedList = new HashMap<>();
    private HashMap<Integer, View> mAllList = new HashMap<>();
    private MultiChoiceAdapter mMultiChoiceAdapter = null;
    private MultiChoiceSelectionListener multiChoiceSelectionListener = null;

    private boolean isToolbarMultiChoice = false;

    private boolean isInSingleClickMode = false;

    public MultiChoiceRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if (adapter instanceof MultiChoiceAdapter) {
            mMultiChoiceAdapter = ((MultiChoiceAdapter) adapter);
            mMultiChoiceAdapter.setMultiChoiceListener(this);

            for (int i = 0; i < mMultiChoiceAdapter.getItemCount(); i++) {
                mAllList.put(i, null);
            }
        } else
            try {
                throw new MultiChoiceAdapterNotFoundException(EXCEPTION_MESSAGE_ADAPTER);
            } catch (MultiChoiceAdapterNotFoundException e) {
                e.printStackTrace();
            }
    }


    @Override
    public void onSingleItemClickListener(View view, int position) {
        //Check if it's in a single mode of if there is at least one item in the selected list, before processing the click
        if (mSelectedList.size() >= 1 || isInSingleClickMode) {
            performVibrate();

            performSingleClick(view, position);
        }
    }

    @Override
    public void onSingleItemLongClickListener(View view, int position) {
        if (mSelectedList.size() == 0) {
            performVibrate();

            performSingleClick(view, position);
        }
    }


    @Override
    public void onUpdateItemListener(View view, int position) {
        if (mMultiChoiceAdapter != null) {
            if (mSelectedList.containsKey(position))
                performSelect(view, position, false);
            else
                performDeselect(view, position, false);
        }
        mAllList.put(position, view);
    }















    /*
    *
    * *********************************** MULTICHOICE METHODS **********************************
    * */

    /**
     * Deselect all the selected items in the adapter
     */
    public boolean deselectAll() {
        if (mMultiChoiceAdapter != null) {

            performVibrate();

            //select all the the view
            Iterator it = mAllList.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, View> pair = (Map.Entry<Integer, View>) it.next();

                performDeselect(pair.getValue(), pair.getKey(), false);
            }

            if (multiChoiceSelectionListener != null)
                multiChoiceSelectionListener.OnSelectAll(mSelectedList.size(), mAllList.size());

            return true;
        }
        return false;
    }


    /**
     * Select all the view in the adapter
     */
    public boolean selectAll() {
        if (mMultiChoiceAdapter != null) {

            performVibrate();

            //select all the the view
            Iterator it = mAllList.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, View> pair = (Map.Entry<Integer, View>) it.next();

                performSelect(pair.getValue(), pair.getKey(), false);
            }

            if (multiChoiceSelectionListener != null)
                multiChoiceSelectionListener.OnSelectAll(mSelectedList.size(), mAllList.size());

            return true;
        }
        return false;
    }


    /**
     * Select a view from position in the adapter
     *
     * @param position the position of the view in the adapter
     */
    public boolean select(int position) {
        View v = mAllList.get(position);
        if (mMultiChoiceAdapter != null) {

            performVibrate();

            performSelect(v, position, true);

            return true;
        }
        return false;
    }


    /*********************************** SETTERS ********************************** */
    /**
     * Set the number of column with a VERTICAL layout.
     * <p/>
     * If you call this method, it will override the setRowNumber()
     *
     * @param columnNumber number of column
     */
    public void setRecyclerColumnNumber(int columnNumber) {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(columnNumber, StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        setLayoutManager(mStaggeredGridLayoutManager);
    }


    /**
     * Set the number of row with a HORIZONTAL layout
     * <p/>
     * If you call this method, it will override the setColumnNumber()
     *
     * @param rowNumber number of row
     */
    public void setRecyclerRowNumber(int rowNumber) {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(rowNumber, StaggeredGridLayoutManager.HORIZONTAL);
        setLayoutManager(mStaggeredGridLayoutManager);
    }


    /**
     * Set the selection of the RecyclerView to always single click (instead of first long click and then single click)
     *
     * @param set
     */
    public void setSingleClickMode(boolean set) {
        this.isInSingleClickMode = set;
    }


    /************************************* PRIVATE METHODS **********************************
     */


    private void performSingleClick(View view, int position) {

        if (mMultiChoiceAdapter != null) {
            if (mSelectedList.containsKey(position)) {

                performDeselect(view, position, true);
            } else {

                performSelect(view, position, true);
            }
        }

    }

    /**
     * Remeber to call this method before selecting or deselection something otherwise it wont vibrate
     */
    private void performVibrate() {
        if (mSelectedList.size() == 0) {
            Vibrator v = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
    }

    private void performSelect(View v, int position, boolean withCallback) {
        mMultiChoiceAdapter.performActivation(v, true);
        mSelectedList.put(position, v);


        if (multiChoiceSelectionListener != null && withCallback)
            multiChoiceSelectionListener.OnItemSelected(position, mSelectedList.size(), mAllList.size());
    }

    private void performDeselect(View v, int position, boolean withCallback) {
        mMultiChoiceAdapter.performActivation(v, false);
        mSelectedList.remove(position);


        if (multiChoiceSelectionListener != null && withCallback)
            multiChoiceSelectionListener.OnItemDeselected(position, mSelectedList.size(), mAllList.size());
    }


    /*********************************** GETTERS ********************************** */
    /**
     * Method to get the number of item in the adapter
     *
     * @return number of all item in the adapter
     */
    public int getAllItemCount() {
        return mMultiChoiceAdapter.getItemCount();
    }


    /**
     * Method to get the number of selected items
     *
     * @return number of selected items
     */
    public int getSelectedItemCount() {
        return mSelectedList.size();
    }


    /**
     * Get the list of selected item
     *
     * @return Collection of all the selected position in the adapter
     */
    public Collection<Integer> getSelectedItemList() {
        return mSelectedList.keySet();
    }

    public void setMultiChoiceSelectionListener(MultiChoiceSelectionListener multiChoiceSelectionListener) {
        this.multiChoiceSelectionListener = multiChoiceSelectionListener;
    }

    public boolean isInSingleClickMode() {
        return isInSingleClickMode;
    }

    /*********************************** MULTI CHOICE TOOLBAR ********************************** */

    /**
     * Enable the multi choice custom app compact toolbar.
     * <p>
     * NB: Enable this feature only if providing a custom toolbar via setSupportActionBar in your application.
     *
     * @param appCompatActivity Activity that extends AppCompatActivity
     * @param toolbar           Custom toolbar implementd via setSupportActionBar method
     */
    public void setMultiChoiceToolbar(Activity activity ) {
        isToolbarMultiChoice = true;
    }


}
