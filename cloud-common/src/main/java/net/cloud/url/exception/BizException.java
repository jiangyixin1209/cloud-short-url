package net.cloud.url.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.cloud.url.enums.BizCodeEnum;

/***
 * @title: BizException
 * @description: 自定义业务异常类
 * @auth: jiangyixin
 * @version: 1.0.0
 * @create: 2023/3/26 10:23
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    private int code;

    private String msg;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }
}
