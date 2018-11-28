package com.social.core.controller.menu;

import com.alibaba.fastjson.JSONArray;
import com.social.core.pojo.user.Menu;
import com.social.core.pojo.user.User;
import com.social.core.service.MenuService;
import com.social.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author kang
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @Autowired
    UserService userService;
    @RequestMapping("queryMenu")
    public List<Menu> queryMenu(HttpServletRequest request, HttpServletResponse response) {
        JSONArray objects =null;
                SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) securityContextImpl.getAuthentication().getPrincipal();
        String username = principal.getUsername();
        /**
         * 获取当前登录对象（用户名密码以及权限）
         */
        /*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        String username = userDetails.getUsername();*/
        List<Menu> menuList =null;
        try {
            User user = userService.findOneByUserName(username);
            menuList = menuService.queryMenuByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

}
