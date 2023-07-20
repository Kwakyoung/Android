package com.example.cloneyoutubemusic.search;

public class SearchVO {

    private int music;
    private String title, singer;

    public SearchVO(int music, String title, String singer) {
        this.music = music;
        this.title = title;
        this.singer = singer;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}


