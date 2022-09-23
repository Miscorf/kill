package com.mis.kill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.kill.mapper.ContourConfigMapper;
import com.mis.kill.mapper.UserMapper;
import com.mis.kill.pojo.ContourConfig;
import com.mis.kill.pojo.User;
import com.mis.kill.vo.RespBean;

/**
 * @Author Li HuiKun
 * @Date 2022/9/19 9:41
 **/
public interface ContourConfigService extends IService<ContourConfig> {
    RespBean getContourConfig();
    ContourConfig getContourConfigPojo();
    RespBean setContourConfig(ContourConfig contourConfig);
}
