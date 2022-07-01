package cc.yuanspace.cloudalibaba.ribbon.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public Map get(@PathVariable("id") Long id) {
        Map<String, Object> r = new HashMap<>();
        r.put("id", id);
        r.put("name", "tom" + id);
        r.put("server.port", environment.getProperty("server.port"));
        return r;
    }
}
