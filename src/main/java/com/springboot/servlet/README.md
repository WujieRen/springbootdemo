SpringBoot Servlet:
  http://blog.csdn.net/catoop/article/details/50501686
  
  
有个问题：DispatcherServlet 默认拦截“/”，MyServlet 拦截“/xs/*”，MyServlet2 拦截“/xs/myservlet”，那么在我们访问 http://localhost:8080/xs/myservlet 的时候系统会怎么处理呢？如果访问 http://localhost:8080/xs/abc 的时候又是什么结果呢？这里就不给大家卖关子了，其结果是“匹配的优先级是从精确到模糊，复合条件的Servlet并不会都执行”

既然系统DispatcherServlet 默认拦截“/”，那么我们是否能做修改呢，答案是肯定的，我们在SpringBootSampleApplication中添加代码：

```$xslt
    /**
     * 修改DispatcherServlet默认配置
     *
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet){
        ServletRegistrationBean registration  = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }
```
    