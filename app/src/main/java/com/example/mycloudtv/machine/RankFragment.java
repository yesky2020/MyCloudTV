package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mycloudtv.ManMachineFragment;
import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.RankBean;
import com.example.mycloudtv.machine.adapter.RankAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class RankFragment extends Fragment {

    private List<RankBean> mData = new ArrayList<>();
    private RankAdapter rankAdapter;
    private RecyclerView listRank;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        listRank = view.findViewById(R.id.list_rank);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ManMachineFragment) RankFragment.this.getParentFragment()).setSelectView(0);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            RankBean rankBean = new RankBean();
            rankBean.setRank(i);
            rankBean.setName("张三" + i);
            rankBean.setDoneTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setFailTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPassTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPoints(new SecureRandom().nextInt(30) + "");
            mData.add(rankBean);
        }

        if (rankAdapter == null){
            rankAdapter = new RankAdapter(getActivity(), mData);
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        listRank.setLayoutManager(manager);
        listRank.setAdapter(rankAdapter);
    }

    private void initListener() {
        ((ManMachineFragment) RankFragment.this.getParentFragment()).setListener(new ManMachineFragment.ClickListener() {
            @Override
            public void morningShiftListener() {
                if (!isVisible()){
                    return;
                }
                requestDayData();
            }

            @Override
            public void nightShiftListener() {
                if (!isVisible()){
                    return;
                }
                requestNightData();
            }
        });
    }

    private void requestDayData(){
        if (mData != null && !mData.isEmpty()){
            mData.clear();
        }
        for (int i = 0; i < 10; i++) {
            RankBean rankBean = new RankBean();
            rankBean.setRank(i);
            rankBean.setName("张三" + i);
            rankBean.setDoneTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setFailTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPassTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPoints(new SecureRandom().nextInt(30) + "");
            mData.add(rankBean);
        }

        if (rankAdapter == null){
            rankAdapter = new RankAdapter(getActivity(), mData);
        }
        rankAdapter.notifyDataSetChanged();
    }

    private void requestNightData(){
        if (mData != null && !mData.isEmpty()){
            mData.clear();
        }
        for (int i = 0; i < 10; i++) {
            RankBean rankBean = new RankBean();
            rankBean.setRank(i);
            rankBean.setName("李四" + i);
            rankBean.setDoneTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setFailTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPassTimes(new SecureRandom().nextInt(12) + "");
            rankBean.setPoints(new SecureRandom().nextInt(30) + "");
            mData.add(rankBean);
        }
        if (rankAdapter == null){
            rankAdapter = new RankAdapter(getActivity(), mData);
        }
        rankAdapter.notifyDataSetChanged();
    }
}
