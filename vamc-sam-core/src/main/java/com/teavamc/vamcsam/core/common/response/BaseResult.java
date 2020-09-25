package com.teavamc.vamcsam.core.common.response;

import com.teavamc.vamcsam.core.common.enums.CommonResultCode;
import com.teavamc.vamcsam.core.common.enums.IErrorCode;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.common
 * @date 2020/9/24 16:04
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1949910043360896391L;
    private boolean success;
    private int code;
    private String message;
    private String requestId;
    private Map<String, Object> errorData;

    public BaseResult() {
        this.code = CommonResultCode.SUCCESS.code;
        this.success = true;
        this.message = CommonResultCode.SUCCESS.message;
    }

    public BaseResult(int code, String message) {
        this(code, message, (String)null);
    }

    public BaseResult(int code, String message, String requestId) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.requestId = requestId;
    }

    public BaseResult(int code, String message, String requestId, @NonNull Object... args) {
        this(code, String.format(message, args), requestId);
        if (args == null) {
            throw new NullPointerException("args");
        }
    }

    public BaseResult(IErrorCode iErrorEnum) {
        this(iErrorEnum, (String)null);
    }

    public BaseResult(IErrorCode iErrorEnum, String requestId) {
        this(iErrorEnum.getCode(), iErrorEnum.getMessage(), requestId);
    }

    public BaseResult(IErrorCode iErrorEnum, String requestId, @NonNull Object... args) {
        this(iErrorEnum.getCode(), String.format(iErrorEnum.getMessage(), args), requestId);
        if (args == null) {
            throw new NullPointerException("args");
        }
    }

    public <R extends BaseResult> R setErrorMessage(int code, String message) {
        this.code = code;
        this.success = CommonResultCode.SUCCESS.code == code;
        this.message = message;
        return (R) this;
    }

    public <R extends BaseResult> R setErrorMessage(IErrorCode code, Object... args) {
        this.code = code.getCode();
        this.success = CommonResultCode.SUCCESS.code == code.getCode();
        this.message = String.format(code.getMessage(), args);
        return (R) this;
    }

    public <R extends BaseResult> R setError(CommonResultCode rc, Object... args) {
        this.code = rc.code;
        this.success = CommonResultCode.SUCCESS.code == rc.getCode();
        if (args != null && args.length != 0) {
            this.message = String.format(rc.message, args);
        } else {
            this.message = rc.message;
        }
        return (R) this;
    }

    public String toString() {
        return "BaseResult(success=" + this.isSuccess() + ", code=" + this.getCode() + ", message=" + this.getMessage() + ", requestId=" + this.getRequestId() + ", errorData=" + this.getErrorData() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResult)) {
            return false;
        } else {
            BaseResult other = (BaseResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label40: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label40;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label40;
                    }

                    return false;
                }

                Object this$errorData = this.getErrorData();
                Object other$errorData = other.getErrorData();
                if (this$errorData == null) {
                    if (other$errorData != null) {
                        return false;
                    }
                } else if (!this$errorData.equals(other$errorData)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        result = result * 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $errorData = this.getErrorData();
        result = result * 59 + ($errorData == null ? 43 : $errorData.hashCode());
        return result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Map<String, Object> getErrorData() {
        return this.errorData;
    }

    public BaseResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public BaseResult setCode(int code) {
        this.code = code;
        return this;
    }

    public BaseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public BaseResult setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public BaseResult setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
        return this;
    }
}