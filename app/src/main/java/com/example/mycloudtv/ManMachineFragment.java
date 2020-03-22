package com.example.mycloudtv;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycloudtv.machine.RankFragment;
import com.example.mycloudtv.machine.SpectacularsFragment;
import com.example.mycloudtv.machine.adapter.FragmentTabAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ManMachineFragment extends Fragment {

    @BindView(R.id.tv_man_machine)
    TextView tvManMachine;
    @BindView(R.id.btn_morning_shift)
    Button btnMorningShift;
    @BindView(R.id.btn_night_shift)
    Button btnNightShift;
    @BindView(R.id.btn_spectaculars)
    Button btnSpectaculars;
    @BindView(R.id.btn_rank)
    Button btnRank;
    @BindView(R.id.label_man_machine)
    LinearLayout labelManMachine;
    @BindView(R.id.view_man_machine_page)
    ViewPager viewManMachinePage;

    private Fragment rankFragment;
    private Fragment spectacularsFragment;
    private ArrayList<Fragment> viewContainer;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViewPager();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    private void initViewPager() {
        if (viewContainer == null){
            viewContainer = new ArrayList<>();
        }else {
            viewContainer.clear();
        }

        if (rankFragment == null){
            rankFragment = new RankFragment();
        }

        if (spectacularsFragment == null){
            spectacularsFragment = new SpectacularsFragment();
        }

        viewContainer.add(rankFragment);
        viewContainer.add(spectacularsFragment);

        viewManMachinePage.setAdapter(new FragmentTabAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                viewContainer));
        viewManMachinePage.setCurrentItem(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解绑
        unbinder.unbind();
    }

    @OnClick({R.id.btn_morning_shift, R.id.btn_night_shift, R.id.btn_spectaculars, R.id.btn_rank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_morning_shift:
                break;
            case R.id.btn_night_shift:
                selectView(view.getId());
                break;
            case R.id.btn_spectaculars:
                viewManMachinePage.setCurrentItem(1);
                selectView(view.getId());
                break;
            case R.id.btn_rank:
                viewManMachinePage.setCurrentItem(0);
                selectView(view.getId());
                break;
        }
    }


    private void selectView(int viewId) {
        switch (viewId) {
            case R.id.btn_spectaculars:
                tvManMachine.setText("人机达成排行榜");
                btnRank.setVisibility(View.VISIBLE);
                btnSpectaculars.setVisibility(View.GONE);
                break;
            case R.id.btn_rank:
                tvManMachine.setText("人机达成看板");
                btnRank.setVisibility(View.GONE);
                btnSpectaculars.setVisibility(View.VISIBLE);
                break;
        }
    }
}
