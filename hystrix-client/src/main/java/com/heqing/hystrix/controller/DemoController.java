package com.heqing.hystrix.controller;

import com.heqing.hystrix.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heqing
 * @date 2021/7/22 9:57
 */
@RestController
@RequestMapping("/study")
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/hystrix")
    public String hystrix() {
        return demoService.server("hystrix");
    }

}
