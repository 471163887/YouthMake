package com.example.fury.youthmake.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fury.youthmake.R;
/**
 *
 * @{#} SplashActivity.java Create on 2015-5-30 ����10:10:01
 *
 * class desc:   ��������
 *
 * @Version 1.0
 * @Author fury
 */

public class SplashActivity extends Activity {

    //�ӳ�5��
    private static final long SPLASH_DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ʹ��Handler��postDelayed������3���ִ����ת��MainActivity
        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }
        }, SPLASH_DELAY_MILLIS);
    }

    private void goHome() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }
}