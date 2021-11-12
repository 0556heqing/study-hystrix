package com.heqing.hystrix.service.impl;

import com.heqing.hystrix.service.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author heqing
 * @date 2021/7/22 15:29
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    private String ip;

    @Override
    @HystrixCommand(fallbackMethod = "error")
    public String server(String str) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("str", "hystrix");
        String services = restTemplate.postForObject("http://study-hystrix-server/hystrix/server", paramMap, String.class);
        return "调用服务器("+ip+")返回：[" + services + "]";
    }

    /**
     * 调用远程失败会执行此方法。。注意：参数需与方法保持一致
     * @param str
     * @return
     */
    public String error(String str) {
        return "调用远程接口失败！";
    }
}
