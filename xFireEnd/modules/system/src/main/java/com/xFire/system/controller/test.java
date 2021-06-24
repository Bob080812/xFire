package com.xFire.system.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/system/test")
public class test {
    static Log log = LogFactory.get(test.class);
    @RequestMapping("/aaa")
    public String test(){
        log.info("test被调用了");
        return "Hello World";
    }
}
