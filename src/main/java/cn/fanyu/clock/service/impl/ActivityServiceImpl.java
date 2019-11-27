package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.entity.Activity;
import cn.fanyu.clock.mapper.ActivityMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IActivityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Result getAllByUserId(Integer userId) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("belong_user_id", userId);
        List<Activity> list = activityMapper.selectList(queryWrapper);
        return Result.ok(list);
    }
}
