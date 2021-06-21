package com.xFire.test.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec")
public class springSecurityTest {
    static Log log = LogFactory.get(springSecurityTest.class);
    @RequestMapping("/do")
    public String hello(){
        log.info("调用do接口成功");
        return "Do Do Do ...";
    }
}
