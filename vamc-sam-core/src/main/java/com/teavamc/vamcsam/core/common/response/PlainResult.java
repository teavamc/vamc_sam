package com.teavamc.vamcsam.core.common.response;

import com.teavamc.vamcsam.core.common.enums.IErrorCode;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.common.response
 * @date 2020/9/24 16:12
 */
public class PlainResult<T> extends BaseResult {
    private static final long serialVersionUID = -7348340262762007793L;
    private T data;

    public PlainResult(T data) {
        this.data = data;
    }

    public PlainResult(int code, String message) {
        super(code, message);
    }

    public PlainResult(int code, String message, String traceId) {
        super(code, message, traceId);
    }

    public PlainResult(int code, String message, String traceId, Object... args) {
        super(code, message, traceId, args);
    }

    public PlainResult(IErrorCode iErrorEnum) {
        super(iErrorEnum);
    }

    public PlainResult(IErrorCode iErrorEnum, String traceId) {
        super(iErrorEnum, traceId);
    }

    public PlainResult(IErrorCode iErrorEnum, String traceId, Object... args) {
        super(iErrorEnum, traceId, args);
    }

    public String toString() {
        return "PlainResult(super=" + super.toString() + ", data=" + this.getData() + ")";
    }

    public T getData() {
        return this.data;
    }

    public PlainResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PlainResult)) {
            return false;
        } else {
            PlainResult<?> other = (PlainResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlainResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + super.hashCode();
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public PlainResult() {
    }
}