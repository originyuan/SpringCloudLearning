package cc.yuanspace.cloudalibaba.ribbon.consumer;

import cc.yuanspace.cloudalibaba.ribbon.consumer.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务注册与发现功能
@RibbonClient(name = "ribbon-provider", configuration = RibbonRuleConfig.class)  // name为要调的微服务名称，configuration指定策略配置类
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("**** 启动成功 ****");
    }

    @Bean
    @LoadBalanced // 使Ribbon生效
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
