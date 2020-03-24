package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.SpectacularBean;
import com.example.mycloudtv.machine.adapter.SpectacularAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpectacularsFragment extends Fragment {

    private List<SpectacularBean> mData = new ArrayList<>();
    private SpectacularAdapter spectacularAdapter;
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
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            SpectacularBean spectacularBean = new SpectacularBean();
            spectacularBean.setEmployeeName("张三" + i);
            spectacularBean.setMachine("A0" + i);
            spectacularBean.setProgramName("P00T" + i + "2038");
            spectacularBean.setTarget(new SecureRandom().nextInt(30) + "");
            spectacularBean.setTime_1(new SecureRandom().nextInt(12) + "");
            spectacularBean.setTime_2(new SecureRandom().nextInt(15) + "");
            spectacularBean.setTime_3(new SecureRandom().nextInt(20) + "");
            spectacularBean.setTime_4(new SecureRandom().nextInt(12) + "");
            spectacularBean.setTime_5(new SecureRandom().nextInt(15) + "");
            spectacularBean.setTime_6(new SecureRandom().nextInt(20) + "");
            mData.add(spectacularBean);
        }

        if (spectacularAdapter == null){
            spectacularAdapter = new SpectacularAdapter(getActivity(), mData);
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        listRank.setLayoutManager(manager);
        listRank.setAdapter(spectacularAdapter);
    }
}
