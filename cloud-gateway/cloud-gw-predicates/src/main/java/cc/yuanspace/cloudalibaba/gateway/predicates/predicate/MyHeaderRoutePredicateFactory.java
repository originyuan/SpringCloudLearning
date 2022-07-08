package cc.yuanspace.cloudalibaba.gateway.predicates.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义 predicate
 * 类名规范：后缀必须为 RoutePredicateFactory
 * 前缀用于配置
 */
@Component
public class MyHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<MyConfig> {


    public MyHeaderRoutePredicateFactory() {
        super(MyConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyConfig config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // 从请求头中获取 key 对应的 value
                String value = serverWebExchange.getRequest().getHeaders().getFirst(config.getKey());
                if (StringUtils.isEmpty(value)) {
                    return false;
                } else {
                    return value.equals(config.getValue());
                }
            }
        };
    }

    /**
     * 用于确定数据根据逗号分割后赋值字段
     * MyHeader=token,123
     * token -> MyConfig#key
     * 123   -> MyConfig#value
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("key", "value");
    }
}
