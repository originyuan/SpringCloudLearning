package cc.yuanspace.cloudalibaba.nacos.demo.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${dynamic.config:aaa}")
    private String dynamicConfig;

    @GetMapping("/test")
    public String test(@RequestParam(value = "s", required = false) String s) {
        System.out.println("配置项：" + dynamicConfig);
        return s + dynamicConfig;
    }


}
