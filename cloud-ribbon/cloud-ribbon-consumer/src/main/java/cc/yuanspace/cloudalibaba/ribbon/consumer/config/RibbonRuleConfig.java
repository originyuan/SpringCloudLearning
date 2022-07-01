package cc.yuanspace.cloudalibaba.ribbon.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class RibbonRuleConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
