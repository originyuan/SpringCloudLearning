package cc.yuanspace.cloudalibaba.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource(value = "testServiceResource")
    public String get() {
        System.out.println("testServiceResource");
        return "service resource";
    }
}
