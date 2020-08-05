package com.touge.servicebase.handler;

import com.touge.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *统一异常处理类
 * @author touge
 * @create 2020-08-04 14:25
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //自定义异常
    @ExceptionHandler(JuliException.class)
    @ResponseBody
    public R error(JuliException e){
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }


}
