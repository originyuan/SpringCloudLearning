package cc.yuanspace.cloudalibaba.sentinel.exception;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;

import java.util.HashMap;
import java.util.Map;


public class BreakExceptionHandler {

    /**
     * 必须是静态方法
     * @param type 与资源方法参数一致
     * @param throwable 必须使用 Throwable
     * @return
     */
    public static String breakHandler2(Integer type, Throwable throwable) {
        System.out.println(throwable.getClass());
        Map<String, Object> r = new HashMap<>();
        if (throwable instanceof DegradeException) {
            System.out.println("熔断降级异常处理");
            return "服务开小差，请稍后重试";
        } else {
            return "非sentinel异常";
        }
    }
}
