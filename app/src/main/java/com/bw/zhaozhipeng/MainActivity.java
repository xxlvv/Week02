package com.bw.zhaozhipeng;


import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhaozhipeng.adapter.MyBaseAdapter1;
import com.bw.zhaozhipeng.adapter.MyBaseAdapter2;
import com.bw.zhaozhipeng.adapter.MyBaseAdapter3;
import com.bw.zhaozhipeng.base.BaseActivity;
import com.bw.zhaozhipeng.base.BasePresenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {

    String utl = "http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private ImageView imageView;

    @Override
    protected void startCoding() {
        mPresenter.onStart(utl);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private RecyclerView radio1;
    private RecyclerView radio2;
    private RecyclerView radio3;

    @Override
    protected void initView() {
        imageView = findViewById(R.id.ima);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);

        radio1.setLayoutManager(new GridLayoutManager(this, 3));
        radio2.setLayoutManager(new LinearLayoutManager(this));
        radio3.setLayoutManager(new GridLayoutManager(this, 2));
        if (NetUtil.getInstance().isWang(this)) {
            imageView.setVisibility(View.GONE);
        } else {
            radio1.setVisibility(View.GONE);
            radio2.setVisibility(View.GONE);
            radio3.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(String json) {
        Gson gson = new Gson();
        StudentBean studentBean = gson.fromJson(json, StudentBean.class);
        StudentBean.DataBean data = studentBean.getData();
        List<StudentBean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        MyBaseAdapter1 myBaseAdapter1 = new MyBaseAdapter1(this, horizontalListData);
        radio1.setAdapter(myBaseAdapter1);

        final List<StudentBean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        MyBaseAdapter2 myBaseAdapter2 = new MyBaseAdapter2(this, verticalListData);
        radio2.setAdapter(myBaseAdapter2);
        myBaseAdapter2.setitemCilck(new MyBaseAdapter2.Cilck() {
            @Override
            public void setOnitemCilck(View v, int p) {
                Toast.makeText(MainActivity.this, verticalListData.get(p).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });

        final List<StudentBean.DataBean.GridDataBean> gridData = data.getGridData();
        MyBaseAdapter3 myBaseAdapter3 = new MyBaseAdapter3(this, gridData);
        radio3.setAdapter(myBaseAdapter3);
        myBaseAdapter3.setitemCilck(new MyBaseAdapter3.Cilck() {
            @Override
            public void setOnitemCilck(View v, int p) {
                Toast.makeText(MainActivity.this, gridData.get(p).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void Filed(String error) {

    }
}
