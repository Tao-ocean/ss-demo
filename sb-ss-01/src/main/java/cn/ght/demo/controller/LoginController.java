package cn.ght.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Slf4j
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }
    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("当前登陆用户：" + name);
        return "home.html";
    }
}
