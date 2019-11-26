package cn.fanyu.clock.controller;

/**
 * @version V3.0
 * @Title: IssueController
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/26 下午4:33
 */

import cn.fanyu.clock.dto.ActivityInDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 发布控制器
 */
@RestController
@RequestMapping("/activity")
public class IssueController {

    @PostMapping("/issue")
    public void issue(@RequestBody ActivityInDto activityInDto) {
        System.out.println(activityInDto.getName());
        System.out.println(activityInDto.getEndTime());
    }
}
