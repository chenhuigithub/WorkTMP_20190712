package com.example.worktmp.model;

import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目
 */
public class Question extends KeyValue {
    private String id;//题目ID
    private String title;//标题或内容
    private String scoreRate;//得分率
    private String pid;//上级ID
    private String pname;//上级名称

    private List<Question> childList;//子题目


    public String getId() {
        if (TextUtils.isEmpty(id)) {
            return "";
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScoreRate() {
        if (TextUtils.isEmpty(scoreRate)) {
            return "";
        }
        return scoreRate;
    }

    public void setScoreRate(String scoreRate) {
        this.scoreRate = scoreRate;
    }

    public List<Question> getChildList() {
        if (childList == null) {
            return new ArrayList<Question>();
        }
        return childList;
    }

    public String getPid() {
        if (TextUtils.isEmpty(pid)) {
            return "";
        }
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        if (TextUtils.isEmpty(pname)) {
            return "";
        }
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setChildList(List<Question> childList) {
        this.childList = childList;
    }


    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public String getValue() {
        return getTitle();
    }
}
