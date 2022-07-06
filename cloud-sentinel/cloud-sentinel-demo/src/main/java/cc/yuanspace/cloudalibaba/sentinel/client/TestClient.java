package cc.yuanspace.cloudalibaba.sentinel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cloud-sentinel-provider", path = "/cloud-sentinel-provider")
@RequestMapping("/test")
public interface TestClient {

    @GetMapping("/get")
    String get();
}