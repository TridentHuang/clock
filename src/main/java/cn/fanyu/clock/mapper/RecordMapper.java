package cn.fanyu.clock.mapper;

import cn.fanyu.clock.dto.out.UserOutDto;
import cn.fanyu.clock.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.ArrayList;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
public interface RecordMapper extends BaseMapper<Record> {

    ArrayList<UserOutDto> getPunchedUsers(Integer activityId, String someDay);

    ArrayList<UserOutDto> getNotPunchedUsers(Integer activityId, String someDay);

}
