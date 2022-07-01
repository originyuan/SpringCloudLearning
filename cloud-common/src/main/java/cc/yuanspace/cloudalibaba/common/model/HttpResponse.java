package cc.yuanspace.cloudalibaba.common.model;

import java.util.Objects;

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

    public static <T> HttpResponse<T> success() {
        return success(null);
    }
    public static <T> HttpResponse<T> success(T data) {
        return create(200L, "success", data);
    }
    public static <T> HttpResponse<T> error() {
        return error("error");
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

    @Override
    public String toString() {
        return "HttpResponse{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpResponse<?> that = (HttpResponse<?>) o;
        return Objects.equals(errcode, that.errcode) &&
                Objects.equals(errmsg, that.errmsg) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errcode, errmsg, data);
    }
}
