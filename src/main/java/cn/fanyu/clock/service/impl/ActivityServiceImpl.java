package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.dto.in.ActivityInDto;
import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.dto.out.ActivityOutDto;
import cn.fanyu.clock.dto.out.UserOutDto;
import cn.fanyu.clock.entity.Activity;
import cn.fanyu.clock.interceptor.BusinessException;
import cn.fanyu.clock.mapper.ActivityMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IActivityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Result issue(ActivityInDto activityInDto) {
        //只能发布三个活动
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("belong_user_id", activityInDto.getUserId());
        Integer count = activityMapper.selectCount(queryWrapper);
        if (count > 2) {
            throw new BusinessException(505, "对不起，每个用户只能创建3个活动");
        }
        Activity activity = new Activity() {{
            setBelongUserId(activityInDto.getUserId());
            setName(activityInDto.getName());
            setEndTime(activityInDto.getEndTime());
            setCreateTime(LocalDateTime.now());
        }};
        try {
            activityMapper.insert(activity);
            return Result.ok(true);
        } catch (Exception e) {
            throw new BusinessException(501, "活动已存在");
        }
    }

    @Override
    public Result isAdd(PunchInDto punchInDto) {
        Activity activity = activityMapper.selectById(punchInDto.getActivityId());
        if (null != activity) {
            String memberUserId = activity.getMemberUserId();
            List<String> list = Arrays.asList(memberUserId.split(","));
            if (list.contains(punchInDto.getUserId() + "")) {
                return Result.ok(true);
            }
        }
        return Result.ok(false);
    }

    @Override
    public Result apply(PunchInDto punchInDto) {
        Activity activity = activityMapper.selectById(punchInDto.getActivityId());
        if (null != activity) {
            String memberUserId = activity.getMemberUserId();
            memberUserId = memberUserId + "," + punchInDto.getUserId();
            activity.setMemberUserId(memberUserId);
            int i = activityMapper.updateById(activity);
            if (i > 0) {
                return Result.ok(true);
            }
        }
        return Result.ok(false);
    }

    @Override
    public Result getAllByUserId(Integer userId) {
//        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("belong_user_id", userId);
//        List<Activity> list = activityMapper.selectList(queryWrapper);
//        return Result.ok(list);
        ArrayList<ActivityOutDto> dto = activityMapper.getAllByUserId(userId);
        return Result.ok(dto);
    }

    @Override
    public Result getMemberByActivityId(Integer activityId) {
        ArrayList<UserOutDto> member = activityMapper.getMemberByActivityId(activityId);
        return Result.ok(member);
    }

    @Override
    public Result deleteMember(PunchInDto punchInDto) {
        Activity activity = activityMapper.selectById(punchInDto.getActivityId());
        if (null != activity) {
            String memberUserId = activity.getMemberUserId();
            List idList = Arrays.asList(memberUserId.split(","));
            if (idList.contains(punchInDto.getUserId() + "")) {
                String useIdString = punchInDto.getUserId() + "";
                List arrList = new ArrayList(idList);
                arrList.remove(useIdString);
                String join = String.join(",", arrList);
                activity.setMemberUserId(join);
                int i = activityMapper.updateById(activity);
                if (i > 0)
                    return Result.ok(true);
            }
        }
        return Result.ok(false);
    }
}
