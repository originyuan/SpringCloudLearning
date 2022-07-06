package cc.yuanspace.cloudalibaba.sentinel.provider;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String source = httpServletRequest.getHeader("source");
        System.out.println("请求来源：" + source);
        return source;
    }
}
