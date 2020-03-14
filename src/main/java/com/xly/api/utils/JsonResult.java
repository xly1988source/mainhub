package com.xly.api.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Json 统一返回消息类
 *
 * @author edd1225
 */
public class JsonResult implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;
    public static int CODE_SUCCESS = 10000;
    public static Map<String, Object> NOOP = new HashMap<>();


    private int code; // 处理状态：0: 成功
    private String msg;
    private Object data; // 返回数据
    private Long timestamp;
    private String token;

    public JsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        timestamp = System.currentTimeMillis();
    }



    /**
     * 查询list成功并返回数据
     *
     * @param data 数据对象
     * @return data
     */
    public static final JsonResult success(Object data) {
        return new JsonResult(CODE_SUCCESS, "操作成功", data);
    }

    /**
     * 查询list失败并返回数据
     *
     * @param data 数据对象
     * @return data
     */
    public static final JsonResult failure(Integer code, Object data) {
        return new JsonResult(code, "暂无数据", data);
    }


    /**
     * 处理成功
     *
     * @return
     */
    public static final JsonResult success() {
        return new JsonResult(CODE_SUCCESS, "操作成功", NOOP);
    }

    /**
     * 处理成功
     *
     * @param msg 消息
     * @return data
     */
    public static final JsonResult success(String msg) {
        return new JsonResult(CODE_SUCCESS, msg, NOOP);
    }

    /**
     * 处理成功
     *
     * @param msg  消息
     * @param data 数据对象
     * @return data
     */
    public static final JsonResult success(String msg, Object data) {
        return new JsonResult(CODE_SUCCESS, msg, data);
    }

    public static final JsonResult failure(int code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }

    /**
     * 处理失败，并返回数据（一般为错误信息）
     *
     * @param code 错误代码
     * @param msg  消息
     * @return data
     */
    public static final JsonResult failure(int code, String msg) {
        return failure(code, msg, NOOP);
    }

    /**
     * 处理失败
     *
     * @param msg 消息
     * @return data
     */
    public static final JsonResult failure(Integer code, String msg) {
        return new JsonResult(code, msg, NOOP  );
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

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                ", token='" + token + '\'' +
                '}';
    }
}