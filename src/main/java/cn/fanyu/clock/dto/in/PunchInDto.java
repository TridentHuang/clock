package cn.fanyu.clock.dto.in;

import lombok.Data;

/**
 * @version V3.0
 * @Title: PunchInDto
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/27 下午9:52
 */
@Data
public class PunchInDto {
    //打卡用户id
    private Integer userId;
    //活动id
    private Integer activityId;
    //活动截止时间
    private String endTime;
}
