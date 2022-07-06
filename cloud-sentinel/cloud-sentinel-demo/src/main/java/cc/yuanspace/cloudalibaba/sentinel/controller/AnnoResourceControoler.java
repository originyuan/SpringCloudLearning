package cc.yuanspace.cloudalibaba.sentinel.controller;

import cc.yuanspace.cloudalibaba.sentinel.exception.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anno")
public class AnnoResourceControoler {

    @SentinelResource(value = "annotest", blockHandler = "handleException")
    @GetMapping("/test")
    public String test() {

        return "AnnoResource";
    }

    /**
     * 异常处理
     * 处理器方法修饰必须为 public
     * @param e 参数需要使用 BlockException，是 Sentinel 提供的异常类
     * @return 返回数据会作为 Controller 方法的返回
     */
    public String handleException(BlockException e) {
        e.printStackTrace();
        System.out.println(e.getClass());
        return "系统繁忙，稍后重试";
    }

    @SentinelResource(value = "annotest2", blockHandler = "handleException2")
    @GetMapping("/test2")
    public String test2(String name) {

        return "AnnoResource test2";
    }

    /**
     * 参数列表除 BlockException 外，要和资源方法保持一致
     */
    public String handleException2(String name, BlockException e) {
        System.out.println("请求参数：" + name);
        e.printStackTrace();
        System.out.println(e.getClass());
        return "系统繁忙，稍后重试";
    }


    @SentinelResource(value = "annotest3", blockHandlerClass = BlockExceptionHandler.class, blockHandler = "handleException3")
    @GetMapping("/test3")
    public String test3(String name) {

        return "AnnoResource test3";
    }


    @SentinelResource(value = "annotest4")
    @GetMapping("/test4")
    public String test4(String name) throws BlockException{

        return "AnnoResource test4";
    }
}
