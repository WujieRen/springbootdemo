package com.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by renwujie on 2017/12/28 at 10:31
 *
 * 使用Controller实现响应Jsp页面
 *  http://blog.csdn.net/catoop/article/details/50501676
 *
 *  1、@Controller 用来响应页面
 *  2、添加对jsp的支持
 *      ①添加pom依赖
 *      ②添加application.properties依赖
 *          # 页面默认前缀目录
 *          spring.mvc.view.prefix= /WEB-INF/jsp/
 *          # 响应页面默认后缀
 *          spring.mvc.view.suffix=.jsp
 *          ③建响应目录
 *
 */
@Controller
public class PageController {
    // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hell:Hello Renwujie}")
    private String hello = "Hello Renwujie";

    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，假如输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping(value={"/", "/index"})
    public String index(Map<String, Object> model){
        //直接返回字符串，框架会默认去 spring.view.prefix 目录下的（index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.put("time", new Date());
        model.put("message", this.hello);
        return "index";
    }


    /**
     * 响应到JSP页面page1
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping("/page1")
    public ModelAndView page1(){
        // 页面位置 /WEB-INF/jsp/page/page1.jsp
        ModelAndView mav = new ModelAndView("page/page1");
        mav.addObject("content", hello);
        return mav;
    }

    /**
     * 响应到JSP页面page1（可以直接使用Model封装内容，直接返回页面字符串）
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping("/page2")
    public String page2(Model model){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        model.addAttribute("content", hello + "（第二种）");
        return "page/page1";
    }

    @RequestMapping("/page3")
    public String page3(Model model){
        model.addAttribute("selfTest", hello+"第三种");
        model.addAttribute("content", "this is content_Attribute1");
        return "page/page1";
    }


}
