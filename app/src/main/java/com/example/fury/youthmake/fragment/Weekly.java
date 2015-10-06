package com.example.fury.youthmake.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.activity.OneDayActivity;
import com.example.fury.youthmake.activity.WeekSetActivity;

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

        BootstrapButton toWeekly = (BootstrapButton)weeklyView.findViewById(R.id.ToWeekly);
        BootstrapButton toWeeklySet = (BootstrapButton)weeklyView.findViewById(R.id.ToWeeklySet);

        toWeekly.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OneDayActivity.class);
                startActivity(intent);
            }
        });
        toWeeklySet.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeekSetActivity.class);
                startActivity(intent);
            }
        });
        return weeklyView;
    }
}
