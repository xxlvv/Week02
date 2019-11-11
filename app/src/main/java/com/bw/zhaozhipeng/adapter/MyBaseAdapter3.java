package com.bw.zhaozhipeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
 * FileName: MyBaseAdapter2
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 9:35
 * <p>
 * Description:
 */
public class MyBaseAdapter3 extends RecyclerView.Adapter<MyBaseAdapter3.Holder> {
    private Context context;
    private List<StudentBean.DataBean.GridDataBean> verticalListData;

    public MyBaseAdapter3(Context context, List<StudentBean.DataBean.GridDataBean> verticalListData) {
        this.context = context;
        this.verticalListData = verticalListData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
        holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        Glide.with(context).load(verticalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher_round).placeholder(R.mipmap.ic_launcher_round).priority(Priority.LOW).into(holder.image1);
        holder.name1.setText(verticalListData.get(position).getTitle());
        holder.price1.setText(verticalListData.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cilck != null) {
                    cilck.setOnitemCilck(holder.price1, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return verticalListData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView image1;
        private TextView name1;
        private TextView price1;

        public Holder(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.image1);
            name1 = itemView.findViewById(R.id.name1);
            price1 = itemView.findViewById(R.id.price1);

        }
    }

    public interface Cilck {
        void setOnitemCilck(View v, int p);
    }

    protected Cilck cilck;

    public void setitemCilck(Cilck cilck) {
        this.cilck = cilck;
    }

}
