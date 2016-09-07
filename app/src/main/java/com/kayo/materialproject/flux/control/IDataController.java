package com.kayo.materialproject.flux.control;

import android.content.Context;

import com.kayo.materialproject.flux.action.Action;

/**
 * Created by Kayo on 2016/8/7.
 * 数据控制中心 接口
 */
public interface IDataController {
    void onAction(Action action);
    void register(Context context);
    void unRegister(Context context);
}
