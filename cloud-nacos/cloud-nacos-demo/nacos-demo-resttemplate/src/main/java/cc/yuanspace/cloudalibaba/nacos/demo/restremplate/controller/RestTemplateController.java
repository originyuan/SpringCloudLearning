package cc.yuanspace.cloudalibaba.nacos.demo.restremplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    private static final String providerServiceName = "nacos-demo-provider";
    private static final String providerUrl = "http://%s/nacos-demo-provider/rest/%s";

    private static String getUrl(String path) {
        path = path.startsWith("/") ? path.substring(1) : path;
        return String.format(providerUrl, providerServiceName, path);
    }

    private RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




}
