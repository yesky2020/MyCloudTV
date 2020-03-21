package com.example.mycloudtv;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycloudtv.dialog.WebDialog;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.tvExit)
    TextView tvExit;
    @BindView(R.id.topLayout)
    LinearLayout topLayout;
    @BindView(R.id.tvPai)
    TextView tvPai;
    @BindView(R.id.tvChe)
    TextView tvChe;
    @BindView(R.id.tvRenJi)
    TextView tvRenJi;
    @BindView(R.id.leftLayout)
    LinearLayout leftLayout;
    @BindView(R.id.fragmentLayout)
    FrameLayout fragmentLayout;


    private Fragment currentFragment = new Fragment();

    WebDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fragmentLayout, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);


        }
        currentFragment = targetFragment;
        return transaction;
    }

    @OnClick({R.id.tvPai, R.id.tvChe, R.id.tvRenJi, R.id.tvExit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPai:
                switchFragment(new FirstFragment()).commit();
                showWebDialog();
                break;
            case R.id.tvChe:
                switchFragment(new WorkShopFragment()).commit();
                break;
            case R.id.tvRenJi:
                switchFragment(new ThirdFragment()).commit();
                break;
            case R.id.tvExit:
                switchFragment(new ExitFragment()).commit();
                break;
        }
    }

    private void showWebDialog() {
        dialog =new WebDialog(MainActivity.this);
        dialog.show();
        //获取dialog布局
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        //获取屏幕的宽高
        Point point = new Point();
        Display display = this.getWindowManager().getDefaultDisplay();
        display.getSize(point);
        //给dialog设置宽高
        params.width = (int) (point.x * 0.7);
        params.height = (int) (point.y * 0.7);
        //使设置生效
        dialog.getWindow().setAttributes(params);
    }
}
