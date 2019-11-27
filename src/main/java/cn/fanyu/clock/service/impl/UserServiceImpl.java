package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.entity.User;
import cn.fanyu.clock.mapper.UserMapper;
import cn.fanyu.clock.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
