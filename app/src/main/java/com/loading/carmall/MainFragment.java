package com.loading.carmall;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MainFragment", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("MainFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainFragment", "onCreate");
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("MainFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("MainFragment", "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("MainFragment", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("MainFragment", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("MainFragment", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("MainFragment", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("MainFragment", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.d("MainFragment", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    public MainFragment() {
    }

}
