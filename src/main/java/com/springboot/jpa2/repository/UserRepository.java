package com.springboot.jpa2.repository;

import com.springboot.jpa2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by renwujie on 2018/01/08 at 16:21
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByAddress(String address);

    List<User> findByNameAndAddress(String name,String address);

    @Query("select u from User u where u.name=:name and u.address=:address")
    List<User> withNameAndAddressQuery(@Param("name")String Name, @Param("address")String address);

}
