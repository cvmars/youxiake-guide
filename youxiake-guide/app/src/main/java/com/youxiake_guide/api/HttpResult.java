package com.youxiake_guide.api;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class HttpResult<T> {

    private T subjects;
    private int code;
    private String msg;

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

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
}
