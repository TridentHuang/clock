package cn.fanyu.clock.controller;


import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.mapper.ActivityMapper;
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
    @Autowired
    private ActivityMapper activityMapper;

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
    public Result apply(@RequestBody PunchInDto punchInDto) {
        return activityService.apply(punchInDto);
    }
}
