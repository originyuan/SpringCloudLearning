package cc.yuanspace.cloudalibaba.sentinel.controller;

import cc.yuanspace.cloudalibaba.sentinel.exception.BreakExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 熔断降级
 */
@RestController
@RequestMapping("/break")
public class BreakController {

    @GetMapping("/test1")
    @SentinelResource(value = "breakTest1", fallbackClass = BreakExceptionHandler.class, fallback = "breakHandler2")
    public String test1(Integer type) throws Exception{
        System.out.println("test1");
        if (type == null || type == 0) {
            System.out.println("正常接口调用");
        } else {
            if (type == 1) {
                System.out.println("慢调用");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (type == 2) {
                System.out.println("异常调用");
                throw new IllegalArgumentException("接口发生异常");
            }
        }
        return "test";
    }

    /**
     * 熔断降级异常处理
     * @param type
     * @param throwable  熔断处理器方法参数需要用 Throwable
     * @return
     */
    public String breakHandler(Integer type, Throwable throwable) throws Exception{
        System.out.println(throwable.getClass());
        if (throwable instanceof DegradeException ) {
            System.out.println("熔断降级异常处理");
            return "服务开小差，请稍后重试";
        } else {
            return "非sentinel异常";
        }
    }


    @GetMapping("/test2")
    @SentinelResource(value = "breakTest2")
    public String test2(Integer type) throws Exception{
        System.out.println("test2");
        if (type == null || type == 0) {
            System.out.println("正常接口调用");
        } else {
            if (type == 1) {
                System.out.println("慢调用");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (type == 2) {
                System.out.println("异常调用");
                throw new IllegalArgumentException("接口发生异常");
            }
        }
        return "break test2";
    }
}
