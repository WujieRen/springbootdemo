//package com.springboot.jpa.service.impl;
//
//import com.springboot.jpa.domain.User;
//import com.springboot.jpa.repository.UserJpaRepository;
//import com.springboot.jpa.repository.UserRepository;
//import com.springboot.jpa.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by renwujie on 2018/01/08 at 14:45
// */
//@Service
//@Transactional
//public class UserServiceImpl implements IUserService {
//
//    @Autowired
//    private UserJpaRepository userJpaRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public List<User> findAll() {
//        return userJpaRepository.findAll();
//    }
//
//    @Override
//    public void saveUser(User user) {
//        userJpaRepository.save(user);
//    }
//
//    @Override
//    public User findOne(int id) {
//        return userJpaRepository.findOne(id);
//    }
//
//    @Override
//    public void delete(int id) {
//        userJpaRepository.delete(id);
//    }
//
//    @Override
//    public List<User> findByName(String name) {
//        return userRepository.findByName(name);
//    }
//
//    @Override
//    public List<User> findByNameAndId(String name, Long id) {
//        return userRepository.findByNameAndId(name, id);
//    }
//
//    @Override
//    public List<User> withNameAndIdQuery(String name, Integer age) {
//        return userRepository.withNameAndIdQuery(name, age);
//    }
//
//    @Override
//    public List<User> sort() {
//        return userJpaRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
//    }
//
//    @Override
//    public Page<User> page() {
//        return userJpaRepository.findAll(new PageRequest(0, 2));
//    }
//
//
//}
