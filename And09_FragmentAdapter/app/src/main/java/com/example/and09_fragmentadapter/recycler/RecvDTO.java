package com.example.and09_fragmentadapter.recycler;

public class RecvDTO {
   private int imgRes ;
   private String name, gender, age , address ;

    public RecvDTO(int imgRes, String name, String gender, String age, String address) {
        this.imgRes = imgRes;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
