package com.example.mycloudtv.machine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

    public void setData(List<TargetBean> mData) {
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
        if (data == null) {
            return;
        }

        TargetBean bean = data.get(position);
        if (bean != null) {
            setText(position, (SpectacularHolder) holder, bean);
        } else {
            ((SpectacularHolder) holder).tvName.setText("");
            ((SpectacularHolder) holder).tvMachine.setText("");
            ((SpectacularHolder) holder).tvProgram.setText("");
            ((SpectacularHolder) holder).tvTarget.setText("");
            ((SpectacularHolder) holder).layout.removeAllViews();
        }
    }

    @Override
    public int getItemCount() {
        if (data == null || data.isEmpty()) {
            return 0;
        } else {
            return data.size();
        }
    }

    private void setText(int position, SpectacularHolder holder, TargetBean bean) {
        Map<String, TimeAreaBean> map = bean.getTime_area();
        if (map == null) {
            return;
        }

        if (position == 0) {
            ((SpectacularHolder) holder).tvName.setText("员工");
            ((SpectacularHolder) holder).tvMachine.setText("机床");
            ((SpectacularHolder) holder).tvProgram.setText("程序名称");
            ((SpectacularHolder) holder).tvTarget.setText("目标");

            holder.layout.removeAllViews();
            for (Map.Entry<String, TimeAreaBean> entry : bean.getTime_area().entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    key = key.replace("-", "\n");
                }
                TextView textView = new TextView(mContext);
                textView.setText(key);
                textView.setTextSize(20);
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
                textView.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params.weight = 1;
                params.gravity = Gravity.CENTER;
                textView.setLayoutParams(params);
                holder.layout.addView(textView);
            }

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvMachine.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvProgram.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));
            holder.tvTarget.setBackground(mContext.getDrawable(R.drawable.rank_list_item_title_shape));

            holder.tvName.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvMachine.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvProgram.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvTarget.setTextColor(Color.parseColor("#FFFFFF"));

        } else {
            ((SpectacularHolder) holder).tvName.setText(bean.getUser_name());
            ((SpectacularHolder) holder).tvMachine.setText(bean.getDevice_no());
            ((SpectacularHolder) holder).tvProgram.setText(bean.getProgram_name());
            ((SpectacularHolder) holder).tvTarget.setText(bean.getTarget_num() + "");

            holder.layout.removeAllViews();
            for (Map.Entry<String, TimeAreaBean> entry : bean.getTime_area().entrySet()) {
                TimeAreaBean entryValue = entry.getValue();
                if (entryValue == null) {
                    continue;
                }
                TextView textView = new TextView(mContext);
                textView.setText(entryValue.getCurrent_process_count_total() + "");
                textView.setTextSize(20);
                textView.setTextColor(Color.BLACK);
                textView.setBackground(mContext.getDrawable(getColor(entryValue.getColor_type())));
                textView.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                params.weight = 1;
                params.gravity = Gravity.CENTER;
                textView.setLayoutParams(params);
                holder.layout.addView(textView);
            }

            holder.tvName.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvMachine.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvProgram.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));
            holder.tvTarget.setBackground(mContext.getDrawable(R.drawable.rank_list_item_shape));

            holder.tvName.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvMachine.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvProgram.setTextColor(Color.parseColor("#08A6ED"));
            holder.tvTarget.setTextColor(Color.parseColor("#08A6ED"));
        }
    }

    static class SpectacularHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvMachine;
        TextView tvProgram;
        TextView tvTarget;
        LinearLayout layout;

        public SpectacularHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvMachine = itemView.findViewById(R.id.tv_machine);
            tvProgram = itemView.findViewById(R.id.tv_program_name);
            tvTarget = itemView.findViewById(R.id.tv_target);
            layout = itemView.findViewById(R.id.view_time);
        }
    }

    /**
     * 根据类型设置颜色布局
     *
     * @param type 1:绿色 2:黄色 3：红色 4：正常
     * @return
     */
    private int getColor(int type) {
        int drawableId;
        switch (type) {
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
