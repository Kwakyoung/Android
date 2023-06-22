package com.example.and09_fragmentadapter.melon;

public class MelonDTO {
    int imgRes;
    String tv_title, tv_group, tv_number;

    public MelonDTO(int imgRes, String tv_title, String tv_group, String tv_number) {
        this.imgRes = imgRes;
        this.tv_title = tv_title;
        this.tv_number = tv_number;
        this.tv_group = tv_group;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_number() {
        return tv_number;
    }

    public void setTv_number(String tv_number) {
        this.tv_number = tv_number;
    }

    public String getTv_group() {
        return tv_group;
    }

    public void setTv_group(String tv_group) {
        this.tv_group = tv_group;
    }
}
