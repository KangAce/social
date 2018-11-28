package com.social.core.service;

import com.social.core.pojo.user.Menu;
import com.social.core.pojo.user.User;

import java.util.List;

public interface MenuService {
    /**
     * 根据用户查找用户拥有的菜单
     * @param user
     * @return
     * @throws Exception
     */
    List<Menu> queryMenuByUser(User user) throws Exception;

    /**
     * 根据pid查询子菜单
     * @param Pid
     * @return
     * @throws Exception
     */
    List<Menu> queryMenuByPid(Long Pid) throws Exception;
}
