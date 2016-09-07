package com.kayo.materialproject.flux.action;

import com.kayo.materialproject.flux.dispatcher.Dispatcher;

/**
 * Created by Kayo on 2016/8/6.
 * 消息分发处理器  用于发送不同的action
 * 里面引用 Dispatcher 对象
 */

public class ActionsCreator {
    private  static ActionsCreator creator;
    private Dispatcher dispatcher;

    public static ActionsCreator getCreator(Dispatcher dispatcher){
        System.out.println("ActionsCreator  getCreator ");

        if (creator == null){
            creator = new ActionsCreator(dispatcher);
        }
        return creator;
    }

    private ActionsCreator(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    /**
     * 发送动作事件
     * @param action
     */
    public void sendAction(Action action){
        System.out.println("ActionsCreator  sendAction   "+ action.toString());
        dispatcher.dispatch(action);
    }

}
