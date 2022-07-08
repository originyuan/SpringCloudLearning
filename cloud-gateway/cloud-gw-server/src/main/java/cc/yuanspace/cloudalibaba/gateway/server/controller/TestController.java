package cc.yuanspace.cloudalibaba.gateway.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/get")
    public String get() {
        return "gw server get";
    }


    @GetMapping("/getHeader")
    public String getHeader(@RequestHeader("token") String token) {
        return "getHeader " + token;
    }
}
