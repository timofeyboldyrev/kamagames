package ru.kamagames.authService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by t.boldyrev on 25.12.2016.
 */
public class ValidateResponse {

    private boolean success;
    private String[] roles;
    @JsonProperty("error-message")
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ValidateResponse{" +
                "success=" + success +
                ", roles=" + Arrays.toString(roles) +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
