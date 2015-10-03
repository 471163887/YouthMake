package com.example.fury.youthmake.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.activity.LoginActivity;


public class Message extends Fragment {
    private Context mycontext;
    public Message() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View messageLayout = inflater.inflate(R.layout.fragment_message, container, false);

        BootstrapButton ToLogin = (BootstrapButton)messageLayout.findViewById(R.id.ToLogin);

        ToLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return messageLayout;
    }


}
