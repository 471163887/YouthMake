package com.example.fury.youthmake.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fury.youthmake.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Setting extends Fragment {


    public Setting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View settingView = inflater.inflate(R.layout.fragment_setting, container, false);
        return settingView;
    }


}
