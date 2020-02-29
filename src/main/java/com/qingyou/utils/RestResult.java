package com.qingyou.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一封装返回
 * @author zhongcchenyu
 */

public class RestResult {
    static Logger logger = LoggerFactory.getLogger(RestResult.class);

    private String code;
    private Object data;
    private Object errorMessage;
    public static final int STATUS_SUCCESS = 2000;
    // 数据重复
    public static final int STATUS_DUPLICATION = 2001;
    public static final int STATUS_WRONG_FORMAT = 4000;
    public static final int STATUS_VALID_FAILED = 4001;
    public static final int STATUS_OUT_OF_SERVICE = 4002;
    public static final int STATUS_ENHANCE_FAILED = 5001;
    public static final int STATUS_OTHERS = 5002;
    public static final int STATUS_FALLBACK = 6001;

    public RestResult(String code, Object data, Object errorMessage) {
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", errorMessage=" + errorMessage +
                '}';
    }


    public String getCode() {
        return code;
    }

    public RestResult setCode(String code) {
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

    public Object getErrorMessage() {
        return errorMessage;
    }

    public RestResult setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
