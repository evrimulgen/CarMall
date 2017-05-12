/*
 * Copyright (c) 2014 Davide Cirillo
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     Come on, don't tell me you read that.
 */

package com.loading.carmall.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceAdapter;


public class CheckTextAdapter extends MultiChoiceAdapter<CheckTextAdapter.MySampleToolbarViewHolder> {

    String[] mDatas;
    Context mContext;
    int mLayoutRes;

    public CheckTextAdapter(String[] stringList, Context context, @LayoutRes int layout) {
        this.mDatas = stringList;
        this.mContext = context;
        mLayoutRes=layout;
    }

    @Override
    public MySampleToolbarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySampleToolbarViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(mLayoutRes, parent, false));
    }


    @Override
    public void onBindViewHolder(MySampleToolbarViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.mTextView.setText(mDatas[position]);
    }


    /**
     * Override this method to implement a custom active/deactive state
     */
    @Override
    public void setActive(View view, boolean state) {

        FrameLayout layout = (FrameLayout) view.findViewById(R.id.container);

        if (layout != null) {
            TextView textView = (TextView) view.findViewById(R.id.text_view);
            if (state) {
                textView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextOrange));
            } else {
                textView.setTextColor(ContextCompat.getColor(mContext,R.color.colorTextSecondary));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.length;
    }

    public class MySampleToolbarViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MySampleToolbarViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
