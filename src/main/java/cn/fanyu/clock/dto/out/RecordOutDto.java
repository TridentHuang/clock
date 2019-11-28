package cn.fanyu.clock.dto.out;

import lombok.Data;

import java.util.List;


/**
 * @version V3.0
 * @Title: RecordOutDto
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/28 下午4:04
 */
@Data
public class RecordOutDto {
    //已打卡人员
    private List<UserOutDto> punchedUsers;
    //未打卡人员
    private List<UserOutDto> notPunchedUsers;
}
