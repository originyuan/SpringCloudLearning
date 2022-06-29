package cc.yuanspace.cloudalibaba.nacos.demo.consumer.controller;

import cc.yuanspace.cloudalibaba.nacos.demo.common.GoodsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private final RestTemplate restTemplate;

    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public Map<String, Object> test() {
        // 发起远程调用，（任何能发起http请求的都可以），使用RestTemplate，是spring对HttpClient的封装
        String serviceName = "nacos-demo-provider";
        String url = String.format("http://%s/nacos-demo-provider/goods/1", serviceName);
        GoodsDTO goodsDTO = restTemplate.getForObject(url, GoodsDTO.class);
        System.out.println(goodsDTO);

        // 处理数据
        System.out.println("处理数据完成");
        return success(goodsDTO);
    }

    private Map<String, Object> success(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("errcode", 0);
        result.put("errmsg", "success");
        result.put("data", data);
        return result;
    }
}
