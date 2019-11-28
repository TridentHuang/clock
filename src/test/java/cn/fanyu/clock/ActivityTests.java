package cn.fanyu.clock;

import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.mapper.ActivityMapper;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivityTests {

    @Autowired
    private IActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;

    @Test
    void isAdd() {
        PunchInDto punchInDto = new PunchInDto() {{
            setActivityId(1);
            setUserId(3);
        }};
        Result add = activityService.isAdd(punchInDto);
        System.out.println(add.getData());
    }

    @Test
    void apply() {
        PunchInDto punchInDto = new PunchInDto() {{
            setActivityId(1);
            setUserId(4);
        }};
        Result apply = activityService.apply(punchInDto);
        System.out.println(apply.getData());
    }
}
