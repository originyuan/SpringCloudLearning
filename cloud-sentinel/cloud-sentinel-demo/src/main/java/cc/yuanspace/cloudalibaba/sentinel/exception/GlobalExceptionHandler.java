package cc.yuanspace.cloudalibaba.sentinel.exception;

import cc.yuanspace.cloudalibaba.common.model.HttpResponse;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 流控规则全局异常处理
     *   资源方法签名上需要有异常抛出声明 throws Exception 细粒度的 BlockException 及子类也可以
     * @return
     */
    @ExceptionHandler(FlowException.class)
    public HttpResponse<Void> handleFlowException() {
        return HttpResponse.error("系统繁忙，请稍后重试");
    }

    /**
     * 熔断降级规则全局异常处理
     *   资源方法签名上需要有异常抛出声明 throws Exception 细粒度的 BlockException 及子类也可以
     * @return
     */
    @ExceptionHandler(DegradeException.class)
    public HttpResponse<Void> handleDegradeException() {
        return HttpResponse.error("系统开小差，请稍后重试");
    }

    /**
     * 权限规则全局异常处理
     * @return
     */
    @ExceptionHandler(AuthorityException.class)
    public HttpResponse<Void> handleAuthorityException() {
        return HttpResponse.error("没有权限访问");
    }

    /**
     * 未知异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public HttpResponse<Void> handleException(Exception e) {
        e.printStackTrace();
        return HttpResponse.error("全局异常");
    }
}
