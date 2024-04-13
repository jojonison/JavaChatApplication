package com.jojonison.jojochat.common;

public class DirectMsg {
    private String msg;
    private User sender;
    private User recipient;

    public DirectMsg(String msg, User sender, User recepient) {
        this.msg = msg;
        this.sender = sender;
        this.recipient = recepient;
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

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
