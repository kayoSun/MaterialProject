package com.kayo.materialproject.flux.dispatcher;

import android.content.Context;

import com.kayo.materialproject.flux.action.Action;
import com.kayo.materialproject.flux.control.IDataController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kayo on 2016/8/6.
 * 事件分发
 */

public class Dispatcher {

    private static Dispatcher dispatcher;
    private List<IDataController> stores = new ArrayList<>();
    private volatile IDataController store;

    private Dispatcher(){}
    //获取分发器
    public static Dispatcher getDispatcher(){
        System.out.println("Dispatcher   getDispatcher");
        if (dispatcher == null){
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    //注册
    public void register(Context context,final IDataController store){
        System.out.println("Dispatcher   registe");

        if (!stores.contains(store)){
            store.register(context);
            this.store = store;
            stores.add(store);
        }
    }
    //反注册
    public void unRegister(Context context,final IDataController store){
        System.out.println("Dispatcher   unRegiste");
        if (stores.contains(store)){
            store.unRegister(context);
            stores.remove(store);
            this.store = null;
        }
    }
    //分发 事件
    public void dispatch(Action action){
        System.out.println("Dispatcher   dispatch");
        post(action);
    }

    //为每个Store绑定Action
    private void post(Action action){
        System.out.println("Dispatcher   post");
//        for (IDataController store : stores) {
//            store.onAction(action);
//        }
        if (store != null){
            this.store.onAction(action);
        }
    }
}
