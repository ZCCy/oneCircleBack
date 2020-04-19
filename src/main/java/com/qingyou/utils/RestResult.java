package com.qingyou.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一封装返回
 * @author zhongcchenyu
 */

public class RestResult {
    static Logger logger = LoggerFactory.getLogger(RestResult.class);

    private int code;
    private Object data;
    private Object Message;
    public static final int STATUS_SUCCESS = 200;
    // 数据重复
    public static final int STATUS_DUPLICATION = 201;
    //错误的格式
    public static final int STATUS_WRONG_FORMAT = 400;
    //认证失败
    public static final int STATUS_VALID_FAILED = 401;
    public static final int STATUS_OUT_OF_SERVICE = 402;
    public static final int STATUS_ENHANCE_FAILED = 501;
    //其它（就是500报错）
    public static final int STATUS_OTHERS = 500;
    public static final int STATUS_FALLBACK = 601;

    public RestResult(int code, Object data, Object Message) {
        this.code = code;
        this.data = data;
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", errorMessage=" + Message +
                '}';
    }


    public int getCode() {
        return code;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

    public Object getMessage() {
        return Message;
    }

    public RestResult setMessage(Object errorMessage) {
        this.Message = errorMessage;
        return this;
    }
}
