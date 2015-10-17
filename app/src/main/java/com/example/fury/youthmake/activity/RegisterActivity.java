package com.example.fury.youthmake.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.fury.youthmake.R;
import com.example.fury.youthmake.util.HttpUtil;
import com.example.fury.youthmake.util.StringUtil;
import com.example.fury.youthmake.util.UrlUtil;
/**
 * Copyright (C) 年少才华
 * Date: 2015-6-02  20:32
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class RegisterActivity extends ActionBarActivity {

    private EditText username;
    private EditText password;
    private EditText re_password;

    private RadioGroup m_gender;
    private RadioButton m_boy;
    private RadioButton m_gril;
    private String gender = "";

    private ProgressDialog proDlg;
    private String res;

    private BootstrapButton m_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.text_reg_username);
        password = (EditText)findViewById(R.id.text_reg_password);
        re_password = (EditText)findViewById(R.id.text_re_password);

        m_gender = (RadioGroup)findViewById(R.id.gender_radio);
        m_boy = (RadioButton)findViewById(R.id.radio_boy);
        m_gril = (RadioButton)findViewById(R.id.radio_gril);

        m_gender.setOnCheckedChangeListener(genderListener);

        m_register = (BootstrapButton)findViewById(R.id.imb_reg_register);
        m_register.setOnClickListener(registenerListener);

    }
    RadioGroup.OnCheckedChangeListener genderListener=new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(m_boy.getId() == checkedId)
                gender = "M";
            else if(m_gril.getId() == checkedId)
                gender = "F";
            else
                gender = "";
        }
    };
    /**
     * 按下注册点击事件
     */
    View.OnClickListener registenerListener=new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            final String name=username.getText().toString().trim();
            final String upwd = password.getText().toString().trim();
            final String upwd2= re_password.getText().toString().trim();
            //用户名为空
            if ("".equals(name.trim())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setIcon(R.drawable.simle)
                        .setTitle(getString(R.string.warning))
                        .setMessage(R.string.login_account_null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            //点击确定按钮
                            public void onClick(DialogInterface dialog, int which) {
                                username.setText("");
                                password.setText("");
                            }
                        }).show();
                return ;
            }
            if("".equals(upwd)){
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setIcon(R.drawable.simle)
                        .setTitle(getString(R.string.warning))
                        .setMessage(R.string.login_password_null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            //点击确定按钮
                            public void onClick(DialogInterface dialog, int which) {
                                password.setText("");
                            }
                        }).show();
                return ;
            }
            if("".equals(upwd2)){
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setIcon(R.drawable.simle)
                        .setTitle(getString(R.string.warning))
                        .setMessage("请再次输入密码")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            //点击确定按钮
                            public void onClick(DialogInterface dialog, int which) {
                                password.setText("");
                                re_password.setText("");
                            }
                        }).show();
                return ;
            }
            if(!(upwd.equals(upwd2))){
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setIcon(R.drawable.simle)
                        .setTitle(getString(R.string.warning))
                        .setMessage("两次密码输入不相同哦!")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            //点击确定按钮
                            public void onClick(DialogInterface dialog, int which) {
                                password.setText("");
                                re_password.setText("");
                            }
                        }).show();
                return ;
            }

            if("".equals(gender)){
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setIcon(R.drawable.simle)
                        .setTitle(getString(R.string.warning))
                        .setMessage("请选择性别！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
                return ;
            }

            proDlg = StringUtil.createProgressDialog(RegisterActivity.this, "请稍候....",
                    "正在注册中.....", true, true);
            proDlg.show();
            new Thread(){

                @Override
                public void run() {
                    //验证用户是否存在,不存在，注册,如果成功了，返回用户密码显示，最后登录即可 + "&email=" + umail
                    String registerString = "loginId=" + name + "&password=" + upwd  + "&gender=" + gender;
                    String url = HttpUtil.BASE_URL + UrlUtil.REGISTER_URL + registerString;
                    //String url = HttpUtil.BASE_URL + "?" + registerString;
                    res = HttpUtil.getHttpPostResultForUrl(url);
                    Log.d("fury", res);
                    handler.sendEmptyMessage(1);
                }

            }.start();
        }
    };
    private Handler handler = new Handler(){
        public void dispatchMessage(Message msg) {
            proDlg.dismiss();
            showRegisterMsg(res);
        };
    };
    //这个方法目的在于提示注册信息的情况，包括注册失败/成功等
    protected void showRegisterMsg(String res){
        if ("0".equals(res)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setIcon(R.drawable.simle)
                    .setTitle(getString(R.string.warning))
                    .setMessage("注册失败，请稍后再试！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
            return ;
        }
        if ("1".equals(res)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setIcon(R.drawable.simle)
                    .setTitle("注册成功")
                    .setMessage("亲！恭喜您！注册成功！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        //点击确定按钮
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }).show();
            return ;
        }

        if("3".equals(res)){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setIcon(R.drawable.simle)
                    .setTitle("登陆账号已存在")
                    .setMessage("登陆账号已存在，请使用其它账号")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        //点击确定按钮
                        public void onClick(DialogInterface dialog, int which) {
                            username.setText("");
                        }
                    }).show();
            return ;
        }
    }


}
