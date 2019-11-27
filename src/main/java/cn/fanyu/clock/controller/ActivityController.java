package cn.fanyu.clock.controller;


import cn.fanyu.clock.entity.Activity;
import cn.fanyu.clock.mapper.ActivityMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IActivityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IActivityService iActivityService;
    @Autowired
    private ActivityMapper activityMapper;

    //根据用户id获取所有的创建活动
//    @GetMapping("getAll/")
//    public Result getAllByUserId() {
//        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("belongUserId",)
//        activityMapper.selectBatchIds()
//    }

}
