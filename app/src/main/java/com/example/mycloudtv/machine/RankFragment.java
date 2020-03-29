package com.example.mycloudtv.machine;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.example.mycloudtv.bean.RankDataBean;
import com.example.mycloudtv.machine.adapter.RankAdapter;
import com.example.mycloudtv.util.IntegerDefault0Adapter;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class RankFragment extends Fragment {
    private static final String TAG = "RankFragment";

    private List<RankDataBean> dayShiftList;
    private List<RankDataBean> nightShiftList;

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
        getRankTargetData("", getCurrentTime(), MyApplication.getInstance().getUserInfo().data.token);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ManMachineFragment) RankFragment.this.getParentFragment()).setSelectView(0);
    }

    private void initData() {
        if (dayShiftList == null){
            dayShiftList = new ArrayList<>();
            dayShiftList.add(new RankDataBean());
        }
        if (nightShiftList == null){
            nightShiftList = new ArrayList<>();
            nightShiftList.add(new RankDataBean());
        }
        if (rankAdapter == null){
            rankAdapter = new RankAdapter(getActivity(), dayShiftList);
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
        if (rankAdapter != null){
            rankAdapter.setData(dayShiftList);
            rankAdapter.notifyDataSetChanged();
        }
    }

    private void requestNightData(){
        if (rankAdapter != null){
            rankAdapter.setData(nightShiftList);
            rankAdapter.notifyDataSetChanged();
        }
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
                            Gson gson = buildGson();
                            RankBean rankBean = gson.fromJson(s, RankBean.class);
                            if (rankBean != null){
                                List<RankBean.DataBean> list = rankBean.getData();
                                if (list != null && !list.isEmpty()){
                                    for (RankBean.DataBean bean: list) {
                                        if (bean != null){
                                            List<RankDataBean> dataBeans = parseData(bean.getRank_json());
                                            if (dataBeans != null && !dataBeans.isEmpty()){
                                                if (TextUtils.equals("白班", bean.getSchedule_name())) {
                                                    dayShiftList.addAll(dataBeans);
                                                } else {
                                                    nightShiftList.addAll(dataBeans);
                                                }
                                            }
                                        }
                                    }
                                    rankAdapter.notifyDataSetChanged();
                                }
                            }
                        } catch (Exception e) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                });
    }

    private String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    /**
     * 自定义TypeAdapter，避免String类型的数据返回格式有问题
     * @return
     */
    private Gson buildGson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringDefault0Adapter())
                .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
                .create();
        return gson;
    }

    private List<RankDataBean> parseData(String data){
        Gson gson = new Gson();
        Type type = new TypeToken<List<RankDataBean>>(){}.getType();
        return gson.fromJson(data, type);
    }
}
