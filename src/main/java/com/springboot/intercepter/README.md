SpringBoor Interceptor: http://blog.csdn.net/catoop/article/details/50501696

根据输出可以了解拦截器链的执行顺序（具体原理介绍，大家找度娘一问便知）

最后强调一点：只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，比如我们自定义的Servlet地址 http://localhost:8080/xs/myservlet 是不会被拦截器拦截的。并且不管是属于哪个Servlet 只要符合过滤器的过滤规则，过滤器都会拦截。

最后说明下，我们上面用到的 WebMvcConfigurerAdapter 并非只是注册添加拦截器使用，其顾名思义是做Web配置用的，它还可以有很多其他作用，通过下面截图便可以大概了解，具体每个方法都是干什么用的，留给大家自己研究（其实都大同小异也很简单）。 