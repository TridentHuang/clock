package cn.fanyu.clock.controller;

import cn.fanyu.clock.dto.in.UserInDto;
import cn.fanyu.clock.entity.User;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version V3.0
 * @Title: UserAction
 * @Company: 成都影达科技有限公司
 * @Description: 描述
 * @author: 东进
 * @date 2019/11/26 下午6:17
 */
@RestController
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/activities/{userId}")
    public Result getUserActivitiesByUserId(@PathVariable("userId") String userId) {
        System.out.println(userId);
        User user = userService.getById(userId);
        return Result.ok(user);
    }

    @PostMapping("/save")
    public Result getUserActivitiesByUserId(@RequestBody UserInDto userInDto) {
        System.out.println(userInDto.getCode());
        //更加code获取用户openid
        //将openid和NickName存入数据库
        return null;
    }

}
