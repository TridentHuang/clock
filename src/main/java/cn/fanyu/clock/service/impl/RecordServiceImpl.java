package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.common.SysConstant;
import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.dto.in.RecordInDto;
import cn.fanyu.clock.dto.out.RecordOutDto;
import cn.fanyu.clock.dto.out.UserOutDto;
import cn.fanyu.clock.entity.Record;
import cn.fanyu.clock.mapper.RecordMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IRecordService;
import cn.fanyu.clock.utils.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
            punchedDay = DateUtils.getPunchedDay(punchInDto.getEndTime());
        }
        //获取打卡记录
        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("activity", punchInDto.getActivityId())
                .eq("punchedDay", punchedDay);
        Record record = recordMapper.selectOne(queryWrapper);
        if (null != record) {
            String punchedUserId = record.getPunchedUserId();
            punchedUserId = punchedUserId + "," + punchInDto.getUserId();
            record.setPunchedUserId(punchedUserId);
            int i = recordMapper.updateById(record);
            if (i > 0) {
                return Result.ok(true);
            }
        }
        return Result.ok(false);
    }

    @Override
    public Result getData(RecordInDto recordInDto) {
        //打卡日期
        String punchedDay = DateUtils.getNowDateStr();
        if (recordInDto.getEndTime().contains(SysConstant.TOMMOROW)) {
            punchedDay = DateUtils.getPunchedDay(recordInDto.getEndTime());
        }
        //当日打卡记录
        if (recordInDto.getDay().equals(SysConstant.RECORD_TODAY)) {
            return Result.ok(getRecordBySomeDay(recordInDto.getActivityId(), punchedDay));
        } else {
            return Result.ok(getRecordBySomeDay(recordInDto.getActivityId(), DateUtils.getYesterdayStrBySomeDay(punchedDay)));
        }
    }

    //根据某日获取打卡人员和非打卡人员记录
    RecordOutDto getRecordBySomeDay(Integer activityId, String someDay) {
        ArrayList<UserOutDto> punchedUsers = recordMapper.getPunchedUsers(activityId, someDay);
        ArrayList<UserOutDto> notPunchedUsers = recordMapper.getNotPunchedUsers(activityId, someDay);
        RecordOutDto dto = new RecordOutDto() {{
            setPunchedUsers(punchedUsers);
            setNotPunchedUsers(notPunchedUsers);
        }};
        return dto;
    }
}
