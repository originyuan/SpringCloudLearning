package cc.yuanspace.cloudalibaba.sentinel.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockExceptionHandler {

    /**
     * 必须要 public 静态方法
     * 参数列表除 BlockException 外，要和资源方法保持一致
     * @param name
     * @param e
     * @return
     */
    public static String handleException3(String name, BlockException e) {
        e.printStackTrace();
        System.out.println(e.getClass());
        return "公共处理：系统繁忙，稍后重试 ";
    }

}
