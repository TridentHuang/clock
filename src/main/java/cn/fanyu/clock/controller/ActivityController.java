package cn.fanyu.clock.controller;


import cn.fanyu.clock.dto.in.ActivityInDto;
import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    //发布
    @PostMapping("/issue")
    public Result issue(@RequestBody ActivityInDto activityInDto) {
        return activityService.issue(activityInDto);
    }

    //根据用户id获取所有的创建活动
    @GetMapping("getAll/{userId}")
    public Result getAllByUserId(@PathVariable("userId") Integer userId) {
        return activityService.getAllByUserId(userId);
    }

    //判断用户是否已加入活动
    @PostMapping("/isAdd")
    public Result isAdd(@RequestBody PunchInDto punchInDto) {
        return activityService.isAdd(punchInDto);
    }

    //申请加入活动
    @PostMapping("/apply")
    public Result apply(@RequestBody PunchInDto punchInDto) {
        return activityService.apply(punchInDto);
    }

    //根据活动id活动所有人员
    @GetMapping("/getMemberByActivityId/{activityId}")
    public Result getMemberByActivityId(@PathVariable("activityId") Integer activityId) {
        return activityService.getMemberByActivityId(activityId);
    }
}
