package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mycloudtv.ManMachineFragment;
import com.example.mycloudtv.MyApplication;
import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.RankBean;
import com.example.mycloudtv.machine.adapter.RankAdapter;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class RankFragment extends Fragment {
    private static final String TAG = "RankFragment";

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
        getRankTargetData("", getCurrentTime(), MyApplication.getInstance().getUserInfo().data.token);
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

    private void getRankTargetData(String scheduleName, String currentTime, String token) {
        String url = "/plat/andtv/machineRanking?schedule_name=" + scheduleName
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
                        } catch (Exception e) {

                        }
                    }
                });
    }

    private String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }
}
