package com.example.mycloudtv;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private Fragment currentFragment = new Fragment();

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

    @OnClick({R.id.tvPai, R.id.tvChe, R.id.tvRenJi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPai:
                switchFragment(new FirstFragment()).commit();
                break;
            case R.id.tvChe:
                switchFragment(new SecondFragment()).commit();
                break;
            case R.id.tvRenJi:
                switchFragment(new ThirdFragment()).commit();
                break;
        }
    }
}
