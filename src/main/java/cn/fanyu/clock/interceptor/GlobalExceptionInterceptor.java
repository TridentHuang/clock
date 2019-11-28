package cn.fanyu.clock.interceptor;

import cn.fanyu.clock.enums.ResCodeEnum;
import cn.fanyu.clock.model.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version V3.0
 * @Title: GlobalExceptionInterceptor
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/8/6 上午10:24
 */
@RestControllerAdvice("cn.fanyu.clock.controller")
public class GlobalExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        //打印异常
        System.out.println("打印异常:---------------------------------------------");
        //异常处理
        if (e instanceof BusinessException) {
            return Result.build(((BusinessException) e).getErrCode(), ((BusinessException) e).getErrMsg());
        } else {
            return Result.build(ResCodeEnum.ERROR.getStatus(), ResCodeEnum.ERROR.getMsg());
        }
    }
}
