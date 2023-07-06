package com.example.cloneyoutubemusic.Round;

public class AlbumDTO {
    private int imgv_album;
    private String tv_album_title, tv_album_singer;

    public AlbumDTO(int imgv_album, String tv_album_title, String tv_album_singer) {
        this.imgv_album = imgv_album;
        this.tv_album_title = tv_album_title;
        this.tv_album_singer = tv_album_singer;
    }

    public int getImgv_album() {
        return imgv_album;
    }

    public void setImgv_album(int imgv_album) {
        this.imgv_album = imgv_album;
    }

    public String getTv_album_title() {
        return tv_album_title;
    }

    public void setTv_album_title(String tv_album_title) {
        this.tv_album_title = tv_album_title;
    }

    public String getTv_album_singer() {
        return tv_album_singer;
    }

    public void setTv_album_singer(String tv_album_singer) {
        this.tv_album_singer = tv_album_singer;
    }
}
