package cn.fanyu.clock.dto.in;


import lombok.Getter;
import lombok.Setter;

/**
 * @version V3.0
 * @Title: ActivityInDto
 * @Company: 成都影达科技有限公司
 * @Description: 获取活动信息
 * @author: 东进
 * @date 2019/11/26 下午4:45
 */
@Getter
@Setter
public class ActivityInDto {
    private String name;
    private String endTime;
    private Integer userId;
}
