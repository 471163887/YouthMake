package com.example.fury.youthmake.activity;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fury.youthmake.JazzyViewPager.JazzyViewPager;
import com.example.fury.youthmake.JazzyViewPager.OutlineContainer;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.JazzyViewPager.JazzyViewPager.TransitionEffect;
/**
 * Copyright (C) 年少才华
 * Date: 2015-10-04  18:32
 * Mail: 18844195756@163.com
 * Auth: flt
 */

public class OneDayActivity extends AppCompatActivity {

    private JazzyViewPager mJazzy;
    //Integer[] mImg = { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_one_day);
        setupJazziness(TransitionEffect.Accordion);
    }
    private void setupJazziness(TransitionEffect effect) {
        mJazzy = (JazzyViewPager) findViewById(R.id.jazzy_pager);
        mJazzy.setTransitionEffect(effect);
        mJazzy.setAdapter(new MyAdapter());
        //设置两个页面之间的间距
        //mJazzy.setPageMargin(30);
    }
    private class MyAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            /*
            //也可以返回图片
            ImageView imageView = new ImageView(OneDayActivity.this);
            imageView.setBackgroundResource(mImg[position]);
            container.addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            mJazzy.setObjectForPosition(imageView, position);
            return imageView;
            */
            TextView text = new TextView(OneDayActivity.this);
            text.setGravity(Gravity.CENTER);
            text.setTextSize(30);
            text.setTextColor(Color.WHITE);
            text.setText("Page " + position);
            text.setPadding(30, 30, 30, 30);
            int bg = Color.rgb((int) Math.floor(Math.random()*128)+64,
                    (int) Math.floor(Math.random()*128)+64,
                    (int) Math.floor(Math.random()*128)+64);
            text.setBackgroundColor(bg);
            container.addView(text, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            mJazzy.setObjectForPosition(text, position);
            return text;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object obj) {
            container.removeView(mJazzy.findViewFromObject(position));
        }
        @Override
        public int getCount() {
            //return mImg.length;
            return 3;
        }
        @Override
        public boolean isViewFromObject(View view, Object obj) {
            if (view instanceof OutlineContainer) {
                return ((OutlineContainer) view).getChildAt(0) == obj;
            } else {
                return view == obj;
            }
        }
    }
}
