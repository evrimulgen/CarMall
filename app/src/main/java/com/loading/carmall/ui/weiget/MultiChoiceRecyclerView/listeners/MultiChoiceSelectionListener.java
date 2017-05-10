package com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.listeners;


public interface MultiChoiceSelectionListener{

    void OnItemSelected(int selectedPosition, int itemSelectedCount, int allItemCount);

    void OnItemDeselected(int deselectedPosition, int itemSelectedCount, int allItemCount);

    void OnSelectAll(int itemSelectedCount, int allItemCount);

    void OnDeselectAll(int itemSelectedCount, int allItemCount);
}