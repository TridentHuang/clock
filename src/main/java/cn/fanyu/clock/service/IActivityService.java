package cn.fanyu.clock.service;

import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.entity.Activity;
import cn.fanyu.clock.model.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
public interface IActivityService extends IService<Activity> {

    //判断是否已加入活动
    Result isAdd(PunchInDto punchInDto);

    //申请加入活动
    Result apply(PunchInDto punchInDto);

    //根据用户id获取所有活动（包含参与人）
    Result getAllByUserId(Integer userId);
}
