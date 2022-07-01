package cc.yuanspace.cloudalibaba.ribbon.consumer.controller;

import cc.yuanspace.cloudalibaba.common.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    // 服务名
    private static final String providerServiceName = "ribbon-provider";
    // 统一路径
    private static final String providerUrl = "http://%s/ribbon-provider";

    private static String getUrl(String path) {
        path = path.startsWith("/") ? path : "/" + path;
        return String.format(providerUrl, providerServiceName) + path;
    }
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public HttpResponse get() {
        Map map = restTemplate.getForObject(getUrl("/test/1"), Map.class);
        return HttpResponse.success(map);
    }
}
