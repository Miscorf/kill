package com.mis.kill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.kill.exception.GlobalException;
import com.mis.kill.mapper.ContourConfigMapper;
import com.mis.kill.pojo.ContourConfig;
import com.mis.kill.service.ContourConfigService;
import com.mis.kill.vo.RespBean;
import com.mis.kill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Author Li HuiKun
 * @Date 2022/9/19 9:42
 **/
@Service
@Primary
public class ContourConfigServiceImpl extends ServiceImpl<ContourConfigMapper, ContourConfig> implements ContourConfigService {
    @Autowired
    private ContourConfigMapper contourConfigMapper;

    public RespBean getContourConfig(){
        ContourConfig res = contourConfigMapper.selectById(0);
        if (res==null)
            throw new GlobalException(RespBeanEnum.CONTOUR_SETTINGS_EMPTY);
        return RespBean.success(res);
    }

    @Override
    public ContourConfig getContourConfigPojo() {
        ContourConfig res = contourConfigMapper.selectById(0);
        if (res==null)
            throw new GlobalException(RespBeanEnum.CONTOUR_SETTINGS_EMPTY);

        return  res;
    }

    @Override
    public RespBean setContourConfig(ContourConfig contourConfig) {
        try{

            // System.out.println(contourConfig);
            contourConfig.setYSize( contourConfig.getXSize() );
            int bool = contourConfigMapper.updateById(contourConfig);
            if(bool == 0)
                throw new GlobalException(RespBeanEnum.CONTOUR_SETTINGS_ERROR);
        }
        catch (Exception e){
            System.out.println(e);
            throw new GlobalException(RespBeanEnum.CONTOUR_SETTINGS_ERROR);
        }
        return RespBean.success();
    }
}
