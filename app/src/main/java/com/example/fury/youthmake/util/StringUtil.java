package com.example.fury.youthmake.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.fury.youthmake.R;

/**
 * Created by flt on 2015/6/1.
 */
public class StringUtil {

    public static final String USER_DATA_PROVIDE = "com.example.fury.provide.USERS";

    public static final String IS_USER_NAME = "is_save_uname";

    /**
     * 保存密码
     */
    public static final String IS_PASSWORD = "is_save_pwd";

    /**
     * 保存用户名
     */
    public static final String USERNAME = "username";

    /**
     * 保存密码
     */
    public static final String PASSWORD = "password";
    /**
     * Handler
     */
    public static final int LOGIN_ERROR = 0; // 登陆错误
    public static final int LOGIN_SUCCESS = 1; // 登陆成功
    public static final int LOGIN_ERROR_PASSWORD = 2; //登陆密码错误
    public static final int NET_CON = 3; //网络未连接

    /**
     * 等待Dialog
     */
    public static ProgressDialog createProgressDialog(Context context, String title,
                                                      String message, boolean canCelable, boolean indeterminate) {
        ProgressDialog p = new ProgressDialog(context);
        p.setIcon(R.drawable.progress);
        p.setTitle(title);
        p.setMessage(message);
        p.setCancelable(canCelable);
        p.setIndeterminate(indeterminate);
        return p;
    }


}
