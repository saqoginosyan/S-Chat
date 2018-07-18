package com.example.sargis.schat.models;

import java.util.List;

public class UsersModel {
    private String imageUrl;
    private String userName;
    private String userStatus;
    private String userNumber;
    private String userEmail;
    private String userInfo;
    private List<MessageModel> messages;

    public UsersModel(String imageUrl, String userName, String userStatus, String userNumber, String userEmail, String userInfo, List<MessageModel> messages) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.userStatus = userStatus;
        this.userNumber = userNumber;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.messages = messages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userEmail;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }
}
