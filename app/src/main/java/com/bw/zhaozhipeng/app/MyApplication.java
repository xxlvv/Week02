package com.bw.zhaozhipeng.app;

import android.app.Application;
import android.content.Context;

/**
 * Copyright (C)
 * <p>
 * FileName: MyApplication
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 8:46
 * <p>
 * Description:
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
