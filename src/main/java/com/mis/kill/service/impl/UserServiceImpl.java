package com.mis.kill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.kill.mapper.UserMapper;
import com.mis.kill.pojo.User;
import com.mis.kill.service.IUserService;
import com.mis.kill.vo.LoginVo;
import com.mis.kill.vo.RespBean;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public RespBean login(LoginVo loginVo) {
        return null;
    }
}
