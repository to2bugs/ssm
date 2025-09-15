package com.otto.springmvc.controller;


import org.springframework.web.bind.annotation.RestController;


/**
 * @PathVariable - 路径变量
 * 1️⃣ /resources/{name}
 *      {}中的值封装到name变量中，用得最多
 * 2️⃣ /resources/{*path}
 *      {}中的值封装到path变量中，表示的是路径‼️
 *      /resources/image.png   path = /image.png
 *      /resources/css/spring.css  path = /css/spring.css
 * 3️⃣ /resources/{filename:\\w+}.dat
 *      {}中的值封装到filename变量中，且filename要满足\\w+正则的要求，正则表示一个或多个字母
 */
@RestController
public class PathVariableTestController {
}
