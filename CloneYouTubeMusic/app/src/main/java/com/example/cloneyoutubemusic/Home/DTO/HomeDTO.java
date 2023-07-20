package com.example.cloneyoutubemusic.Home.DTO;

import java.io.Serializable;

public class HomeDTO implements Serializable {
    private int music1, music2, like;
    private String title1, title2, singer1, singer2;

    public HomeDTO(int like) {
        this.like = like;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public HomeDTO(int music1, int music2, String title1, String title2, String singer1, String singer2) {
        this.music1 = music1;
        this.music2 = music2;
        this.title1 = title1;
        this.title2 = title2;
        this.singer1 = singer1;
        this.singer2 = singer2;
    }

    public int getMusic1() {
        return music1;
    }

    public void setMusic1(int music1) {
        this.music1 = music1;
    }

    public int getMusic2() {
        return music2;
    }

    public void setMusic2(int music2) {
        this.music2 = music2;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getSinger1() {
        return singer1;
    }

    public void setSinger1(String singer1) {
        this.singer1 = singer1;
    }

    public String getSinger2() {
        return singer2;
    }

    public void setSinger2(String singer2) {
        this.singer2 = singer2;
    }
}