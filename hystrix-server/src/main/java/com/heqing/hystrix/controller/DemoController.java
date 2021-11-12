package com.heqing.hystrix.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@RestController
@RequestMapping("/hystrix")
public class DemoController {

    @PostMapping("/server")
    public String server(@RequestParam String str){
        return "hello " + str;
    }
}
