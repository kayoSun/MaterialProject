package com.kayo.materialproject.flux.action;

/**
 * Created by Kayo on 2016/8/5.
 * type 表示操作类型的
 * data 表示操作索要携带的参数
 */

public  class Action{

    private final int type;//动作类型
    private final Object data;//事件参数
    public Action(int type, Object data){
        this.data = data;
        this.type = type;
    }
    public int getType(){
        System.out.println("Action   getType");
        return type;
    }
    public Object getData(){
        System.out.println("Action   getData");
        return data;
    }

    @Override
    public String toString() {
        return "type   data = "+ data;
    }
}
