package cn.fanyu.clock.mapper;

import cn.fanyu.clock.dto.out.ActivityOutDto;
import cn.fanyu.clock.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    ActivityOutDto getAllByUserId(Integer userId);
}