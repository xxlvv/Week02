package com.bw.zhaozhipeng;

import com.bw.zhaozhipeng.base.BasePresenter;
import com.bw.zhaozhipeng.model.Model;

/**
 * Copyright (C)
 * <p>
 * FileName: Presenter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/11 8:57
 * <p>
 * Description:
 */
public class Presenter extends BasePresenter {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void onStart(String url) {
        model.doGET(url, new Contract.ModelShared() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Filed(String error) {
                getView().Filed(error);
            }
        });
    }
}
