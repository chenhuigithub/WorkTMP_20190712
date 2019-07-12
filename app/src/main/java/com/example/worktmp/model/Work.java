package com.example.worktmp.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作业模型类
 *
 * @author chenhui 2019.07.02
 */
public class Work extends KeyValue {
    private String id;//ID
    private String name;//作业名称
    private String isArranged;//是否已布置(0: 1:)
    private String num;//题目数量
    private String isCorrected;//是否已批改(0: 1:)
    private String state;//状态（0：未布置，1：已布置，2：已批改）
    private String correctRate;//答题正确率
    private List<Question> questionList;//包含的所有题目

    private List<CLasses> classList;//做这套题的班级

    public String getId() {
        if (TextUtils.isEmpty(id)) {
            return "";
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsArranged() {
        if (TextUtils.isEmpty(isArranged)) {
            return "";
        }
        return isArranged;
    }

    public void setIsArranged(String isArranged) {
        this.isArranged = isArranged;
    }

    public String getNum() {
        if (TextUtils.isEmpty(num)) {
            return "";
        }
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


    public String getIsCorrected() {
        if (TextUtils.isEmpty(isCorrected)) {
            return "";
        }
        return isCorrected;
    }

    public void setIsCorrected(String isCorrected) {
        this.isCorrected = isCorrected;
    }

    public String getState() {
        if (TextUtils.isEmpty(state)) {
            return "";
        }
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCorrectRate() {
        if (TextUtils.isEmpty(correctRate)) {
            return "";
        }
        return correctRate;
    }

    public void setCorrectRate(String correctRate) {
        this.correctRate = correctRate;
    }

    public List<Question> getQuestionList() {
        if (questionList == null) {
            return new ArrayList<Question>();
        }
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<CLasses> getClassList() {
        if (classList == null) {
            return new ArrayList<CLasses>();
        }
        return classList;
    }


    public void setClassList(List<CLasses> classList) {
        this.classList = classList;
    }
}
