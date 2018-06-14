//package com.springboot.jpa.controller;
//
//import com.springboot.jpa.domain.User;
//import com.springboot.jpa.service.impl.UserServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * Created by renwujie on 2018/01/08 at 11:05
// */
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    protected static Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    UserServiceImpl userService = new UserServiceImpl();
//
//    @RequestMapping("/save")
//    public void save(String name, Integer age, String sex) {
//        userService.saveUser(new User(null, name, age, sex));
//    }
//
//    @RequestMapping("/q1")
//    public List<User> q1(String name) {
//        List<User> people = userService.findByName(name);
//        return people;
//    }
//
//    @RequestMapping("/q2")
//    public List<User> q2(String name, Long id){
//        return userService.findByNameAndId(name, id);
//    }
//
//    @RequestMapping("/q3")
//    public List<User> q3(String name, Integer id){
//        return userService.withNameAndIdQuery(name, id);
//    }
//
//    @RequestMapping("/sort")
//    public List<User> sort(){
//        List<User> users = userService.sort();
//        return users;
//    }
//
//    @RequestMapping("/page")
//    public Page<User> page(){
//        Page<User> users = userService.page();
//        return users;
//    }
//
//   /* @Autowired
//    private IUserService userService;
//
//    @RequestMapping(value = "/add/{id}/{name}/{age}/{sex}")
//    public User addUser(@PathVariable int id, @PathVariable String name,
//                        @PathVariable int age, @PathVariable String sex) {
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setAge(age);
//        user.setSex(sex);
//        userService.saveUser(user);
//
//        return user;
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userService.delete(id);
//    }
//
//    @RequestMapping(value = "/")
//    public List<User> getUsers() {
//        return userService.findAll();
//    }
//
//    @RequestMapping(value = "/{id}")
//    public User getUser(@PathVariable int id) {
//        return userService.findOne(id);
//    }
//
//    @RequestMapping(value = "/search/name/{name}")
//    public List<User> getUserByName(@PathVariable String name) {
//        List<User> users = userService.findByName(name);
//        return users;
//    }*/
//
//}
