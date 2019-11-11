package com.bw.zhaozhipeng.model;

import com.bw.zhaozhipeng.Contract;
import com.bw.zhaozhipeng.NetUtil;

/**
 * Copyright (C)
 * <p>
 * FileName: Model
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 8:55
 * <p>
 * Description:
 */
public class Model implements Contract.ModelInter {
    @Override
    public void doGET(String url, final Contract.ModelShared modelShared) {
        NetUtil.getInstance().doGET(url, new NetUtil.Shared() {
            @Override
            public void Success(String josn) {
                modelShared.Success(josn);
            }

            @Override
            public void Filed(String error) {
                modelShared.Filed(error);
            }
        });
    }

    @Override
    public void doPOST(String url, Contract.ModelShared modelShared) {

    }
}
