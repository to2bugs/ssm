package com.otto.springmvc.exception;


import lombok.Data;

/**
 * 自定义业务异常 BizException
 * 业务异常通常是为了与系统异常区分
 */
@Data
public class BizException extends RuntimeException {
    // 业务异常码
    private Integer code;
    // 业务的异常信息
    private String msg;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getMsg());
        this.code = bizExceptionEnum.getCode();
        this.msg = bizExceptionEnum.getMsg();
    }
}
