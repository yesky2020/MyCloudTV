package com.example.mycloudtv;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.mycloudtv.dialog.WebDialog;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.topLayout)
    LinearLayout topLayout;
    @BindView(R.id.leftLayout)
    LinearLayout leftLayout;
    @BindView(R.id.fragmentLayout)
    FrameLayout fragmentLayout;
    @BindView(R.id.viewPai)
    View viewPai;
    @BindView(R.id.llPai)
    LinearLayout llPai;
    @BindView(R.id.viewChe)
    View viewChe;
    @BindView(R.id.llChe)
    LinearLayout llChe;
    @BindView(R.id.viewRenJi)
    View viewRenJi;
    @BindView(R.id.llRenJi)
    LinearLayout llRenJi;
    @BindView(R.id.viewExit)
    View viewExit;
    @BindView(R.id.llExit)
    LinearLayout llExit;


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

    @OnClick({R.id.llPai, R.id.llChe, R.id.llRenJi, R.id.llExit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llPai:
                switchFragment(new FirstFragment()).commit();
                selectView(view.getId());
                showWebDialog();
                break;
            case R.id.llChe:
                switchFragment(new WorkShopFragment()).commit();
                selectView(view.getId());
                break;
            case R.id.llRenJi:
                switchFragment(new ThirdFragment()).commit();
                selectView(view.getId());
                break;
            case R.id.llExit:
                switchFragment(new ExitFragment()).commit();
                selectView(view.getId());
                break;
        }
    }


    private void showWebDialog() {
        dialog = new WebDialog(MainActivity.this);
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

    /**
     * 选中样式
     *
     * @param viewId 选中view的ID
     */
    private void selectView(int viewId) {
        viewPai.setVisibility(View.INVISIBLE);
        viewChe.setVisibility(View.INVISIBLE);
        viewRenJi.setVisibility(View.INVISIBLE);
        viewExit.setVisibility(View.INVISIBLE);
        switch (viewId) {
            case R.id.llPai:
                viewPai.setVisibility(View.VISIBLE);
                break;
            case R.id.llChe:
                viewChe.setVisibility(View.VISIBLE);
                break;
            case R.id.llRenJi:
                viewRenJi.setVisibility(View.VISIBLE);
                break;
            case R.id.llExit:
                viewExit.setVisibility(View.VISIBLE);
                break;
        }
    }

}
