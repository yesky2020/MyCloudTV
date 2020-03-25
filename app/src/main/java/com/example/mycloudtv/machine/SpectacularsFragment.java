package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mycloudtv.MainActivity;
import com.example.mycloudtv.ManMachineFragment;
import com.example.mycloudtv.MyApplication;
import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.SpectacularBean;
import com.example.mycloudtv.bean.UserBean;
import com.example.mycloudtv.bean.VersionBean;
import com.example.mycloudtv.machine.adapter.SpectacularAdapter;
import com.example.mycloudtv.util.Constant;
import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpectacularsFragment extends Fragment {

    private static final String TAG = "SpectacularsFragment";

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
        initListener();
        initData();
        requestData();
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

    public void requestDayData(){
        if (mData != null && !mData.isEmpty()){
            mData.clear();
        }
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

        spectacularAdapter.notifyDataSetChanged();
    }

    public void requestNightData(){
        if (mData != null && !mData.isEmpty()){
            mData.clear();
        }
        for (int i = 0; i < 10; i++) {
            SpectacularBean spectacularBean = new SpectacularBean();
            spectacularBean.setEmployeeName("李四" + i);
            spectacularBean.setMachine("B0" + i);
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

        spectacularAdapter.notifyDataSetChanged();
    }

    private void initListener() {
        ((ManMachineFragment) SpectacularsFragment.this.getParentFragment()).setListener(new ManMachineFragment.ClickListener() {
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

    private void requestData(){
        if (mData != null && !mData.isEmpty()){
            mData.clear();
        }

        getMachineTargetData("", System.currentTimeMillis() + "");
    }

    private void getMachineTargetData(String scheduleName, String currentTime) {
        String url = "/plat/andtv/machineTarget?schedule_name=" + scheduleName + "&&current_time=" + currentTime;
        EasyHttp.get(url).baseUrl("https://m.danfoo.com")
                .readTimeOut(10 * 1000)//局部定义读超时
                .writeTimeOut(10 * 1000)
                .connectTimeout(10 * 1000)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        try {
                            Log.d(TAG, s);
                        } catch (Exception e) {

                        }
                    }
                });
    }
}
