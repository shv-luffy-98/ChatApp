package com.example.shv.chatapp;

import com.google.gson.Gson;

public class ToJSON {
    private String JSON;
    ToJSON(String json){
        this.JSON = json;
    }
    public <T> T convert(Class<T> type){
        Gson g = new Gson();
        return g.fromJson(this.JSON,type);
    }
}

