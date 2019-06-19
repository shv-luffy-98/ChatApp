package com.example.shv.chatapp.ChatList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ChatListItem {
    public static Bitmap defaultImage;
    private String uname, lastMessage;
    private Bitmap img;

    public ChatListItem(Bitmap image, String username, String lastMessage) {
        img = image;
        uname = username;
        this.lastMessage = lastMessage;
    }

    public ChatListItem(String username, String lastMessage) {
        img = defaultImage;
        uname = username;
        this.lastMessage = lastMessage;
    }

    public Bitmap getImage() {
        return img;
    }

    public void setImage(Bitmap image) {
        img = image;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String username) {
        uname = username;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
