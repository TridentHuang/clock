package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.common.SysConstant;
import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.entity.Record;
import cn.fanyu.clock.mapper.RecordMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IRecordService;
import cn.fanyu.clock.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Result punch(PunchInDto punchInDto) {
        //打卡日期
        String punchedDay = new DateUtils().getNowDateStr();
        //次日
        if (punchInDto.getEndTime().contains(SysConstant.TOMMOROW)) {
            //根据打卡截止时间判断打卡日期
        }
        //如果存在

        //如果不存在

        return null;
    }
}
