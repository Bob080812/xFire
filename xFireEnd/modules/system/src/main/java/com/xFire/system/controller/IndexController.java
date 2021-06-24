package com.xFire.system.controller;

import com.xFire.system.entity.Permission;
import com.xFire.system.service.IndexService;
import com.xFire.utils.utils.ReturnValue;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/system/index")
//@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public ReturnValue info(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return ReturnValue.ok().data(userInfo);
    }

    /**
     * 获取菜单
     * @return
     */
    @GetMapping("menu")
    public ReturnValue getMenu(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Permission> permissionList = indexService.getMenu(username);
        return ReturnValue.ok().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public ReturnValue logout(){
        return ReturnValue.ok();
    }

}
