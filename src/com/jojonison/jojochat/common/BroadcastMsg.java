package com.jojonison.jojochat.common;

public class BroadcastMsg {
    private String msg;
    private User sender;

    public BroadcastMsg(String msg, User sender) {
        this.msg = msg;
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
