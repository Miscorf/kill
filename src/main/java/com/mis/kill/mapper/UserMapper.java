package com.mis.kill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mis.kill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
