package com.example.cloneyoutubemusic.Home.DTO;

public class MixDTO {

    private int item_music;
    private String item_txt;

    public MixDTO(int item_music, String item_txt) {
        this.item_music = item_music;
        this.item_txt = item_txt;
    }

    public int getItem_music() {
        return item_music;
    }

    public void setItem_music(int item_music) {
        this.item_music = item_music;
    }

    public String getItem_txt() {
        return item_txt;
    }

    public void setItem_txt(String item_txt) {
        this.item_txt = item_txt;
    }
}
