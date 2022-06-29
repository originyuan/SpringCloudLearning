package cc.yuanspace.cloudalibaba.nacos.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务注册与发现功能
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("**** 启动成功 ****");
    }
}
