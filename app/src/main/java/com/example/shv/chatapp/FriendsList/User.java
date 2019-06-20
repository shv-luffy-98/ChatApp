package com.example.shv.chatapp.FriendsList;

import android.graphics.Bitmap;

public class User {
    public static Bitmap defaultImage;
    private String uname;
    private Bitmap img;

    public User(String uname, Bitmap img) {
        this.uname = uname;
        this.img = img;
    }

    public User(String uname) {
        this.uname = uname;
        this.img = defaultImage;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Bitmap getImage() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
