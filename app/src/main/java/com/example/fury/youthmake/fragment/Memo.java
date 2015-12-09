package com.example.fury.youthmake.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.activity.LoginActivity;

/**
 * Copyright (C) 年少才华
 * Date: 2015-12-08  07:26
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class Memo extends Fragment {
    private Context memoContext;

    public Memo(Context memoContext) {
        this.memoContext = memoContext;
    }

    public Context getMemoContext() {
        return memoContext;
    }

    public void setMemoContext(Context memoContext) {
        this.memoContext = memoContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View memoLayout = inflater.inflate(R.layout.fragment_message, container, false);
        BootstrapButton ToLogin = (BootstrapButton)memoLayout.findViewById(R.id.ToLogin);
        ToLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return memoLayout;
    }
}
