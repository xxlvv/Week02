package com.bw.zhaozhipeng;

/**
 * Copyright (C)
 * <p>
 * FileName: Contract
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 8:53
 * <p>
 * Description:
 */
public interface Contract {
    interface ModelInter {
        void doGET(String url, ModelShared modelShared);
        void doPOST(String url, ModelShared modelShared);
    }

    interface ModelShared {
        void Success(String json);

        void Filed(String error);
    }

    interface IPresenter {
        void onStart(String url);
    }

    interface IView {
        void Success(String json);

        void Filed(String error);
    }
}
