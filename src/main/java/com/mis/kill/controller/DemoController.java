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

    /***********************************
     * 用途说明:
     * 返回值说明:
     ***********************************/
    
    
    @RequestMapping("hello")
    public String hello(Model model){

        model.addAttribute("name","xx");
        return "hello";
    }

}
