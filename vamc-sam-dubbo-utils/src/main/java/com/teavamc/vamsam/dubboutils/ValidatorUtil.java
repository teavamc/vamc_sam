package com.teavamc.vamsam.dubboutils;

import org.hibernate.validator.HibernateValidator;

import java.lang.reflect.Method;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import java.lang.reflect.Method;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package PACKAGE_NAME
 * @date 2020/9/24 16:59
 */
public abstract class ValidatorUtil {

    private static final Validator validator;

    private static final ExecutableValidator executableValidator;

    static {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class).configure().allowOverridingMethodAlterParameterConstraint(true).buildValidatorFactory();
        validator = factory.getValidator();
        executableValidator = validator.forExecutables();
    }

    public static Validator getValidator() {
        return validator;
    }

    public static <T> ValidationResult validate(T obj, Method method, Object[] parameterValues) {
        Set<ConstraintViolation<T>> violations = executableValidator.validateParameters(obj, method, parameterValues);
        return getResult(violations);
    }

    public static <T> ValidationResult validate(T obj) {
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        return getResult(violations);
    }

    private static <T> ValidationResult getResult(Set<ConstraintViolation<T>> violations) {
        if (violations.isEmpty()) {
            return new ValidationResult(true);
        } else {
            return new ValidationResult(false,
                    violations.stream().map(v -> v.getPropertyPath() + " " + v.getMessage()).collect(joining("; "))
            );
        }
    }

    public static final class ValidationResult {
        boolean success;

        String errorMsg;

        ValidationResult(boolean success) {
            this.success = success;
        }

        ValidationResult(boolean success, String errorMsg) {
            this.success = success;
            this.errorMsg = errorMsg;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static final class ValidationFailedException extends RuntimeException {
        private static final long serialVersionUID = -1L;

        public ValidationFailedException(String message) {
            super(message);
        }
    }

}
