package com.example.mycloudtv.machine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.RankBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RankAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<RankBean> mData;

    public RankAdapter(Context mContext, List<RankBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rank_list_item, parent, false);
        return new RankListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (mData == null || mData.isEmpty()){
            return;
        }
        RankBean rankBean = mData.get(position);
        if (rankBean != null ){
            setTextAndStatus(position, (RankListHolder) holder, rankBean);
        }else {
            ((RankListHolder) holder).tvName.setText("");
            ((RankListHolder) holder).tvRank.setText("");
            ((RankListHolder) holder).tvDoneTimes.setText("");
            ((RankListHolder) holder).tvPassTimes.setText("");
            ((RankListHolder) holder).tvFailTimes.setText("");
            ((RankListHolder) holder).tvPoints.setText("");
        }
    }

    @Override
    public int getItemCount() {
        if (mData == null || mData.isEmpty()){
            return 0;
        }else {
            return mData.size();
        }
    }

    private void setTextAndStatus(int position, RankListHolder holder, RankBean rankBean){
        if (position == 0){
            ((RankListHolder) holder).tvName.setText("员工");
            ((RankListHolder) holder).tvRank.setText("排名");
            ((RankListHolder) holder).tvDoneTimes.setText("达成数");
            ((RankListHolder) holder).tvPassTimes.setText("及格数");
            ((RankListHolder) holder).tvFailTimes.setText("失败数");
            ((RankListHolder) holder).tvPoints.setText("分数");

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvRank.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvDoneTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvPassTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvFailTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvPoints.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));

            holder.tvName.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvRank.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvDoneTimes.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvPassTimes.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvFailTimes.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvPoints.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            ((RankListHolder) holder).tvName.setText(rankBean.getName());
            ((RankListHolder) holder).tvRank.setText((position) + "");
            ((RankListHolder) holder).tvDoneTimes.setText(rankBean.getDoneTimes());
            ((RankListHolder) holder).tvPassTimes.setText(rankBean.getPassTimes());
            ((RankListHolder) holder).tvFailTimes.setText(rankBean.getFailTimes());
            ((RankListHolder) holder).tvPoints.setText(rankBean.getPoints());

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvRank.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvDoneTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvPassTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvFailTimes.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvPoints.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));

            holder.tvName.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvRank.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvDoneTimes.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvPassTimes.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvFailTimes.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvPoints.setTextColor(Color.parseColor("#08A6ED"));
        }
    }

    static class RankListHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRank;
        TextView tvFailTimes;
        TextView tvPassTimes;
        TextView tvDoneTimes;
        TextView tvPoints;

        public RankListHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_employee_name);
            tvRank = itemView.findViewById(R.id.tv_rank);
            tvFailTimes = itemView.findViewById(R.id.tv_fail_times);
            tvPassTimes = itemView.findViewById(R.id.tv_pass_times);
            tvDoneTimes = itemView.findViewById(R.id.tv_done_times);
            tvPoints = itemView.findViewById(R.id.tv_employee_points);
        }
    }
}
