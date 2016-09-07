package com.kayo.materialproject.flux.control;

import android.content.Context;
import android.os.SystemClock;

import com.kayo.materialproject.flux.action.Action;
import com.kayo.materialproject.flux.action.ActionType;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Kayo on 2016/8/6.
 * 这里进行处理view的所有的处理逻辑 和数据
 */

public class FluxDataController implements IDataController {

    private UpdateEvent updateEvent;
    private Context context;

    public void register(Context context) {
        System.out.println("FluxDataController    registe");
        this.context = context;
        EventBus.getDefault().register(context);
    }

    public void unRegister(Context context) {
        System.out.println("FluxDataController    unRegiste");
        EventBus.getDefault().unregister(context);
        if (this.context == context){
            this.context = null;
        }
    }

    //发送 动作类型
    public void sendStoreChange(int operationType){
        System.out.println("FluxDataController    sendStoreChange");
       if (null != this.context && EventBus.getDefault().isRegistered(this.context)){
           EventBus.getDefault().post(update(operationType));
       }
    }

    //事件的逻辑处理
    @Override
    public  void onAction(Action action){
        System.out.println("FluxDataController    onAction   action = " + action.toString());
        updateEvent = new UpdateEvent(action.getType());

        switch (action.getType()){
            case ActionType.ACTION_1:
                updateEvent.setData(action.getData());
                sendStoreChange(action.getType());
                break;
            case ActionType.ACTION_2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        updateEvent.setData("请求数据成功~~");
                        sendStoreChange(ActionType.ACTION_2);
                    }
                }).start();
                break;
        }

    }

    //事件处理有的界面更新
    public UpdateEvent update(int operationType){

        System.out.println("FluxDataController    changeEvent");

        return updateEvent;
    }
}
