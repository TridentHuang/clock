package cn.fanyu.clock;

import cn.fanyu.clock.dto.in.RecordInDto;
import cn.fanyu.clock.dto.out.UserOutDto;
import cn.fanyu.clock.mapper.RecordMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class RecordTests {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private IRecordService recordService;

    @Test
    void getPunchedUsers() {
        ArrayList<UserOutDto> punchedUsers = recordMapper.getPunchedUsers(1, "2019-11-27");
        System.out.println(punchedUsers.size());
    }

    @Test
    void getNotPunchedUsers() {
        ArrayList<UserOutDto> punchedUsers = recordMapper.getNotPunchedUsers(1, "2019-11-27");
        System.out.println(punchedUsers.size());
    }

    @Test
    void getData() {
        RecordInDto recordInDto = new RecordInDto() {{
            setActivityId(1);
            setDay("today");
            setEndTime("次日23:00");
        }};
        Result data = recordService.getData(recordInDto);
        System.out.println(data.getData());
    }

}