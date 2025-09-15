package com.otto.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *  接受原生的API
 */
@RestController
public class ServletRequestResponseTestController {

    @SneakyThrows
    @GetMapping("/handle10")
    public void handle10(
            HttpServletRequest request, HttpServletResponse response,
            HttpSession httpSession
    ) {
        String username = request.getParameter("user");
        System.out.println("username:" + username);

        response.getWriter().write("Hello " + username);
    }
}
