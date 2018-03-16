package com.demo.ok3demo.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/15.
 */

public class User {


    private String userNick;
    private int userId;
    private String facePath;
    private boolean isPoolTranslator;

    private UserLoginDetailBean userLoginDetail;

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFacePath() {
        return facePath;
    }

    public void setFacePath(String facePath) {
        this.facePath = facePath;
    }

    public boolean isPoolTranslator() {
        return isPoolTranslator;
    }

    public void setPoolTranslator(boolean poolTranslator) {
        isPoolTranslator = poolTranslator;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "userNick='" + userNick + '\'' +
                ", userId=" + userId +
                ", facePath='" + facePath + '\'' +
                ", isPoolTranslator=" + isPoolTranslator +
                '}';
    }

    public UserLoginDetailBean getUserLoginDetail() {
        return userLoginDetail;
    }

    public void setUserLoginDetail(UserLoginDetailBean userLoginDetail) {
        this.userLoginDetail = userLoginDetail;
    }

    public static class UserLoginDetailBean implements Serializable {

        private int taskType;
        private int isValidity;
        private String domainName;
        private String url;
        private Object isExaminate;
        private Object token;
        @SerializedName("userId")
        private int userIdX;
        private Object phone;
        private int teamId;
        private int userType;//:1 2 3为企业用户   4 5 为个人用户

        public int getTaskType() {
            return taskType;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        public int getIsValidity() {
            return isValidity;
        }

        public void setIsValidity(int isValidity) {
            this.isValidity = isValidity;
        }

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getIsExaminate() {
            return isExaminate;
        }

        public void setIsExaminate(Object isExaminate) {
            this.isExaminate = isExaminate;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUserIdX() {
            return userIdX;
        }

        public void setUserIdX(int userIdX) {
            this.userIdX = userIdX;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        @Override
        public String toString() {
            return "UserLoginDetailBean{" +
                    "taskType=" + taskType +
                    ", isValidity=" + isValidity +
                    ", domainName='" + domainName + '\'' +
                    ", url='" + url + '\'' +
                    ", isExaminate=" + isExaminate +
                    ", token=" + token +
                    ", userIdX=" + userIdX +
                    ", phone=" + phone +
                    ", teamId=" + teamId +
                    ", userType=" + userType +
                    '}';
        }
    }

}
