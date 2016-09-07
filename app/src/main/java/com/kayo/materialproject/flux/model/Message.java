package com.kayo.materialproject.flux.model;

/**
 * Created by Kayo on 2016/8/6.
 */

public class Message {
    private String mText;

    public Message(){}

    public Message(String text) {
        mText = text;
    }

    public String getMessage() {
        return mText;
    }

    public void setMessage(String text) {
        mText = text;
    }
}
