package cn.fanyu.clock;

import cn.fanyu.clock.entity.User;
import cn.fanyu.clock.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClockApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setOpenid("1223");
        user.setNickName("张三");
        boolean save = userService.save(user);
        System.out.println(save);
    }

}
