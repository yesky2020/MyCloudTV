package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycloudtv.ManMachineFragment;
import com.example.mycloudtv.MyApplication;
import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.SpectacularBean;
import com.example.mycloudtv.bean.SpectacularBean2;
import com.example.mycloudtv.bean.TargetBean;
import com.example.mycloudtv.bean.TimeAreaBean;
import com.example.mycloudtv.machine.adapter.SpectacularAdapter;
import com.example.mycloudtv.util.StringDefault0Adapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpectacularsFragment extends Fragment {

    private static final String TAG = "SpectacularsFragment";

    private List<TargetBean> dayShiftList;
    private List<TargetBean> nightShiftList;
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

    @Override
    public void onResume() {
        super.onResume();
        ((ManMachineFragment) SpectacularsFragment.this.getParentFragment()).setSelectView(1);
    }

    private void initData() {
        if (dayShiftList == null){
            dayShiftList = new ArrayList<>();
            dayShiftList.add(new TargetBean());
        }
        if (nightShiftList == null){
            nightShiftList = new ArrayList<>();
            nightShiftList.add(new TargetBean());
        }
        if (spectacularAdapter == null){
            spectacularAdapter = new SpectacularAdapter(getActivity(), dayShiftList);
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        listRank.setLayoutManager(manager);
        listRank.setAdapter(spectacularAdapter);
    }

    public void requestDayData(){
        spectacularAdapter.setData(dayShiftList);
        spectacularAdapter.notifyDataSetChanged();
    }

    public void requestNightData(){
        spectacularAdapter.setData(nightShiftList);
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

        getMachineTargetData("", getCurrentTime(), MyApplication.getInstance().getUserInfo().data.token);
    }

    private void getMachineTargetData(String scheduleName, String currentTime, String token) {
        String url = "/plat/andtv/machineTarget?schedule_name=" + scheduleName
                + "&current_time=" + currentTime + "&token=" + token;
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
//                            Gson gson = new Gson();
                            Gson gson = buildGson();
                            SpectacularBean bean2 = gson.fromJson(s, SpectacularBean.class);
                            if (bean2 != null && bean2.getData() != null){
                                List<SpectacularBean.DataBean> mData = new ArrayList<>();
                                for (SpectacularBean.DataBean targetBean : bean2.getData()){
                                    if (targetBean != null){
                                        mData.add(targetBean);
                                    }
                                }
                                parseData(mData);
                            }
                        } catch (Exception e) {
                            Log.d(TAG, e.getMessage());
                        }
                    }
                });
    }

    private void parseData(List<SpectacularBean.DataBean> mData) {
        if (mData == null) {
            return;
        }
        for (SpectacularBean.DataBean targetBean : mData) {
            String target_json = targetBean.getTarget_statistics_json();
            if (target_json != null && !TextUtils.isEmpty(target_json)) {
                Map<String, TargetBean> beanMap = parseData(target_json);

                for (TargetBean bean : beanMap.values()) {
                    if (bean != null) {
                        if (TextUtils.equals("白班", targetBean.getSchedule_name())) {
                            dayShiftList.add(bean);
                        } else {
                            nightShiftList.add(bean);
                        }
                    }
                }
            }
        }
        displayView();
    }

    private void displayView(){
        if (spectacularAdapter != null){
            spectacularAdapter.setData(dayShiftList);
            spectacularAdapter.notifyDataSetChanged();
        }
    }

    private String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    private Map<String, TargetBean> parseData(String data){
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String,TargetBean>>(){}.getType();
        return gson.fromJson(data, type);
    }

    /**
     * 自定义TypeAdapter，避免String类型的数据返回格式有问题
     * @return
     */
    private Gson buildGson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringDefault0Adapter())
                .create();
        return gson;
    }
}
