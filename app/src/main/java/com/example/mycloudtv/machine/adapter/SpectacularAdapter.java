package com.example.mycloudtv.machine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.SpectacularBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpectacularAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<SpectacularBean> data;

    public SpectacularAdapter(Context mContext, List<SpectacularBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spectaculars_item, parent, false);
        SpectacularHolder holder = new SpectacularHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (data == null){
            return;
        }

        SpectacularBean bean = data.get(position);
        if (bean != null){
            setText(position, (SpectacularHolder) holder, bean);
        }else {
            ((SpectacularHolder) holder).tvName.setText("");
            ((SpectacularHolder) holder).tvMachine.setText("");
            ((SpectacularHolder) holder).tvProgram.setText("");
            ((SpectacularHolder) holder).tvTarget.setText("");
            ((SpectacularHolder) holder).tvTime1.setText("");
            ((SpectacularHolder) holder).tvTime2.setText("");
            ((SpectacularHolder) holder).tvTime3.setText("");
            ((SpectacularHolder) holder).tvTime4.setText("");
            ((SpectacularHolder) holder).tvTime5.setText("");
            ((SpectacularHolder) holder).tvTime6.setText("");
        }
    }

    @Override
    public int getItemCount() {
        if (data == null || data.isEmpty()){
            return 0;
        }else {
            return data.size();
        }
    }

    private void setText(int position, SpectacularHolder holder, SpectacularBean bean){
        if (position == 0){
            ((SpectacularHolder) holder).tvName.setText("员工");
            ((SpectacularHolder) holder).tvMachine.setText("机床");
            ((SpectacularHolder) holder).tvProgram.setText("程序名称");
            ((SpectacularHolder) holder).tvTarget.setText("目标");
            ((SpectacularHolder) holder).tvTime1.setText("08:00" +"\n" +"10:00");
            ((SpectacularHolder) holder).tvTime2.setText("10:00" +"\n" +"12:00");
            ((SpectacularHolder) holder).tvTime3.setText("12:00" +"\n" +"14:00");
            ((SpectacularHolder) holder).tvTime4.setText("14:00" +"\n" +"16:00");
            ((SpectacularHolder) holder).tvTime5.setText("16:00" +"\n" +"18:00");
            ((SpectacularHolder) holder).tvTime6.setText("18:00" +"\n" +"20:00");

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvMachine.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvProgram.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTarget.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime1.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime2.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime3.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime4.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime5.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTime6.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));

            holder.tvName.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvMachine.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvProgram.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTarget.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime1.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime2.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime3.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime4.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime5.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTime6.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            ((SpectacularHolder) holder).tvName.setText(bean.getEmployeeName());
            ((SpectacularHolder) holder).tvMachine.setText(bean.getMachine());
            ((SpectacularHolder) holder).tvProgram.setText(bean.getProgramName());
            ((SpectacularHolder) holder).tvTarget.setText(bean.getTarget());
            ((SpectacularHolder) holder).tvTime1.setText(bean.getTime_1());
            ((SpectacularHolder) holder).tvTime2.setText(bean.getTime_2());
            ((SpectacularHolder) holder).tvTime3.setText(bean.getTime_3());
            ((SpectacularHolder) holder).tvTime4.setText(bean.getTime_4());
            ((SpectacularHolder) holder).tvTime5.setText(bean.getTime_5());
            ((SpectacularHolder) holder).tvTime6.setText(bean.getTime_6());

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvMachine.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvProgram.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvTarget.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvTime1.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));
            holder.tvTime2.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));
            holder.tvTime3.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));
            holder.tvTime4.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));
            holder.tvTime5.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));
            holder.tvTime6.setBackground(mContext.getDrawable(R.drawable.list_item_green_shape));

            holder.tvName.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvMachine.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvProgram.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvTarget.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvTime1.setTextColor(Color.BLACK);
            holder.tvTime2.setTextColor(Color.BLACK);
            holder.tvTime3.setTextColor(Color.BLACK);
            holder.tvTime4.setTextColor(Color.BLACK);
            holder.tvTime5.setTextColor(Color.BLACK);
            holder.tvTime6.setTextColor(Color.BLACK);
        }
    }

    static class SpectacularHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvMachine;
        TextView tvProgram;
        TextView tvTarget;
        TextView tvTime1;
        TextView tvTime2;
        TextView tvTime3;
        TextView tvTime4;
        TextView tvTime5;
        TextView tvTime6;
        public SpectacularHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvMachine = itemView.findViewById(R.id.tv_machine);
            tvProgram = itemView.findViewById(R.id.tv_program_name);
            tvTarget = itemView.findViewById(R.id.tv_target);
            tvTime1 = itemView.findViewById(R.id.tv_time_1);
            tvTime2 = itemView.findViewById(R.id.tv_time_2);
            tvTime3 = itemView.findViewById(R.id.tv_time_3);
            tvTime4 = itemView.findViewById(R.id.tv_time_4);
            tvTime5 = itemView.findViewById(R.id.tv_time_5);
            tvTime6 = itemView.findViewById(R.id.tv_time_6);
        }
    }
}
