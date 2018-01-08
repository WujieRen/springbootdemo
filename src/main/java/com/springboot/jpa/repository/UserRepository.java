package com.springboot.jpa.repository;

import com.springboot.jpa.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by renwujie on 2018/01/08 at 14:04
 */
public interface UserRepository extends Repository<User, Integer> {

    List<User> findByNameAndId(String name, Long id);

    List<User> findByName(String name);

    @Query("select u from User u where u.name=:name and u.age=:age")
    List<User> withNameAndIdQuery(@Param("name") String name, @Param("age") Integer age);


}
