import annotation.DisableLogging;
import annotation.EnableErrorHandle;
import annotation.EnableLogging;
import annotation.EnableValidation;
import com.google.gson.Gson;
import com.teavamc.vamcsam.core.common.response.BaseResult;
import com.teavamc.vamcsam.core.common.response.SimpleResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package PACKAGE_NAME
 * @date 2020/9/24 17:03
 */
@Aspect
@Slf4j
@Order(0)
@AllArgsConstructor
public class DubboServiceAspect {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static final Gson gson = new Gson();

    private final DubboUtilProperties dubboUtilProperties;

    @Around("@within(org.apache.dubbo.config.annotation.Service)")
    public Object loggerService(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        long startTime = System.currentTimeMillis();
        String methodName = getFullMethodName(joinPoint);
        try {
            try {
                //参数校验
                if (hasAnnotation(EnableValidation.class, joinPoint)) {
                    validateMethodArgs(joinPoint.getThis(), ((MethodSignature) joinPoint.getSignature()).getMethod(), joinPoint.getArgs());
                    validateBeanArgs(joinPoint.getArgs());
                }
                result = joinPoint.proceed();
                long cost = System.currentTimeMillis() - startTime;
                //日志记录
                if (hasAnnotation(EnableLogging.class, joinPoint) && !hasAnnotation(DisableLogging.class, joinPoint)) {
                    if (BooleanUtils.isTrue(dubboUtilProperties.getLogResult())) {
                        logger.info("[DUBBO RPC SUCCESS] {} with param:{} response:{} elapsed:{}", methodName, gson.toJson(joinPoint.getArgs()), gson.toJson(result),
                                cost);
                    } else {
                        logger.info("[DUBBO RPC SUCCESS] {} with param:{} elapsed:{}", methodName, gson.toJson(joinPoint.getArgs()), cost);
                    }

                }
            } catch (IllegalArgumentException ex) {
                logger.warn("[DUBBO RPC WARN] {} with param:{} elapsed{}", methodName, gson.toJson(joinPoint.getArgs()), System.currentTimeMillis() - startTime);
                throw ex;
            } catch (BizException e) {
                logger.warn("[DUBBO RPC WARN] {} with param:{} elapsed:{}", methodName, gson.toJson(joinPoint.getArgs()), System.currentTimeMillis() - startTime, e);
                throw e;
            }
        } catch (Throwable throwable) {
            long cost = System.currentTimeMillis() - startTime;
            //如果不是参数或者自定义异常
            if (!(throwable instanceof IllegalArgumentException) && !(throwable instanceof BizException)) {
                logger.error("[DUBBO RPC ERROR] {} with param:{} elapsed:{}", methodName, gson.toJson(joinPoint.getArgs()), cost, throwable);
            }
            if (hasAnnotation(EnableErrorHandle.class, joinPoint)) {
                return buildErrorResult(throwable, ((MethodSignature) joinPoint.getSignature()).getReturnType());
            } else {
                throw throwable;
            }

        }
        return result;
    }

    private void validateMethodArgs(Object proxy, Method method, Object[] args) {
        ValidatorUtil.ValidationResult rlt = ValidatorUtil.validate(proxy, method, args);
        if (!rlt.isSuccess()) {
            throw new IllegalArgumentException(rlt.getErrorMsg());
        }
    }

    private void validateBeanArgs(Object[] args) {
        for (Object arg : args) {
            ValidatorUtil.ValidationResult rlt = ValidatorUtil.validate(arg);
            if (!rlt.isSuccess()) {
                throw new IllegalArgumentException(rlt.getErrorMsg());
            }
        }
    }

    private <T extends Annotation> boolean hasAnnotation(Class<T> clazz, ProceedingJoinPoint joinPoint) {
        return joinPoint.getSourceLocation().getWithinType().getAnnotation(clazz) != null
                || ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(clazz) != null;
    }

    private static String getFullMethodName(ProceedingJoinPoint joinPoint) {
        String className = getClassName(joinPoint);
        String methodName = joinPoint.getSignature().getName();
        return className + " . " + methodName;
    }

    private static String getClassName(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSourceLocation().getWithinType().getName();
        if (className.indexOf('@') > 0) {
            className = className.substring(0, className.lastIndexOf('@'));
        }
        if (className.indexOf('.') > 0) {
            className = className.substring(className.lastIndexOf('.') + 1);
        }
        return className;
    }

    private Object buildErrorResult(Throwable t, Class<?> returnType) {
        try {
            int errCode;
            String errMsg;
            if (t instanceof IllegalArgumentException) {
                errCode = 505;
                errMsg = "参数异常:" + t.getMessage();
            } else if (t instanceof BizException) {
                errCode = ((BizException) t).getCode();
                errMsg = t.getMessage();
            } else {
                errCode = -1;
                errMsg = "服务器内部异常" + ":" + t.getMessage();
            }

            Object rlt = returnType.newInstance();
            if (rlt instanceof BaseResult) {
                ((BaseResult) rlt).setErrorMessage(errCode, errMsg);
            } else if (rlt instanceof SimpleResult) {
                ((SimpleResult) rlt).setSuccess(false);
                ((SimpleResult) rlt).setHttpStatusCode(500);
                ((SimpleResult) rlt).setResultCode(String.valueOf(errCode));
                ((SimpleResult) rlt).setMsg(errMsg + ":" + t.getMessage());
            } else {
                logger.warn("return type {} not supported", returnType);
            }
            return rlt;
        } catch (Throwable tt) {
            logger.error("buildErrorResult failed", tt);
            return null;
        }
    }

}
