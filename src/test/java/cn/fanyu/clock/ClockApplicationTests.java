package cn.fanyu.clock;

import cn.fanyu.clock.dto.out.ActivityOutDto;
import cn.fanyu.clock.entity.User;
import cn.fanyu.clock.mapper.ActivityMapper;
import cn.fanyu.clock.service.IActivityService;
import cn.fanyu.clock.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClockApplicationTests {

    @Autowired
    private IUserService userService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setOpenid("1223");
        user.setNickName("张三");
        boolean save = userService.save(user);
        System.out.println(save);
    }

    @Test
    void getAllByUserId() {
//        Result users = activityService.getAllByUserId(1);
//        System.out.println(users.getCode());
        ActivityOutDto allByUserId = activityMapper.getAllByUserId(2);
        System.out.println(allByUserId);
    }
}
