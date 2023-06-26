package com.example.project01_kygtalk.chat;

import java.io.Serializable;

public class ChatDTO implements Serializable {
    private int resImgId;
    private String name, msg, time;

    public ChatDTO(int resImgId, String name, String msg, String time) {
        this.resImgId = resImgId;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
