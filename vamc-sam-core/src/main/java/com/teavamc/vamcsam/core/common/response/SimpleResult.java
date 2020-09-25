package com.teavamc.vamcsam.core.common.response;

import java.io.Serializable;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.core.common.response
 * @date 2020/9/24 17:15
 */
public class SimpleResult implements Serializable {
    private static final long serialVersionUID = -6949276465987053848L;
    public static final String RESULT_CODE_EXCEPTION = "-1";
    private boolean success;
    private Integer httpStatusCode;
    private String resultCode;
    private String msg;
    private String orignalResult;

    public SimpleResult() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOrignalResult() {
        return this.orignalResult;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setOrignalResult(String orignalResult) {
        this.orignalResult = orignalResult;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SimpleResult)) {
            return false;
        } else {
            SimpleResult other = (SimpleResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label61: {
                    Object this$httpStatusCode = this.getHttpStatusCode();
                    Object other$httpStatusCode = other.getHttpStatusCode();
                    if (this$httpStatusCode == null) {
                        if (other$httpStatusCode == null) {
                            break label61;
                        }
                    } else if (this$httpStatusCode.equals(other$httpStatusCode)) {
                        break label61;
                    }

                    return false;
                }

                label54: {
                    Object this$resultCode = this.getResultCode();
                    Object other$resultCode = other.getResultCode();
                    if (this$resultCode == null) {
                        if (other$resultCode == null) {
                            break label54;
                        }
                    } else if (this$resultCode.equals(other$resultCode)) {
                        break label54;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$orignalResult = this.getOrignalResult();
                Object other$orignalResult = other.getOrignalResult();
                if (this$orignalResult == null) {
                    if (other$orignalResult != null) {
                        return false;
                    }
                } else if (!this$orignalResult.equals(other$orignalResult)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SimpleResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        Object $httpStatusCode = this.getHttpStatusCode();
        result = result * 59 + ($httpStatusCode == null ? 43 : $httpStatusCode.hashCode());
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $orignalResult = this.getOrignalResult();
        result = result * 59 + ($orignalResult == null ? 43 : $orignalResult.hashCode());
        return result;
    }

    public String toString() {
        return "SimpleResult(success=" + this.isSuccess() + ", httpStatusCode=" + this.getHttpStatusCode() + ", resultCode=" + this.getResultCode() + ", msg=" + this.getMsg() + ", orignalResult=" + this.getOrignalResult() + ")";
    }
}