package com.example.llamaapp;

public class Message {
    private String message;
    private boolean isUser;

    public Message(String message, Boolean isUser) {
        this.message = message;
        this.isUser = isUser;
    }

    public String getMessage() {
        return message;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
