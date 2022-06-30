package cc.yuanspace.cloudalibaba.nacos.demo.common;

/**
 * 统一数据响应
 */
public class HttpResponse<T> {
    // 响应码
    private Long errcode;
    // 描述
    private String errmsg;
    // 数据
    private T data;

    private HttpResponse(){}

    private HttpResponse(Long errcode, String errmsg, T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static <T> HttpResponse<T> success(T data) {
        return create(200L, "success", data);
    }
    public static <T> HttpResponse<T> error() {
        return create(500L, "error", null);
    }
    public static <T> HttpResponse<T> error(String errmsg) {
        return create(500L, errmsg, null);
    }

    private static <T> HttpResponse<T> create(Long errcode, String errmsg, T data) {
        return new HttpResponse<>(errcode, errmsg, data);
    }

    public Long getErrcode() {
        return errcode;
    }

    public void setErrcode(Long errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
