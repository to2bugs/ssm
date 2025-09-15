package com.otto.spring.log;

import java.util.Arrays;

/**
 * 自定义日志工具类
 */
public class LogUtil {
    public static void start(String methodName, Object[] args) {
        System.out.println("【日志】" + methodName + "参数: " + Arrays.asList(args));
    }

    public static void end(String methodName, Object result) {
        System.out.println("【日志】" + methodName + "结果: " + result);
    }

    public static void error(String methodName, Throwable message) {
        System.out.println("【日志】" + methodName + "错误信息: " + message);
    }
}
