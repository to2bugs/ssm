package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * DispatcherServlet 请求处理流程
 *
 * 关注点:
 * 🔷HandlerMapping
 * 🔷HandlerAdapter
 * 🔷参数处理器
 * 🔷返回值处理器
 *
 * 九大组件：
 * 🔶MultipartResolver  文件上传解析器
 * 🔶LocalResolver  国际化的解析器，基本不用🚫
 * 🔶ThemeResolver  主题解析器，基本不用🚫
 * 🔶List<HandlerMapping>  映射处理器，保存请求路径，及其对应的处理方法
 * 🔶List<HandlerAdapter> 处理器适配器，用来帮助处理方法的参数获取，返回值的转换...
 *                          可以理解为一个大型的反射工具，帮助请求路径对应的方法执行反射调用
 * 🔶List<HandlerExceptionResolver>  异常解析器
 * 🔶RequestToViewNameTranslator 请求到视图的翻译器，因为现在是前后分离编写代码，所以这个用得很少了，基本不用🚫
 * 🔶FlashMapManager  闪存管理器，基本不用🚫
 * 🔶List<ViewResolver> 视图解析器，要拼接前缀和后缀，再跳转到某个页面的解析器，基本不用🚫
 * 🔶HttpMessageConverter  将数据转换为Json数据返回给浏览器
 *
 *
 * DispatcherServlet 继承自 HttpServlet
 *    请求进来后，最终来到doDispatch(HttpServletRequest, HttpServletResponse)方法，并使用到九大组件
 * DispatcherServlet 的请求流程
 *      请求 -> DispatcherServlet.doDispatcher(..)
 */
@SpringBootApplication
public class Springmvc10DispatcherServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc10DispatcherServletApplication.class, args);
    }

}
