package com.mis.kill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.kill.exception.GlobalException;
import com.mis.kill.mapper.UserMapper;
import com.mis.kill.pojo.User;
import com.mis.kill.service.IUserService;
import com.mis.kill.utils.MD5Util;
import com.mis.kill.utils.ValidatorUtil;
import com.mis.kill.vo.LoginVo;
import com.mis.kill.vo.RespBean;
import com.mis.kill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
@Service
@Primary
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /*
     * @Author Li HuiKun
     * @Description 登录
     * @Param loginVo
     * @return respBean
     **/
    @Override
    public RespBean login(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR,null);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR,null);
        }
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null==user){
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }
        //校验密码
        if
        (!MD5Util.formPassToDBPass(password).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.BIND_ERROR);
        }
        return RespBean.success();

    }
}
