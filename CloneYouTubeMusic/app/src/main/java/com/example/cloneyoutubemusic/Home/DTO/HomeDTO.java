package com.example.cloneyoutubemusic.Home.DTO;

import java.io.Serializable;

public class HomeDTO implements Serializable {
    private int music, music1;
    private String title, title1, singer, singer1;

    public HomeDTO(int music, int music1, String title, String title1, String singer, String singer2) {
        this.music = music;
        this.music1 = music1;
        this.title = title;
        this.title1 = title1;
        this.singer = singer;
        this.singer1 = singer2;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public int getMusic1() {
        return music1;
    }

    public void setMusic1(int music1) {
        this.music1 = music1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSinger1() {
        return singer1;
    }

    public void setSinger2(String singer2) {
        this.singer1 = singer1;
    }
}