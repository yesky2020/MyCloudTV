package com.example.mycloudtv.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.mycloudtv.R;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends FragmentActivity {
    @BindView(R.id.jiayun_login)
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvLogin = findViewById(R.id.jiayun_login);

                //EasyHttp.post("/v1/app/chairdressing/skinAnalyzePower/skinTestResult")
//                EasyHttp.get("/v1/app/chairdressing/skinAnalyzePower/skinTestResult")
//                        .readTimeOut(30 * 1000)//局部定义读超时
//                        .writeTimeOut(30 * 1000)
//                        .connectTimeout(30 * 1000)
//                        .params("name","张三")
//                        .timeStamp(true)
//                        .execute(new SimpleCallBack<String>() {
//                            @Override
//                            public void onError(ApiException e) {
////                                showToast(e.getMessage());
//                            }
//
//                            @Override
//                            public void onSuccess(String s) {
//
//                            }
//
//                        });

    }

    @OnClick(R.id.jiayun_login)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.jiayun_login:
                Intent intent = new Intent(LoginActivity.this, com.example.mycloudtv.MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
