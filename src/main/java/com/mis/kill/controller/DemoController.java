package com.mis.kill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author Li HuiKun
 * @Date 2022/7/18 19:47
 **/

@Controller
@RequestMapping("/demo")
public class DemoController {
    
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

}
