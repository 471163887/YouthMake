package com.example.fury.youthmake.activity;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import java.lang.Override;

/**
 * Copyright (C) 年少才华
 * Date: 2015-10-17  14:00
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class SampleApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        // setup default typefaces
        TypefaceProvider.registerDefaultIconSets();
    }
}
