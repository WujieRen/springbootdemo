 静态资源处理：
      - Reference：
        1. http://blog.csdn.net/catoop/article/details/50501706
        2. http://blog.csdn.net/yingxiake/article/details/51295551
        3. https://www.cnblogs.com/magicalSam/p/7189476.html
      - 默认资源映射：
        1. 默认配置的  /** 映射到  /static （或/public、/resources、/META-INF/resources）
        2. 默认配置的   /webjars/** 映射到 classpath:/META-INF/resources/webjars/
            自定义资源映射：
                方式一： 静态资源配置类，通过继承WebMvcConfigurerAdapter来实现。
                    ① 自定义目录：com.springboot.static_resource_handle.UniversalApp
                    ② 使用外部目录：
                    -》 如果要指定一个绝对路径的文件夹（如 H:/myimgs/ ）,则只需要使用 addResourceLocations 指定即可。
                    -》 可以直接使用addResourceLocations 指定磁盘绝对路径，同样 可以配置多个位置，注意路径写法需要加上file:

                        ```
                            registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
                        ```
                方式二： 通过配置文件配置。
                    参见： application.properties
      - 页面中使用

      - 使用webjars
            什么是webjars？
                web开发过程中，前端页面用了越来越多的JS或CSS，平时我们将这些Web资源 copy 在java目录下，但是这种人工 copy 的方式容易产生版本误差，copy 出错等问题。WebJars 就是将js, css 等资源文件放到 classpath:/META-INF/resources/webjars/ 中，然后打包成jar 发布到maven仓库中。能够解决上述问题。
            用法：
                用法存疑，暂时先不管了。以后遇到再说。没搞明白——按网站试着做了不行。