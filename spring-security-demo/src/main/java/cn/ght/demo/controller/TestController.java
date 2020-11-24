package cn.ght.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("list")
    public Map<String, Object> test1() {
        return Collections.singletonMap("msg", "success");
    }
}
