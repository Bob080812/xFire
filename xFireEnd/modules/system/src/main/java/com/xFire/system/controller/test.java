package com.xFire.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/system/test")
public class test {
    @RequestMapping("/aaa")
    public String test(){
        return "Hello World";
    }
}
