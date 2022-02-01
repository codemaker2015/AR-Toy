package com.tcs.artoy.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("success")
    private boolean success;
    @SerializedName("valid")
    private boolean valid;
    @SerializedName("msg")
    private String msg;

    public Response() {}

    public Response(boolean success, boolean valid, String msg) {
        this.success = success;
        this.valid = valid;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
