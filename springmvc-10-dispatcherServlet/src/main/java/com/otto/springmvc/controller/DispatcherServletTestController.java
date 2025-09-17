package com.otto.springmvc.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DispatcherServletTestController {

    @GetMapping("/t0")
    public String test() {
        return "test";
    }
}
