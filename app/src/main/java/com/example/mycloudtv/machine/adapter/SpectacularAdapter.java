package com.example.mycloudtv.machine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.SpectacularBean;
import com.example.mycloudtv.bean.TargetBean;
import com.example.mycloudtv.bean.TimeAreaBean;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpectacularAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TargetBean> data;

    public SpectacularAdapter(Context mContext, List<TargetBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public void setData(List<TargetBean> mData){
        data = mData;
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

        TargetBean bean = data.get(position);
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

    private void setText(int position, SpectacularHolder holder, TargetBean bean){
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
            ((SpectacularHolder) holder).tvTime7.setText("18:00" +"\n" +"20:00");

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
            holder.tvTime7.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));

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
            holder.tvTime7.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            Map<String, TimeAreaBean> map = bean.getTime_area();

            ((SpectacularHolder) holder).tvName.setText(bean.getUser_name());
            ((SpectacularHolder) holder).tvMachine.setText(bean.getDevice_no());
            ((SpectacularHolder) holder).tvProgram.setText(bean.getProgram_name());
            ((SpectacularHolder) holder).tvTarget.setText(bean.getTarget_num() + "");

            if (map.containsKey("08:00-10:00")){
                TimeAreaBean bean1 = map.get("08:00-10:00");
                if (bean1 != null){
                    ((SpectacularHolder) holder).tvTime1.setText(bean1.getCurrent_process_count_total() + "");
                    holder.tvTime1.setBackground(mContext.getDrawable(getColor(bean1.getColor_type())));
                }
            }

            if (map.containsKey("10:00-12:00")){
                TimeAreaBean bean2 = map.get("08:00-10:00");
                if (bean2 != null){
                    ((SpectacularHolder) holder).tvTime2.setText(bean2.getCurrent_process_count_total() + "");
                    holder.tvTime2.setBackground(mContext.getDrawable(getColor(bean2.getColor_type())));
                }
            }

            if (map.containsKey("12:00-13:30")){
                TimeAreaBean bean3 = map.get("08:00-10:00");
                if (bean3 != null){
                    ((SpectacularHolder) holder).tvTime3.setText(bean3.getCurrent_process_count_total() + "");
                    holder.tvTime3.setBackground(mContext.getDrawable(getColor(bean3.getColor_type())));
                }
            }

            if (map.containsKey("13:30-15:30")){
                TimeAreaBean bean4 = map.get("08:00-10:00");
                if (bean4 != null){
                    ((SpectacularHolder) holder).tvTime4.setText(bean4.getCurrent_process_count_total() + "");
                    holder.tvTime4.setBackground(mContext.getDrawable(getColor(bean4.getColor_type())));
                }
            }

            if (map.containsKey("15:30-17:30")){
                TimeAreaBean bean5 = map.get("08:00-10:00");
                if (bean5 != null){
                    ((SpectacularHolder) holder).tvTime5.setText(bean5.getCurrent_process_count_total() + "");
                    holder.tvTime5.setBackground(mContext.getDrawable(getColor(bean5.getColor_type())));
                }
            }

            if (map.containsKey("17:30-18:00")){
                TimeAreaBean bean6 = map.get("08:00-10:00");
                if (bean6 != null){
                    ((SpectacularHolder) holder).tvTime6.setText(bean6.getCurrent_process_count_total() + "");
                    holder.tvTime6.setBackground(mContext.getDrawable(getColor(bean6.getColor_type())));
                }
            }

            if (map.containsKey("18:00-20:00")){
                TimeAreaBean bean7 = map.get("08:00-10:00");
                if (bean7 != null){
                    ((SpectacularHolder) holder).tvTime7.setText(bean7.getCurrent_process_count_total() + "");
                    holder.tvTime7.setBackground(mContext.getDrawable(getColor(bean7.getColor_type())));
                }
            }


            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvMachine.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvProgram.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvTarget.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));

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
            holder.tvTime7.setTextColor(Color.BLACK);
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
        TextView tvTime7;
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
            tvTime7 = itemView.findViewById(R.id.tv_time_7);
        }
    }

    /**
     * 根据类型设置颜色布局
     * @param type 1:绿色 2:黄色 3：红色 4：正常
     * @return
     */
    private int getColor(int type){
        int drawableId;
        switch (type){
            case 1:
                drawableId = R.drawable.list_item_green_shape;
                break;
            case 2:
                drawableId = R.drawable.list_item_yellow_shape;
                break;
            case 3:
                drawableId = R.drawable.list_item_red_shape;
                break;
            default:
                drawableId = R.drawable.rank_list_item_shape;
                break;
        }
        return drawableId;
    }
}
