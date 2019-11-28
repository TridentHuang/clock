package cn.fanyu.clock.interceptor;

import lombok.Data;

/**
 * @version V3.0
 * @Title: BussinessExcption
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/28 下午7:45
 */
@Data
public class BusinessException extends RuntimeException {
    private int errCode;
    private String errMsg;

    public BusinessException(String errMsg) {
        this.errCode = -1;
        this.errMsg = errMsg;
    }

    public BusinessException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
