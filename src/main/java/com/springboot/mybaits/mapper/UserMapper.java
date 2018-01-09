package com.springboot.mybaits.mapper;

import com.springboot.mybaits.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by renwujie on 2018/01/09 at 10:29
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(name, address, age) values(#{name}, #{address}, #{age})")
    int insert(@Param("name") String name, @Param("address") String address, @Param("age") int age);

}
