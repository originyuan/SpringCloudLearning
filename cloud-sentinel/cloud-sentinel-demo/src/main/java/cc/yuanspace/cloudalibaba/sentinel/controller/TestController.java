package cc.yuanspace.cloudalibaba.sentinel.controller;

import cc.yuanspace.cloudalibaba.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    
    @RequestMapping("get")
    public String get() {
        testService.get();
        return "123";
    }

    @RequestMapping("get2")
    public String get2() {
        testService.get();
        return "456";
    }
}
