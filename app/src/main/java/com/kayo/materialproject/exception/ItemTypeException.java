package com.kayo.materialproject.exception;

/**
 * Created by Kayo on 2016/8/14.
 * 条目类型 异常
 */

public class ItemTypeException extends RuntimeException {

    public ItemTypeException() {
        super();
    }

    public ItemTypeException(String msg) {
        super(msg);
    }
}
