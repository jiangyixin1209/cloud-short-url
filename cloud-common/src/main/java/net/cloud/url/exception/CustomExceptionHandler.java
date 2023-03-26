package net.cloud.url.exception;

import lombok.extern.slf4j.Slf4j;
import net.cloud.url.util.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @title: CustomExceptionHandler
 * @description: 自定义全局异常处理器
 * @auth: jiangyixin
 * @version: 1.0.0
 * @create: 2023/3/26 10:24
 **/
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){
        if(e instanceof BizException){
            BizException bizException = (BizException) e;
            log.error("[业务异常]{0}",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMsg());
        }else {
            log.error("[系统异常]{0}",e);
            return JsonData.buildError("系统异常");
        }
    }
}
