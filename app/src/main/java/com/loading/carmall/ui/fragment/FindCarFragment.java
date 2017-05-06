package com.loading.carmall.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loading.carmall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindCarFragment extends Fragment {


    public FindCarFragment() {
        // Required empty public constructor
    }

    public static FindCarFragment newInstance() {

        Bundle args = new Bundle();

        FindCarFragment fragment = new FindCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_car, container, false);
    }

}
