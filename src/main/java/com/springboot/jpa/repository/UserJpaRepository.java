package com.springboot.jpa.repository;

import com.springboot.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by renwujie on 2018/01/08 at 14:44
 */
public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
