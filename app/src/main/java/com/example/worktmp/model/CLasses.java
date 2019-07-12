package com.example.worktmp.model;

/**
 * 班级模型类
 */
public class CLasses {
    private String id;//ID
    private String name;//班级名称
    private String scoreRate;//得分率
    private String num;//班级人数
    private String commitNum;//提交人数
    private String unCorrectedNum;//待批改人数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScoreRate() {
        return scoreRate;
    }

    public void setScoreRate(String scoreRate) {
        this.scoreRate = scoreRate;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCommitNum() {
        return commitNum;
    }

    public void setCommitNum(String commitNum) {
        this.commitNum = commitNum;
    }

    public String getUnCorrectedNum() {
        return unCorrectedNum;
    }

    public void setUnCorrectedNum(String unCorrectedNum) {
        this.unCorrectedNum = unCorrectedNum;
    }
}
