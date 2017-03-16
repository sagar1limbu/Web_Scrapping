package com.infodev.Pojo;

/**
 * Created by SUNITA on 1/20/2017.
 */
public class GlobalResponse {
    private String status;
    private String message;
    private Object data;

    public GlobalResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
