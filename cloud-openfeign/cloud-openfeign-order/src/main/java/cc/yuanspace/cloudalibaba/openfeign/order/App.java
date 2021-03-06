package cc.yuanspace.cloudalibaba.openfeign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务注册与发现功能
@EnableFeignClients(basePackages = "cc.yuanspace.cloudalibaba.openfeign.api")  // 开启OpenFeign  默认扫当前类的包及其子包
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("**** 启动成功 ****");
    }
}
