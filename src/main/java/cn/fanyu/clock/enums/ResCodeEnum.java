package cn.fanyu.clock.enums;

import lombok.Getter;

/**
 * @version V3.0
 * @Title: ResCodeEnum
 * @Company: 成都影达科技有限公司
 * @Description: 返回码
 * @author: 东进
 * @date 2019/8/6 上午9:53
 */
@Getter
public enum ResCodeEnum {
    //code码
    SUCCESS(200, "success"),
    ERROR(-1, "系统繁忙"),
    TOKEN_ERROR(400, "token异常"),
    BODY_ERROR(401, "数据解析异常"),
    NOT_FUND(404, "数据解析异常"),
    ACCESS_LIMIT(405, "数据解析异常"),
    SAVE_FAIL(10001, "保存失败"),
    UPDATE_FAIL(10002, "更新失败"),
    DELETE_FAIL(10003, "删除失败"),
    ;
    private int status;
    private String msg;

    ResCodeEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
