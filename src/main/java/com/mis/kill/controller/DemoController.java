package com.mis.kill.controller;

import com.mis.kill.exception.GlobalException;
import com.mis.kill.pojo.ContourConfig;
import com.mis.kill.service.ContourConfigService;
import com.mis.kill.utils.LoadFile;
import com.mis.kill.vo.RespBean;
import com.mis.kill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import static com.mis.kill.vo.RespBeanEnum.FILE_NOT_FOUND;
import static com.mis.kill.vo.RespBeanEnum.READ_FAIL;

/**
 * @Author Li HuiKun
 * @Date 2022/7/18 19:47
 **/

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/contour")
public class DemoController {
    @Autowired
    private ContourConfigService contourConfigService;
    /*
     * @Author Li HuiKun 
     * @Description 测试接口
     * @Param
     * @return 
     **/
    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("name","xx");
        return "hello";
    }


    @RequestMapping("/loadContourData")
    public RespBean load_data_from_file(){
        try {
            int length = 10;
            String url = "";
            ContourConfig contourConfig = contourConfigService.getContourConfigPojo();
            if (contourConfig.getBaseUrl()!=null && contourConfig.getXSize()==contourConfig.getXSize())
                length = contourConfig.getXSize();
            if(contourConfig.getBaseUrl()!=null)
                url = contourConfig.getBaseUrl();
            ArrayList<ArrayList<Float>> data = LoadFile.BufferedReader(url,length);
            if (data.isEmpty()){
                String msg = "系统找不到指定的文件";
                return RespBean.error(FILE_NOT_FOUND);
            }

            System.out.println(data);
            return RespBean.success(data);

        }catch (Exception e){
            System.out.println(e);
            return RespBean.error(READ_FAIL,e);
        }

    }
    @RequestMapping("/setContourSettings")
    public RespBean set_contour_settings(@RequestBody ContourConfig contourConfig){
        System.out.println(contourConfig);
        return contourConfigService.setContourConfig(contourConfig);

    }
    @RequestMapping("/getContourSettings")
    public  RespBean getContourSettings(){
        return  contourConfigService.getContourConfig();

    }


}
