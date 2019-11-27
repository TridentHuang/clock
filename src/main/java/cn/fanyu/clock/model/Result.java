package cn.fanyu.clock.model;

import cn.fanyu.clock.enums.ResCodeEnum;
import lombok.Data;

/**
 * @version V3.0
 * @Title: Result
 * @Company: 成都影达科技有限公司
 * @Description: 返回数据模型
 * @author: 东进
 * @date 2019/8/6 上午9:51
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result ok() {
        return new Result(ResCodeEnum.SUCCESS.getStatus(), ResCodeEnum.SUCCESS.getMsg(), null);
    }

    public static Result ok(Object data) {
        return new Result(ResCodeEnum.SUCCESS.getStatus(), ResCodeEnum.SUCCESS.getMsg(), data);
    }

    public static Result build(ResCodeEnum resCodeEnum, String msg, Object data) {
        return new Result(resCodeEnum.getStatus(), msg, data);
    }

    public static Result build(ResCodeEnum resCodeEnum, Object data) {
        return new Result(resCodeEnum.getStatus(), resCodeEnum.getMsg(), data);
    }

    public static Result build(ResCodeEnum resCodeEnum) {
        return new Result(resCodeEnum.getStatus(), resCodeEnum.getMsg(), null);
    }
}
