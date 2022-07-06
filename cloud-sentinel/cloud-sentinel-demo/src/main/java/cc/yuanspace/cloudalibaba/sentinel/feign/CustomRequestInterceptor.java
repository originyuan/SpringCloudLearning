package cc.yuanspace.cloudalibaba.sentinel.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 自定义 feign 请求的拦截器，请求发送前执行
 */
@Component
public class CustomRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("source", "cloud-sentinel-demo");
    }
}
