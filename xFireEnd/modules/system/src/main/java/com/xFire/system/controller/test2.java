package com.xFire.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/acl/test2")
public class test2 {
    @RequestMapping("/aaa")
    @PreAuthorize("hasAuthority('user.add')")
    public String test(){
        return "Hello World";
    }
}
