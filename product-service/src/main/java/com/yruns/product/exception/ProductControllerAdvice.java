package com.yruns.product.exception;

import com.yruns.common.exception.BizCodeEnum;
import com.yruns.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * ProductControllerAdvice for
 *
 * @Author yruns
 * @Version 2023/6/30
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.yruns.product.controller")
public class ProductControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();

        // 获取校验的错误信息
        bindingResult.getFieldErrors().forEach(item -> {
            String message = item.getDefaultMessage();
            String field = item.getField();
            errorMap.put(field, message);
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {

        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
