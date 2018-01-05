package com.springboot.jdbc;

import com.springboot.jdbc.entity.Task;
import com.springboot.jdbc.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by renwujie on 2018/01/05 at 17:45
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping("/list")
    public List<Task> getTasks(){
        logger.info("read task list from database");
        return taskService.getList();
    }


}
