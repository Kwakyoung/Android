package com.example.project01_kygtalk.opentalk;

public class PoorChatDTO {
    private String nickname , txt;

    public PoorChatDTO(String nickname, String txt) {
        this.nickname = nickname;
        this.txt = txt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
