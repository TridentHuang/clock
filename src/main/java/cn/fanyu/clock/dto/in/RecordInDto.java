package cn.fanyu.clock.dto.in;

import lombok.Data;

/**
 * @version V3.0
 * @Title: RecordInDto
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/28 上午9:55
 */
@Data
public class RecordInDto {
    private Integer activityId;
    //日期，当日，昨日
    private String day;
    //打卡截止时间
    private String endTime;
}
