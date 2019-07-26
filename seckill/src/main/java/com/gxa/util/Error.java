package com.gxa.util;

public class Error {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    private Error(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Error setCodeMsg(int code, String msg) {
        return new Error(code, msg);
    }
}
