package com.kayo.materialproject.flux.control;

/**
 * Created by Kayo on 2016/8/6.
 * 数据刷新  携带刷新数据实体
 */
public class UpdateEvent {
    private int operationType;
    public int getOperationType(){
        return operationType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public UpdateEvent(int operationType) {
        this.operationType = operationType;
    }
}
