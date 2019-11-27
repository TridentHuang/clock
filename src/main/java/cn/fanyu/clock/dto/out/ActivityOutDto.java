package cn.fanyu.clock.dto.out;

import cn.fanyu.clock.entity.User;
import lombok.Data;

import java.util.ArrayList;


/**
 * @version V3.0
 * @Title: ActivityOutDto
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/27 下午6:01
 */
@Data
public class ActivityOutDto {
    private String name;
    private ArrayList<UserOutDto> list;
}
