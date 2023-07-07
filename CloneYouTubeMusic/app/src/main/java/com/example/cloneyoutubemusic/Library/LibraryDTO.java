package com.example.cloneyoutubemusic.Library;

public class LibraryDTO {
    private int imgv_library_music;
    private String tv_library_title, tv_library_singer;

    public LibraryDTO(int imgv_library_music, String tv_library_title, String tv_library_singer) {
        this.imgv_library_music = imgv_library_music;
        this.tv_library_title = tv_library_title;
        this.tv_library_singer = tv_library_singer;
    }

    public int getImgv_library_music() {
        return imgv_library_music;
    }

    public void setImgv_library_music(int imgv_library_music) {
        this.imgv_library_music = imgv_library_music;
    }

    public String getTv_library_title() {
        return tv_library_title;
    }

    public void setTv_library_title(String tv_library_title) {
        this.tv_library_title = tv_library_title;
    }

    public String getTv_library_singer() {
        return tv_library_singer;
    }

    public void setTv_library_singer(String tv_library_singer) {
        this.tv_library_singer = tv_library_singer;
    }
}
