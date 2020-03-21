package com.example.mycloudtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mycloudtv.login.LoginActivity;

public class ExitFragment extends Fragment {
    private View view;
    private Button exitBtn;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exit, container, false);
        activity = getActivity();
        exitBtn = view.findViewById(R.id.jiayun_exit_btn);
        action();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null == activity) {
            activity = getActivity();
        }
    }

    private void action() {
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LoginActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });
    }
}
