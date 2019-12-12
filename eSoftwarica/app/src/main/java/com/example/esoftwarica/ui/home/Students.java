package com.example.esoftwarica.ui.home;

public class Students {

    private String name;
    private int age;
    private int imageid;
    private String address;

    public Students(String name, int age, int imageid, String address) {
        this.name = name;
        this.age = age;
        this.imageid = imageid;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}