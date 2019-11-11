package com.bw.zhaozhipeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bw.zhaozhipeng.R;
import com.bw.zhaozhipeng.StudentBean;

import java.util.List;

/**
 * Copyright (C)
 * <p>
 * FileName: MyBaseAdapter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 9:20
 * <p>
 * Description:
 */
public class MyBaseAdapter1 extends RecyclerView.Adapter<MyBaseAdapter1.Holder> {
    private Context context;
    private List<StudentBean.DataBean.HorizontalListDataBean> horizontalListData;

    public MyBaseAdapter1(Context context, List<StudentBean.DataBean.HorizontalListDataBean> horizontalListData) {

        this.context = context;
        this.horizontalListData = horizontalListData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
        holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(horizontalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher_round).placeholder(R.mipmap.ic_launcher).priority(Priority.HIGH).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return horizontalListData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView iv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}
