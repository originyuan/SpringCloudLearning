package cc.yuanspace.cloudalibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotKey")
public class HotKeyController {

    @GetMapping("/test")
    @SentinelResource("hotkey-test")
    public String test(String name, Integer age) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        return "hotKey";
    }
}
