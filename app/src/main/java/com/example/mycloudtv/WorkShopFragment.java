package com.example.mycloudtv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mycloudtv.bean.WorkShopStatusBean;
import com.example.mycloudtv.table.GirdAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkShopFragment extends Fragment {

    private GridView statusTable;
    private List<WorkShopStatusBean> dataBeans = new ArrayList<>();
    private GirdAdapter girdAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        statusTable = view.findViewById(R.id.grid_frame);
        initData();
        bindView();
        return view;
    }


    private void initData(){
        for (int a = 0; a < 96; a++){
            WorkShopStatusBean dataBean = new WorkShopStatusBean();
            dataBean.setId(a);
            dataBean.setName("CN001");
            dataBean.setStatus(new SecureRandom().nextInt(4));
            dataBeans.add(dataBean);
        }
    }

    private void bindView(){
        girdAdapter = new GirdAdapter(this.getActivity(), dataBeans);
        statusTable.setAdapter(girdAdapter);
    }
}
