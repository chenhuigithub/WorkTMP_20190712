package com.example.worktmp.model;

import android.text.TextUtils;

/**
 * 题库
 */
public class QuestionBank {
    private String id;//ID
    private String name;//名称
    private int imgRes;//题库图标 Logo

    public String getId() {
        if(TextUtils.isEmpty(id)){
            return  "";
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if(TextUtils.isEmpty(name)){
            return  "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
