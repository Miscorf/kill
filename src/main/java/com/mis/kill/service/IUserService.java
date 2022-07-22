package com.mis.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mis.kill.pojo.User;
import com.mis.kill.vo.LoginVo;
import com.mis.kill.vo.RespBean;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
public interface IUserService extends IService<User> {

    RespBean login(LoginVo loginVo);
}
