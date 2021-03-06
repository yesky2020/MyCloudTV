package com.example.mycloudtv.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.mycloudtv.MyApplication;
import com.example.mycloudtv.R;
import com.example.mycloudtv.acache.ACache;
import com.example.mycloudtv.bean.LoginInfo;
import com.example.mycloudtv.bean.UserBean;
import com.example.mycloudtv.util.Constant;
import com.example.mycloudtv.util.NetWorkUtils;
import com.example.mycloudtv.util.ThreadManager;
import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

@SuppressLint("WrongConstant")
public class LoginActivity extends FragmentActivity {
    private TextView tvLogin;
    private EditText etPsw;
    private EditText etName;
    private boolean isNetFinsh = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initView() {
        tvLogin = findViewById(R.id.jiayun_login);
        etName = findViewById(R.id.jiayun_name_et);
        etPsw = findViewById(R.id.jiayun_psw_et);
        LoginInfo loginInfo = (LoginInfo) ACache.get(LoginActivity.this).getAsObject(Constant.CACHE_NAME_PSD);
        if (null != loginInfo) {
            etName.setText(loginInfo.userName);
            etPsw.setText(loginInfo.password);
            jiayunLogin();
        }
    }

    public void initListener() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!NetWorkUtils.isNetworkConnected(LoginActivity.this)) {
                    Toast.makeText(LoginActivity.this, R.string.str_network_excption, 500).show();
                    return;
                }
                if (!isNetFinsh) {
                    return;
                }
                jiayunLogin();
            }
        });
    }

    private void jiayunLogin() {
        String name = etName.getText().toString().trim();
        String psw = etPsw.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "用户名不能为空", 500).show();
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "密码不能为空", 500).show();
            return;
        }
        isNetFinsh = false;
        postNetLogin(name, psw);
    }

    private void postNetLogin(String name, String psw) {
        String url = "/plat/andtv/checkLogin?mobile_no=" + name + "&passwd=" + psw;
        EasyHttp.get(url).baseUrl("https://m.danfoo.com")
                .readTimeOut(10 * 1000)//局部定义读超时
                .writeTimeOut(10 * 1000)
                .connectTimeout(10 * 1000)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        isNetFinsh = true;
                        if (LoginActivity.this.isDestroyed()) {
                            return;
                        }
                        Toast.makeText(LoginActivity.this, R.string.str_network_excption, 500).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        try {
                            isNetFinsh = true;
                            Gson gson = new Gson();
                            UserBean userBean = gson.fromJson(s, UserBean.class);
                            if (null != userBean && "ok".equals(userBean.code.toLowerCase())) {
                                MyApplication.getInstance().setUserName(name);
                                MyApplication.getInstance().setUserInfo(userBean);
                                LoginInfo loginInfo = new LoginInfo();
                                loginInfo.password = psw;
                                loginInfo.userName = name;
                                ACache.get(LoginActivity.this).put(Constant.CACHE_NAME_PSD, loginInfo);
                                LoginActivity.this.finish();
                                Intent intent = new Intent(LoginActivity.this, com.example.mycloudtv.MainActivity.class);
                                startActivity(intent);
                                ThreadManager.getThreadPool().execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        ACache.get(MyApplication.getInstance().getApplicationContext()).put(name, userBean);
                                    }
                                });
                            } else {
                                Toast.makeText(LoginActivity.this, R.string.str_network_excption, 500).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(LoginActivity.this, R.string.str_network_excption, 500).show();
                        }
                    }
                });
    }
}
