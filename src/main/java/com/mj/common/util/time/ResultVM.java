package com.mj.common.util.time;

import java.io.Serializable;

/**
 * Created by oukingtim
 */
public class ResultVM implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Integer CODE = 0;

    private Integer code;

    private Long pagesize;

    private String msg;

    private Object result;

    public ResultVM() {

    }

    public ResultVM(Integer code) {
        this.code = code;
    }

    public ResultVM(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVM(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public ResultVM(Integer code, Long pagesize, Object result) {
        this.code = code;
        this.result = result;
        this.pagesize = pagesize;
    }

    public ResultVM(Object result) {
        this.result = result;
    }

    public static ResultVM error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultVM error(String msg) {
        return error(500, msg);
    }

    public static ResultVM error(Integer code, String msg) {
        return new ResultVM(code, msg);
    }

    public static ResultVM ok(String msg) {
        return new ResultVM(CODE, msg);
    }

    public static ResultVM ok(Object result) {
        return new ResultVM(CODE, result);
    }

    public static ResultVM ok(Long pagesize, Object result) {
        return new ResultVM(CODE, pagesize, result);
    }

    public static ResultVM ok() {
        return new ResultVM(CODE);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Long getPagesize() {
        return pagesize;
    }

    public void setPagesize(Long pagesize) {
        this.pagesize = pagesize;
    }
}
