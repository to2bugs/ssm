package com.otto.springmvc.exception;


import lombok.Data;
import lombok.Getter;

/**
 * 业务异常的枚举
 *
 * 枚举就是一个有私有构造器的类
 */
public enum BizExceptionEnum {

    // 定义枚举对象
    // ORDER_XXX 是订单相关的
    ORDER_CLOSED(10001, "订单关闭"),
    ORDER_NOT_EXIST(10002, "订单不存在"),
    ORDER_TIMEOUT(10003, "订单超时"),
    // PRODUCT_XXX 商品相关
    PRODUCT_STOCK_NOT_ENOUGH(20003, "库存不足"),
    PRODUCT_HAS_SOLD(20002, "商品已售完");

    // 异常码
    private Integer code;

    // 异常错误信息
    private String msg;

    private BizExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
