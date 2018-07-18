package com.example.sargis.schat.models;

public class MessageModel {
    private String message;
    private boolean isMine;

    public MessageModel(String message, boolean isMine) {
        this.message = message;
        this.isMine = isMine;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}