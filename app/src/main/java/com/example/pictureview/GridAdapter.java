package com.example.pictureview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绍轩 on 2018/6/21.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list = new ArrayList<>();

    public GridAdapter(Activity activity) {
        this.mContext = activity;
    }

    public void setData(List<String> list) {
        if (null != list) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }
    public int getCount() {
        if (list != null && list.size() > 0){
            return list.size();
        }
        else{
            return 0;
        }
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerHolder view;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_payment_griddetails, null);
            view= new RecyclerHolder(convertView);
            convertView.setTag(view);
        } else {
            view = (RecyclerHolder) convertView.getTag();
        }
        String url = list.get(position);
        Glide.with(mContext).load(url).into(view.iv);
        return convertView;
    }
    class RecyclerHolder  {
        ImageView iv;
        TextView tv;

        private RecyclerHolder(View itemView) {
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
