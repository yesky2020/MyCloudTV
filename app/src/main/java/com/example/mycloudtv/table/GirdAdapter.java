package com.example.mycloudtv.table;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycloudtv.R;
import com.example.mycloudtv.bean.WorkShopStatusBean;

import java.util.List;

public class GirdAdapter extends BaseAdapter {

    private Context context;
    private List<WorkShopStatusBean> dataList;

    public GirdAdapter(Context context, List<WorkShopStatusBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        if (dataList == null || dataList.isEmpty()){
            return 0;
        }else {
            return dataList.size();
        }
    }

    @Override
    public Object getItem(int i) {
        if (dataList == null || dataList.isEmpty()){
            return null;
        }else {
            return dataList.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        if (dataList == null || dataList.isEmpty()){
            return 0;
        }else {
            return i;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_workshop_gird_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.item = view.findViewById(R.id.item_view);
            viewHolder.name = view.findViewById(R.id.statusItem);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        WorkShopStatusBean bean = dataList.get(i);
        if (bean != null){
            viewHolder.name.setText(bean.getName());
            viewHolder.item.setBackgroundColor(getColor(bean.getStatus()));
        }
        return view;
    }

    private int getColor(int status){
        switch (status){
            case 0:
                return Color.GREEN;
            case 1:
                return Color.RED;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.GRAY;
            default:
                return Color.BLACK;

        }
    }

    private static class ViewHolder{
        LinearLayout item;
        TextView name;
    }
}
