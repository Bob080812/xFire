package com.xFire.system.service;

import com.alibaba.fastjson.JSONObject;
import com.xFire.system.entity.Permission;

import java.util.List;
import java.util.Map;

public interface IndexService {

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    Map<String, Object> getUserInfo(String username);

    /**
     * 根据用户名获取动态菜单
     * @param username
     * @return
     */
    List<Permission> getMenu(String username);

}
