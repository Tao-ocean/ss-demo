package cn.ght.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: ght
 * @Date: 2020/11/25
 */
@RestController
@RequestMapping("/login/")
public class LoginController {

    @RequestMapping("failure")
    public Map<String,Object> failure() {
        return Collections.singletonMap("登录失败", HttpStatus.UNAUTHORIZED.value());
    }

    @RequestMapping("success")
    public Map<String,Object> success() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = principal.getUsername();


        return Collections.singletonMap("登录失败", HttpStatus.UNAUTHORIZED.value());
    }

}
