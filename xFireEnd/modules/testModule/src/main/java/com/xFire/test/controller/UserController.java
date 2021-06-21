//package com.xFire.test.controller;
//
//import cn.dev33.satoken.annotation.SaCheckLogin;
//import cn.dev33.satoken.annotation.SaCheckPermission;
//import cn.dev33.satoken.annotation.SaCheckRole;
//import cn.dev33.satoken.stp.SaTokenInfo;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user/")
//public class UserController {
//
//    // 测试登录，浏览器访问： http://localhost:9002/user/doLogin?username=zhang&password=123456
//    @RequestMapping("doLogin")
//    public String doLogin(String username, String password) {
//        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
//        if("zhang".equals(username) && "123456".equals(password)) {
//            StpUtil.login(10001);
//            return "登录成功";
//        }
//        return "登录失败";
//    }
//
//    // 查询登录状态，浏览器访问： http://localhost:9002/user/isLogin
//    @RequestMapping("isLogin")
//    public String isLogin(String username, String password) {
//
//
//        // 获取当前`StpLogic`的token名称
//        String tokenName = StpUtil.getTokenName();
//
//        // 获取当前会话的token值
//        String tokenValue = StpUtil.getTokenValue();
//
//        // 获取当前会话的token信息参数
//        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//        // 获取指定token对应的登录id，如果未登录，则返回 null
//        StpUtil.getLoginIdByToken(tokenValue);
//
//        System.out.println(tokenName);
//        System.out.println(tokenValue);
//        System.out.println(tokenInfo);
//        return "当前会话是否登录：" + StpUtil.isLogin();
//    }
//
//    // 登录认证：当前会话必须登录才能通过
//    @SaCheckLogin
//    @RequestMapping("info")
//    public String info() {
//        System.out.println(StpUtil.hasRole("super-admin"));
//        System.out.println(StpUtil.isLogin());
//        return "查询用户信息";
//    }
//
//    // 角色认证：当前会话必须具有指定角色标识才能通过
//    @SaCheckRole("super-admin1")
//    @RequestMapping("add")
//    public String add() {
//        return "用户增加";
//    }
//
//    // 权限认证：当前会话必须具有指定权限才能通过
//    @SaCheckPermission("user-add")
//    @RequestMapping("add1")
//    public String add1() {
//        return "用户增加";
//    }
//
//}
