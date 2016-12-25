package ru.kamagames.request;

/**
 * Created by Timofey on 25.12.2016.
 */
public class FindUserInfoRequest {

    private String sessionId;
    private String userSiebelId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserSiebelId() {
        return userSiebelId;
    }

    public void setUserSiebelId(String userSiebelId) {
        this.userSiebelId = userSiebelId;
    }

    @Override
    public String toString() {
        return "FindUserInfoRequest{" +
                "sessionId='" + sessionId + '\'' +
                ", userSiebelId='" + userSiebelId + '\'' +
                '}';
    }
}
