package com.example.fury.youthmake.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fury.youthmake.R;

/**
 * Copyright (C) 才华制噪
 * Date: 2015-10-03  17:03
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class Weekly extends Fragment {

    public Weekly() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View weeklyView = inflater.inflate(R.layout.fragment_weekly, container, false);
        return weeklyView;
    }


}
