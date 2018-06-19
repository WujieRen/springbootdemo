package com.liaokailin.helloworld;

import org.springframework.web.bind.annotation.*;

/**
 * Created by renwujie on 2018/06/19 at 10:54
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

}
