package com.springboot.static_resource_handle.webjars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by renwujie on 2018/01/04 at 14:53
 */
@Controller
public class WebjarsJsTest {

    private String hello = "Hello Webjars_Js";

    /**
     * 响应page1页面
     *
     * @return
     */
    @RequestMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav = new ModelAndView("page/page1");
        mav.addObject("content", hello);
        return mav;
    }

    /**
     * 返回page2
     * @return
     */
    @RequestMapping("/page2")
    public String page2(Model model){
        model.addAttribute("content", hello + "(page2)");
        return "page/page1";
    }
}
