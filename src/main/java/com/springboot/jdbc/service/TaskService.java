package com.springboot.jdbc.service;

import com.springboot.jdbc.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by renwujie on 2018/01/05 at 17:34
 */
@Service
public class TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public java.util.List<Task> getList(){
        String sql = "SELECT id,name,age,sex FROM testjdbc";
        return jdbcTemplate.query(sql, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet resultSet, int i) throws SQLException {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setAge(resultSet.getInt("age"));
                task.setSex(resultSet.getString("sex"));
                return task;
            }
        });
    }

}
