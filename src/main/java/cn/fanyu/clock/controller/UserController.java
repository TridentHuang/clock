package cn.fanyu.clock.controller;


import cn.fanyu.clock.dto.in.UserInDto;
import cn.fanyu.clock.entity.User;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public Result save(@RequestBody UserInDto userInDto) {
        System.out.println(userInDto.getCode());
        User user = new User();
        user.setNickName(userInDto.getNickName());
        user.setOpenid(userInDto.getCode());
        boolean save = userService.save(user);
        return Result.ok(user);
    }
}
