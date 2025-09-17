package com.otto.springmvc.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 统一返回R对象
 *      {
 *          "code": 200, // 业务状态码，200是成功，其余的都是失败；前端和后端商量不同的失败业务状态码都代表啥😧意思
 *          "msg": "错误消息", // 显示失败业务状态码的提示消息
 *          "data": 数据对象, // 服务器返回给前端的数据对象
 *      }
 */
@Schema(description = "统一返回对象")
@Data
public class R<T> {
    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "提示消息")
    private String msg;

    @Schema(description = "数据")
    private T data;

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static<T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(500);
        r.setMsg("error");
        return r;
    }

    public static R error(Integer code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static<T> R<T> error(Integer code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
