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
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loading.carmall.R;
import com.loading.carmall.ui.weiget.MultiChoiceRecyclerView.MultiChoiceAdapter;

import java.util.ArrayList;


public class CheckImageAdapter extends MultiChoiceAdapter<CheckImageAdapter.MySampleToolbarViewHolder> {

    private ArrayList<String> mList;
    private Context mContext;
    private int mLayoutRes;

    public CheckImageAdapter(ArrayList<String> stringList, Context context, @LayoutRes int layout) {
        mList = stringList;
        mContext = context;
        mLayoutRes = layout;
    }

    @Override
    public MySampleToolbarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySampleToolbarViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(mLayoutRes, parent, false));
    }


    @Override
    public void onBindViewHolder(MySampleToolbarViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.mTextView.setText(mList.get(position));
    }


    /**
     * Override this method to implement a custom active/deactive state
     */
    @Override
    public void setActive(View view, boolean state) {

        FrameLayout relativeLayout = (FrameLayout) view.findViewById(R.id.container);

        if (relativeLayout != null) {
            if (state) {
                    relativeLayout.setForeground(mContext.getResources().getDrawable(R.drawable.shape_rectangle_orenge));
            } else {
                relativeLayout.setForeground(null);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MySampleToolbarViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        MySampleToolbarViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
