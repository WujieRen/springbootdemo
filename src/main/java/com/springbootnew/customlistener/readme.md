# SpringApplication启动原理
1. SpringApplication的启动过程较为复杂，下面是SpringApplication.run方法之后启动的关键动作:
![](https://github.com/WujieRen/springbootdemo/raw/master/src/main/resources/img/nongshalie.jpg)
> reference: http://majunwei.com/view/201708231840127244.html  
reference2: http://majunwei.com/view/201708211657187575.html

# Spring Boot的事件和监听器
> reference: http://www.majunwei.com/view/201708262210563675.html

# 开发工具
1. <a href="https://blog.csdn.net/wjc475869/article/details/52442484">自动重启</a>
>reference: https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/III.%20Using%20Spring%20Boot/20.2%20Automatic%20restart.html

# ApplicationRunner & CommandLineRunner
> reference1: https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/IV.%20Spring%20Boot%20features/23.8%20Using%20the%20ApplicationRunner%20or%20CommandLineRunner.html  
reference2: http://412887952-qq-com.iteye.com/blog/2353151  
reference3: https://blog.csdn.net/zhousenshan/article/details/79827389

1. 问题一：不生效
  - 原因：main类缺少注解@ComponentScan，添加 @ComponentScan 或 @SpringApplication 后解决。