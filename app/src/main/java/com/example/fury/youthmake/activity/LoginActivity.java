package com.example.fury.youthmake.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.BassBoost;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.util.HttpUtil;
import com.example.fury.youthmake.util.StringUtil;
import com.example.fury.youthmake.util.UrlUtil;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    private BootstrapEditText m_username;
    private BootstrapEditText m_password;
    private String user_name;
    private String user_pwd;

    private ProgressDialog prgDialog;
    private String res;

    private CheckBox rem_pwd, auto_login;

    private BootstrapButton register;
    private BootstrapButton login;

    private SharedPreferences share;
    private SharedPreferences.Editor editor;



    //private RadioGroup remember;
    //private RadioButton rem_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (BootstrapButton)findViewById(R.id.register);
        register.setOnClickListener(LoginActivity.this);
        login = (BootstrapButton)findViewById(R.id.login);
        login.setOnClickListener(LoginActivity.this);

        m_username = (BootstrapEditText) findViewById(R.id.text_username);
        m_password = (BootstrapEditText) findViewById(R.id.text_password);

        //remember = (RadioGroup)findViewById(R.id.gender_radio);
        //rem_pass = (RadioButton)findViewById(R.id.remember_pass);
        //remember.setOnCheckedChangeListener(genderListener);

        //LoadUserNamePassword();

        share = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        rem_pwd = (CheckBox) findViewById(R.id.cb_mima);
        auto_login = (CheckBox) findViewById(R.id.cb_auto);
        //监听记住密码多选框按钮事件
        rem_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rem_pwd.isChecked()) {
                    System.out.println("记住密码已选中");
                    share.edit().putBoolean("ISCHECK", true).commit();
                } else {
                    System.out.println("记住密码没有选中");
                    share.edit().putBoolean("ISCHECK", false).commit();
                }
            }
        });
        //判断记住密码多选框的状态
        boolean isRemember = share.getBoolean("ISCHECK", false);
        if(isRemember)
        {

            String u_name = share.getString("USERNAME", "");
            String u_pwd = share.getString("PASSWORD", "");
            m_username.setText(u_name);
            m_password.setText(u_pwd);
            //设置默认是记录密码状态
            rem_pwd.setChecked(true);
            //判断自动登陆多选框状态
            if(share.getBoolean("AUTO_ISCHECK", false))
            {
                //设置默认是自动登录状态
                auto_login.setChecked(true);
                //跳转界面
                Toast.makeText(getApplicationContext(), "自动登陆成功！", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        }

        //监听自动登录多选框事件
        auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (auto_login.isChecked()) {
                    System.out.println("自动登录已选中");
                    share.edit().putBoolean("AUTO_ISCHECK", true).commit();

                } else {
                    System.out.println("自动登录没有选中");
                    share.edit().putBoolean("AUTO_ISCHECK", false).commit();
                }
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        /*
        SharedPreferences share = getSharedPreferences(StringUtil.USER_DATA_PROVIDE, PreferenceActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();

        boolean name = share.getBoolean(StringUtil.IS_USER_NAME, false);
        boolean pwd = share.getBoolean(StringUtil.IS_PASSWORD, false);
        if(name)
            editor.putString(StringUtil.USERNAME, m_username.getText().toString());
        else
            editor.remove(StringUtil.USERNAME);
        if(pwd)
            editor.putString(StringUtil.PASSWORD, m_password.getText().toString());
        else
            editor.remove(StringUtil.PASSWORD);
        editor.commit();*/
    }
     /*
    private void LoadUserNamePassword() {

        share = getSharedPreferences(
                StringUtil.USER_DATA_PROVIDE,
                PreferenceActivity.MODE_PRIVATE);
    }*/


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.login:
                user_name = m_username.getText().toString().trim();
                user_pwd = m_password.getText().toString().trim();
                if("".equals(user_name)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setIcon(R.drawable.simle)
                            .setTitle(getString(R.string.warning))
                            .setMessage(R.string.login_account_null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                // 点击确定按钮
                                public void onClick(DialogInterface dialog, int which) {}
                            }).show();
                    return ;
                }
                if("".equals(user_pwd)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setIcon(R.drawable.simle)
                            .setTitle(getString(R.string.warning))
                            .setMessage(R.string.login_password_null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                // 点击确定按钮
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                    return ;
                }
                // 显示登陆对话框
                prgDialog = new ProgressDialog(LoginActivity.this);
                prgDialog.setIcon(R.drawable.progress);
                prgDialog.setTitle("请稍等");
                prgDialog.setMessage("正在登陆，请稍等...");
                prgDialog.setCancelable(false);
                prgDialog.setIndeterminate(true);
                prgDialog.show();
                login();
                break;
            default:
                break;
        }
    }

    /***登录方法***/
    protected void login() {
        new Thread(){
            @Override
            public void run() {
                String loginString = "loginid=" + user_name + "&password=" + user_pwd;
                String url = HttpUtil.BASE_URL + UrlUtil.LOGIN_URL + loginString;
                System.out.println(url);
                res = HttpUtil.getHttpPostResultForUrl(url);
                Message m = new Message();
                System.out.println("+++++++++++++++");
                System.out.println("---------------");
                if("-1".equals(res)) {
                    m.what = StringUtil.LOGIN_ERROR;
                } else if("-2".equals(res)){
                    m.what = StringUtil.LOGIN_ERROR_PASSWORD;
                } else
                    m.what = StringUtil.LOGIN_SUCCESS;


                handler.sendMessage(m);
            }

        }.start();
    }
    /***开一个线程开始登录，并用对话框提示是否登录成功***/
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

            prgDialog.dismiss();
            switch(msg.what){
                case StringUtil.LOGIN_ERROR:
                    builder.setIcon(R.drawable.simle)
                            .setTitle(getString(R.string.warning))
                            .setMessage("此用户名还未注册！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                    break;
                case StringUtil.LOGIN_ERROR_PASSWORD:
                    builder.setIcon(R.drawable.simle)
                            .setTitle(getString(R.string.warning))
                            .setMessage("密码填错了哦！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                    break;
                case StringUtil.LOGIN_SUCCESS:
                    builder.setIcon(R.drawable.simle)
                            .setTitle("  登陆成功")
                            .setMessage("恭喜您，登陆成功")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                // 点击确定按钮
                                public void onClick(DialogInterface dialog, int which) {
                                    editor = share.edit();
                                    //登录成功和记住密码框为选中状态才保存用户信息
                                    if (rem_pwd.isChecked()) {
                                        //记住用户名、密码、

                                        editor.putBoolean("ISCHECK", true);
                                        editor.putString("USERNAME", user_name);
                                        editor.putString("PASSWORD", user_pwd);

                                    } else {
                                        editor.clear();
                                    }
                                    editor.commit();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    /*
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data", res);
                                    intent.putExtra("data", bundle);*/
                                    startActivity(intent);
                                }
                            }).show();
                    break;
            }
        }
    };



}
