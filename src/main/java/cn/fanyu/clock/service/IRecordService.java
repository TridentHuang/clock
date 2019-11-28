package cn.fanyu.clock.service;

import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.dto.in.RecordInDto;
import cn.fanyu.clock.entity.Record;
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
public interface IRecordService extends IService<Record> {

    //打卡
    Result punch(PunchInDto punchInDto);

    //根据日期获取打卡记录
    Result getData(RecordInDto recordInDto);
}